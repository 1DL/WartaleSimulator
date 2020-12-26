/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.gfx;

/**
 *
 * @author Luiz
 */
public class ImageRequest {
    
    public Image image;
    public int zDepth;
    public int offX;
    public int offY;
    
    public ImageRequest(Image image, int zDepth, int offX, int offY) {
        
        this.image = image;
        this.zDepth = zDepth;
        this.offX = offX;
        this.offY = offY;
        
    }
    
}
