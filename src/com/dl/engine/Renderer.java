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
    
    private int pW, pH;
    private int[] p;
    private int[] zBuffer;
    
    private int zDepth = 0;
    private boolean processing = false;
    
    public Renderer(GameEngine ge)
    {
        pW = ge.getWidth();
        pH = ge.getHeight();
        p = ((DataBufferInt)ge.getWindow().getImage().getRaster().getDataBuffer()).getData();
        zBuffer = new int [p.length];
    }
    
    public void clear()
    {
        for (int i = 0; i < p.length; i++)
        {
            //efeito trippy!
            //p[i] += i;
            p[i] = 0;
            zBuffer[i] = 0;
        }
    }
    
    public void process() 
    {
        processing = true;
        
        Collections.sort(imageRequest, new Comparator<ImageRequest>(){
            @Override
            public int compare(ImageRequest ir0, ImageRequest ir1)
            {
                if(ir0.zDepth < ir1.zDepth)
                {
                    return -1;
                }
                if(ir0.zDepth > ir1.zDepth)
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
        
        imageRequest.clear();
        processing = false;
    }
    
    public void setPixel(int x, int y, int value)
    {
        int alpha = ((value >> 24) & 0xff);
        
        if ((x < 0 || x >= pW || y < 0 || y >= pH)  || alpha == 0 ) 
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
        }
        else
        {
            int pixelColor = p[x + y * pW];
            
            int newRed =    ((pixelColor >> 16) & 0xff) - (int)((((pixelColor >> 16) & 0xff) - ((value >> 16) & 0xff)) * (alpha / 255f));
            int newGreen =  ((pixelColor >> 8 ) & 0xff) - (int)((((pixelColor >> 8 ) & 0xff) - ((value >> 8 ) & 0xff)) * (alpha / 255f));
            int newBlue =   ( pixelColor        & 0xff) - (int)((( pixelColor        & 0xff) - ( value        & 0xff)) * (alpha / 255f));
            
            p[index] = (255 << 24 | newRed << 16 | newGreen << 8 | newBlue);
        }        
    }
    
    public void drawText(String text, int offX, int offY, int color) 
    {
        int offset = 0;
        
        for(int i = 0; i < text.length(); i++) 
        {   
            int unicode = text.codePointAt(i);
            
            for(int y = 0; y < font.getFontImage().getH(); y++)
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
        if (image.isAlpha() && !processing) 
        {
            imageRequest.add(new ImageRequest(image, zDepth, offX, offY));
            return;
        }
        
        //Cancela renderização ao todo caso imagem esteja fora da tela
        if (offX < -image.getW()) return;
        if (offY < -image.getH()) return;
        if (offX >= pW) return;
        if (offY >= pH) return;
        
        int newX = 0;
        int newY = 0;
        int newWidth = image.getW();
        int newHeight = image.getH();
        
        //Renderiza apenas a parte visivel e descarta os pixels fora da tela, em
        //imagens parcialmente fora da tela
        
        if(offX < 0) {newX -= offX;}
        if(offY < 0) {newY -= offY;}        
        if(newWidth + offX >= pW) {newWidth -= newWidth + offX - pW;}
        if(newHeight + offY >= pH) {newHeight -= newHeight + offY - pH;}
        
        for (int y = newY; y < newHeight; y++)
        {
            for (int x = newX; x < newWidth; x++)
            {
                setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
            }
        }
    }
    
    public void drawImageTile(ImageTile image, int offX, int offY, int tileX, int tileY)
    {
        if (image.isAlpha() && !processing) 
        {
            imageRequest.add(new ImageRequest(image.getTileImage(tileX, tileY), zDepth, offX, offY));
            return;
        }
        
        //Cancela renderização ao todo caso imagem esteja fora da tela
        if (offX < -image.getTileW()) return;
        if (offY < -image.getTileH()) return;
        if (offX >= pW) return;
        if (offY >= pH) return;
        
        int newX = 0;
        int newY = 0;
        int newWidth = image.getTileW();
        int newHeight = image.getTileH();
        
        //Renderiza apenas a parte visivel e descarta os pixels fora da tela, em
        //imagens parcialmente fora da tela
        
        if(offX < 0) {newX -= offX;}
        if(offY < 0) {newY -= offY;}        
        if(newWidth + offX >= pW) {newWidth -= newWidth + offX - pW;}
        if(newHeight + offY >= pH) {newHeight -= newHeight + offY - pH;}
        
        for (int y = newY; y < newHeight; y++)
        {
            for (int x = newX; x < newWidth; x++)
            {
                setPixel(x + offX, y + offY, image.getP()[(x + tileX * image.getTileW()) + (y + tileY * image.getTileH()) * image.getW()]);
            }
        }
    }
    
    public void drawRect(int offX, int offY, int width, int height, int color)
    {
                
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
    
    public void drawFillRect(int offX, int offY, int width, int height, int color)
    {
        
        //Cancela renderização ao todo caso imagem esteja fora da tela
        if (offX < -width) return;
        if (offY < -height) return;
        if (offX >= pW) return;
        if (offY >= pH) return;
        
        int newX = 0;
        int newY = 0;
        int newWidth = width;
        int newHeight = height;
        
        //Renderiza apenas a parte visivel e descarta os pixels fora da tela, em
        //imagens parcialmente fora da tela
        
        if(offX < 0) {newX -= offX;}
        if(offY < 0) {newY -= offY;}        
        if(newWidth + offX >= pW) {newWidth -= newWidth + offX - pW;}
        if(newHeight + offY >= pH) {newHeight -= newHeight + offY - pH;}
        
        for (int y = newY; y < newHeight; y++)
        {
            for (int x = newX; x < newWidth; x++)
            {
                setPixel(x + offX, y + offY, color);
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
}
