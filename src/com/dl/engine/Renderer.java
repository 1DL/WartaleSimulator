/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine;

import com.dl.engine.gfx.Font;
import com.dl.engine.gfx.Image;
import com.dl.engine.gfx.ImageRequest;
import com.dl.engine.gfx.ImageTile;
import com.dl.engine.gfx.Light;
import com.dl.engine.gfx.LightRequest;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Luiz
 */
public class Renderer
{

    private Font font = Font.STANDARD;
    private ArrayList<ImageRequest> imageRequest = new ArrayList<ImageRequest>();
    private ArrayList<LightRequest> lightRequest = new ArrayList<LightRequest>();

    private int pW, pH;
    private int[] p;
    private int[] zBuffer;

    private int[] lightMap;
    private int[] lightBlock;

    private int ambientColor = 0xff232323;
    private int zDepth = 0;
    private boolean processing = false;
    private int camX;
    private int camY;

    public Renderer(GameEngine ge)
    {
        pW = ge.getWidth();
        pH = ge.getHeight();
        p = ((DataBufferInt) ge.getWindow().getImage().getRaster().getDataBuffer()).getData();
        zBuffer = new int[p.length];
        lightMap = new int[p.length];
        lightBlock = new int[p.length];
    }

    public void clear()
    {
        for (int i = 0; i < p.length; i++)
        {
            //efeito trippy!
            //p[i] += i;
            p[i] = 0;
            zBuffer[i] = 0;
            lightMap[i] = ambientColor;
            lightBlock[i] = 0;
        }
    }

    public void process()
    {
        processing = true;

        Collections.sort(imageRequest, new Comparator<ImageRequest>()
        {
            @Override
            public int compare(ImageRequest ir0, ImageRequest ir1)
            {
                if (ir0.zDepth < ir1.zDepth)
                {
                    return -1;
                }
                if (ir0.zDepth > ir1.zDepth)
                {
                    return 1;
                }

                return 0;
            }
        });

        for (int i = 0; i < imageRequest.size(); i++)
        {
            ImageRequest ir = imageRequest.get(i);
            setzDepth(ir.zDepth);
            drawImage(ir.image, ir.offX, ir.offY);
        }

        //Renderiza o Lighting
        for (int i = 0; i < lightRequest.size(); i++)
        {
            LightRequest lr = lightRequest.get(i);
            drawLightRequest(lr.light, lr.locX, lr.locY);
        }

        for (int i = 0; i < p.length; i++)
        {
            float r = ((lightMap[i] >> 16) & 0xff) / 255f;
            float g = ((lightMap[i] >> 8) & 0xff) / 255f;
            float b = (lightMap[i] & 0xff) / 255f;

            p[i] = ((int) (((p[i] >> 16) & 0xff) * r) << 16
                    | (int) (((p[i] >> 8) & 0xff) * g) << 8
                    | (int) ((p[i] & 0xff) * b));
        }

        imageRequest.clear();
        lightRequest.clear();
        processing = false;
    }

    public void setPixel(int x, int y, int value)
    {
        int alpha = ((value >> 24) & 0xff);

        if ((x < 0 || x >= pW || y < 0 || y >= pH) || alpha == 0)
        {
            return;
        }

        int index = x + y * pW;

        if (zBuffer[index] > zDepth)
        {
            return;
        }

        zBuffer[index] = zDepth;

        if (alpha == 255)
        {
            p[index] = value;
        } else
        {
            int pixelColor = p[x + y * pW];

            int newRed = ((pixelColor >> 16) & 0xff) - (int) ((((pixelColor >> 16) & 0xff) - ((value >> 16) & 0xff)) * (alpha / 255f));
            int newGreen = ((pixelColor >> 8) & 0xff) - (int) ((((pixelColor >> 8) & 0xff) - ((value >> 8) & 0xff)) * (alpha / 255f));
            int newBlue = (pixelColor & 0xff) - (int) (((pixelColor & 0xff) - (value & 0xff)) * (alpha / 255f));

            p[index] = (newRed << 16 | newGreen << 8 | newBlue);
        }
    }

