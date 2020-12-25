/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.gfx;

import controller.assets.assetsController;

/**
 *
 * @author Luiz
 */
public class Font {
    
    public static final Font STANDARD = new Font(assetsController.GAME_FONT_DIR + "standard.png");
    
    private Image fontImage;
    private int[] offsets;
    private int[] widths;
    
    public Font (String path) {
        fontImage = new Image(path);
        
        offsets = new int[59];
        widths = new int[59];
        
        int unicode = 0;
        
        for (int i = 0; i < fontImage.getW(); i++) {
            if (fontImage.getP()[i] == 0xff0000ff) {
                offsets[unicode] = i;
            }
            
            if (fontImage.getP()[i] == 0xffffff00) {
                widths[unicode] = i - offsets[unicode];
                unicode++;
                
            }
        }
    }

    public Image getFontImage() {
        return fontImage;
    }

    public int[] getOffsets() {
        return offsets;
    }

    public int[] getWidths() {
        return widths;
    }
    
    
}
