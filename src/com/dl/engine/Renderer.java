/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine;

import com.dl.engine.gfx.Font;
import com.dl.engine.gfx.Image;
import com.dl.engine.gfx.ImageTile;
import java.awt.image.DataBufferInt;

/**
 *
 * @author Luiz
 */
public class Renderer {
    private int pW, pH;
    private int[] p;
    
    private Font font = Font.STANDARD;
    
    public Renderer(GameEngine ge){
        pW = ge.getWidth();
        pH = ge.getHeight();
        p = ((DataBufferInt)ge.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }
    
    public void clear(){
        for (int i = 0; i < p.length; i++) {
            //efeito trippy!
            //p[i] += i;
            p[i] = 0;
        }
    }
    
    public void setPixel(int x, int y, int value) {
        if ((x < 0 || x >= pW || y < 0 || y >= pH)  || value == 0xffff00ff) {
            return;
        }
        
        p[x + y * pW] = value;
    }
    
    public void drawText(String text, int offX, int offY, int color) {
        
        
        text = text.toUpperCase();
        int offset = 0;
        
        for(int i = 0; i < text.length(); i++) {
            
            int unicode = text.codePointAt(i) - 32;
            
            for(int y = 0; y < font.getFontImage().getH(); y++) {
                for (int x = 0; x < font.getWidths()[unicode]; x++) {
                    if (font.getFontImage().getP()[(x + font.getOffsets()[unicode]) + y * font.getFontImage().getW()] == 0xffffffff) {
                        setPixel(x + offX + offset, y + offY, color);
                    }                    
                }
            }
            
            offset += font.getWidths()[unicode];
        }
    }
    
    public void drawImage(Image image, int offX, int offY) {
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
        
        for (int y = newY; y < newHeight; y++) {
            for (int x = newX; x < newWidth; x++) {
                setPixel(x + offX, y + offY, image.getP()[x + y * image.getW()]);
            }
        }
    }
    
    public void drawImageTile(ImageTile image, int offX, int offY, int tileX, int tileY) {
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
        
        for (int y = newY; y < newHeight; y++) {
            for (int x = newX; x < newWidth; x++) {
                setPixel(x + offX, y + offY, image.getP()[(x + tileX * image.getTileW()) + (y + tileY * image.getTileH()) * image.getW()]);
            }
        }
    }
    
    public void drawRect(int offX, int offY, int width, int height, int color) {
                
        for (int y = 0; y <= height; y++) {
            setPixel(offX, y + offY, color);
            setPixel(offX + width, y + offY, color);
        }
        
        for (int x = 0; x <= width; x++) {
            setPixel(x + offX, offY, color);
            setPixel(x + offX, offY + height, color);
        }
    }
    
    public void drawFillRect(int offX, int offY, int width, int height, int color) {
        
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
        
        for (int y = newY; y <= newHeight; y++) {
                for (int x = newX; x <= newWidth; x++) {
                    setPixel(x + offX, y + offY, color);
            }
        }
        

    }
}