    public void setLightMap(int x, int y, int value)
    {
        if (x < 0 || x >= pW || y < 0 || y >= pH)
        {
            return;
        }

        int baseColor = lightMap[x + y * pW];

        int maxRed = Math.max((baseColor >> 16) & 0xff, (value >> 16) & 0xff);
        int maxGreen = Math.max((baseColor >> 8) & 0xff, (value >> 8) & 0xff);
        int maxBlue = Math.max(baseColor & 0xff, value & 0xff);

        lightMap[x + y * pW] = (maxRed << 16 | maxGreen << 8 | maxBlue);
    }

    public void setLightBlock(int x, int y, int value)
    {
        if (x < 0 || x >= pW || y < 0 || y >= pH)
        {
            return;
        }

        if (zBuffer[x + y * pW] > zDepth)
        {
            return;
        }

        lightBlock[x + y * pW] = value;
    }

    public void drawText(String text, int offX, int offY, int color)
    {
        offX -= camX;
        offY -= camY;

        int offset = 0;

        for (int i = 0; i < text.length(); i++)
        {
            int unicode = text.codePointAt(i);

            for (int y = 0; y < font.getFontImage().getH(); y++)
            {
                for (int x = 0; x < font.getWidths()[unicode]; x++)
                {
                    if (font.getFontImage().getP()[(x + font.getOffsets()[unicode]) + y * font.getFontImage().getW()] == 0xffffffff)
                    {
                        setPixel(x + offX + offset, y + offY, color);
                    }
                }
            }
            offset += font.getWidths()[unicode];
        }
    }

    public void drawImage(Image image, int offX, int offY)
    {
        offX -= camX;
        offY -= camY;

        if (image.isAlpha() && !processing)
        {
            imageRequest.add(new ImageRequest(image, zDepth, offX, offY));
            return;
        }

        //Cancela renderização ao todo caso imagem esteja fora da tela
        if (offX < -image.getW())
        {
            return;
        }
        if (offY < -image.getH())
        {
            return;
        }
        if (offX >= pW)
        {
            return;
        }
        if (offY >= pH)
        {
            return;
        }

        int newX = 0;
        int newY = 0;
        int newWidth = image.getW();
        int newHeight = image.getH();

        //Renderiza apenas a parte visivel e descarta os pixels fora da tela, em
        //imagens parcialmente fora da tela
        if (offX < 0)
        {
            newX -= offX;
        }
        if (offY < 0)
        {
            newY -= offY;
        }
        if (newWidth + offX >= pW)
        {
            newWidth -= newWidth + offX - pW;
        }
        if (newHeight + offY >= pH)
        {
            newHeight -= newHeight + offY - pH;
        }

        for (int y = newY; y < newHeight; y++)
        {
            for (int x = newX; x < newWidth; x++)
            {
                setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
                setLightBlock(x + offX, y + offY, image.getLightBlock());
            }
        }
    }

    public void drawImageTile(ImageTile image, int offX, int offY, int tileX, int tileY)
    {
        offX -= camX;
        offY -= camY;

        if (image.isAlpha() && !processing)
        {
            imageRequest.add(new ImageRequest(image.getTileImage(tileX, tileY), zDepth, offX, offY));
            return;
        }

        //Cancela renderização ao todo caso imagem esteja fora da tela
        if (offX < -image.getTileW())
        {
            return;
        }
        if (offY < -image.getTileH())
        {
            return;
        }
        if (offX >= pW)
        {
            return;
        }
        if (offY >= pH)
        {
            return;
        }

        int newX = 0;
        int newY = 0;
        int newWidth = image.getTileW();
        int newHeight = image.getTileH();

        //Renderiza apenas a parte visivel e descarta os pixels fora da tela, em
        //imagens parcialmente fora da tela
        if (offX < 0)
        {
            newX -= offX;
        }
        if (offY < 0)
        {
            newY -= offY;
        }
        if (newWidth + offX >= pW)
        {
            newWidth -= newWidth + offX - pW;
        }
        if (newHeight + offY >= pH)
        {
            newHeight -= newHeight + offY - pH;
        }

        for (int y = newY; y < newHeight; y++)
        {
            for (int x = newX; x < newWidth; x++)
            {
                setPixel(x + offX, y + offY, image.getP()[(x + tileX * image.getTileW()) + (y + tileY * image.getTileH()) * image.getW()]);
                setLightBlock(x + offX, y + offY, image.getLightBlock());
            }
        }
    }

    public void drawLine(int x0, int y0, int x1, int y1, int color)
    {
        x0 -= camX;
        y0 -= camY;
        x1 -= camX;
        y1 -= camY;

        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);

        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;

        int err = dx - dy;
        int e2;

        while (true)
        {

            setPixel(x0, y0, color);

            if (x0 == x1 && y0 == y1)
            {
                break;
            }

            e2 = 2 * err;

            if (e2 > -1 * dy)
            {
                err -= dy;
                x0 += sx;
            }

            if (e2 < dx)
            {
                err += dx;
                y0 += sy;
            }
        }
    }

    public void drawCircle(int x_centre, int y_centre, int r, int color)
    {
        x_centre -= camX;
        y_centre -= camY;

        int pixelX = 0;
        int pixelY = 0;

        int x = r, y = 0;
        // Printing the initial point
        // on the axes after translation
        setPixel((x + x_centre), (y + y_centre), color);
        // When radius is zero only a single
        // point will be printed
        if (r > 0)
        {

            setPixel((x_centre), (r + y_centre), color);
            setPixel((r + x_centre), (y_centre), color);
            setPixel((x_centre), (-r + y_centre), color);
            setPixel((-r + x_centre), (y_centre), color);
        }

        // Initialising the value of P
        int P = 1 - r;
        while (x > y)
        {
            y++;

            // Mid-point is inside or on the perimeter
            if (P <= 0)
            {
                P = P + 2 * y + 1;
            } // Mid-point is outside the perimeter
            else
            {
                x--;
                P = P + 2 * y - 2 * x + 1;
            }

            // All the perimeter points have already 
            // been printed
            if (x < y)
            {
                break;
            }

            // Printing the generated point and its 
            // reflection in the other octants after
            // translation
            setPixel((x + x_centre), (y + y_centre), color);
            setPixel((-x + x_centre), (y + y_centre), color);
            setPixel((x + x_centre), (-y + y_centre), color);
            setPixel((-x + x_centre), (-y + y_centre), color);

            // If the generated point is on the 
            // line x = y then the perimeter points
            // have already been printed
            if (x != y)
            {
                setPixel((y + x_centre), (x + y_centre), color);
                setPixel((-y + x_centre), (x + y_centre), color);
                setPixel((y + x_centre), (-x + y_centre), color);
                setPixel((-y + x_centre), (-x + y_centre), color);
            }
        }

    }

    public void drawEllipse(int xc, int yc, int rx, int ry, int color)
    {

        xc -= camX;
        yc -= camY;
        
        int dx, dy, d1, d2, x, y;
        x = 0;
        y = ry;

        // Initial decision parameter of region 1
        d1 = (int) ((ry * ry) - (rx * rx * ry)
                + (0.25f * rx * rx));
        dx = 2 * ry * ry * x;
        dy = 2 * rx * rx * y;

        // For region 1
        while (dx < dy)
        {

            // Print points based on 4-way symmetry
            setPixel((x + xc), (y + yc), color);
            setPixel((-x + xc), (y + yc), color);
            setPixel((x + xc), (-y + yc), color);
            setPixel((-x + xc), (-y + yc), color);

            // Checking and updating value of
            // decision parameter based on algorithm
            if (d1 < 0)
            {
                x++;
                dx = dx + (2 * ry * ry);
                d1 = d1 + dx + (ry * ry);
            } else
            {
                x++;
                y--;
                dx = dx + (2 * ry * ry);
                dy = dy - (2 * rx * rx);
                d1 = d1 + dx - dy + (ry * ry);
            }
        }

        // Decision parameter of region 2
        d2 = (int) (((ry * ry) * ((x + 0.5f) * (x + 0.5f)))
                + ((rx * rx) * ((y - 1) * (y - 1)))
                - (rx * rx * ry * ry));

        // Plotting points of region 2
        while (y >= 0)
        {

            // printing points based on 4-way symmetry

            setPixel((x + xc), (y + yc), color);
            setPixel((-x + xc), (y + yc), color);
            setPixel((x + xc), (-y + yc), color);
            setPixel((-x + xc), (-y + yc), color);
            
            // Checking and updating parameter
            // value based on algorithm
            if (d2 > 0)
            {
                y--;
                dy = dy - (2 * rx * rx);
                d2 = d2 + (rx * rx) - dy;
            } else
            {
                y--;
                x++;
                dx = dx + (2 * ry * ry);
                dy = dy - (2 * rx * rx);
                d2 = d2 + dx - dy + (rx * rx);
            }
        }
    }

    public void drawRect(int offX, int offY, int width, int height, int color)
    {
        offX -= camX;
        offY -= camY;

        for (int y = 0; y <= height; y++)
        {
            setPixel(offX, y + offY, color);
            setPixel(offX + width, y + offY, color);
        }

        for (int x = 0; x <= width; x++)
        {
            setPixel(x + offX, offY, color);
            setPixel(x + offX, offY + height, color);
        }
    }

    /**
     * Draws a filled rectangle. Coordinates are based on level map, not on
     * screen resolution.
     *
     * @param offX X coordinate to render
     * @param offY Y coordinate
     * @param width Width of the rectangle in pixels
     * @param height Height of the retancle in pixels
     * @param color Full color in HEX, example, 0xffff0000 for red.
     */
    public void drawFillRect(int offX, int offY, int width, int height, int color)
    {
        offX -= camX;
        offY -= camY;

        //Cancela renderização ao todo caso imagem esteja fora da tela
        if (offX < -width)
        {
            return;
        }
        if (offY < -height)
        {
            return;
        }
        if (offX >= pW)
        {
            return;
        }
        if (offY >= pH)
        {
            return;
        }

        int newX = 0;
        int newY = 0;
        int newWidth = width;
        int newHeight = height;

        //Renderiza apenas a parte visivel e descarta os pixels fora da tela, em
        //imagens parcialmente fora da tela
        if (offX < 0)
        {
            newX -= offX;
        }
        if (offY < 0)
        {
            newY -= offY;
        }
        if (newWidth + offX >= pW)
        {
            newWidth -= newWidth + offX - pW;
        }
        if (newHeight + offY >= pH)
        {
            newHeight -= newHeight + offY - pH;
        }

        for (int y = newY; y < newHeight; y++)
        {
            for (int x = newX; x < newWidth; x++)
            {
                setPixel(x + offX, y + offY, color);
            }
        }
    }

    public void drawLight(Light l, int offX, int offY)
    {
        lightRequest.add(new LightRequest(l, offX, offY));
    }

    private void drawLightRequest(Light l, int offX, int offY)
    {
        offX -= camX;
        offY -= camY;

        for (int i = 0; i <= l.getDiameter(); i++)
        {
            drawLightLine(l, l.getRadius(), l.getRadius(), i, 0, offX, offY);
            drawLightLine(l, l.getRadius(), l.getRadius(), i, l.getDiameter(), offX, offY);
            drawLightLine(l, l.getRadius(), l.getRadius(), 0, i, offX, offY);
            drawLightLine(l, l.getRadius(), l.getRadius(), l.getDiameter(), i, offX, offY);
        }
    }

    private void drawLightLine(Light l, int x0, int y0, int x1, int y1, int offX, int offY)
    {
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);

        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;

        int err = dx - dy;
        int e2;

        while (true)
        {
            int screenX = x0 - l.getRadius() + offX;
            int screenY = y0 - l.getRadius() + offY;

            if (screenX < 0 || screenX >= pW || screenY < 0 || screenY >= pH)
            {
                return;
            }

            int lightColor = l.getLightvalue(x0, y0);
            if (lightColor == 0)
            {
                return;
            }
            if (lightBlock[screenX + screenY * pW] == Light.FULL)
            {
                return;
            }

            setLightMap(screenX, screenY, lightColor);

            if (x0 == x1 && y0 == y1)
            {
                break;
            }

            e2 = 2 * err;

            if (e2 > -1 * dy)
            {
                err -= dy;
                x0 += sx;
            }

            if (e2 < dx)
            {
                err += dx;
                y0 += sy;
            }
        }
    }

    public int getzDepth()
    {
        return zDepth;
    }

    public void setzDepth(int zDepth)
    {
        this.zDepth = zDepth;
    }

    public int getAmbientColor()
    {
        return ambientColor;
    }

    public void setAmbientColor(int ambientColor)
    {
        this.ambientColor = ambientColor;
    }

    public int getCamX()
    {
        return camX;
    }

    public void setCamX(int camX)
    {
        this.camX = camX;
    }

    public int getCamY()
    {
        return camY;
    }

    public void setCamY(int camY)
    {
        this.camY = camY;
    }

}
