/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.assets;

import controller.TextureWork;
import javax.swing.Icon;

/**
 *
 * @author Luiz
 */
public class assetsController extends TextureWork{
    public static final String AGING_DIR = "/assets/item/aging/";
    public static final String GEARICON_DIR = "/assets/item/gearicon/";
    public static final String SKILLSFX_DIR = "/assets/sfx/skill/";
    public static final String SKILLIMG_DIR = "/assets/skills/";
    public static final String ITEMSFX_DIR = "/assets/sfx/item/";
    public static final String GUISFX_DIR = "/assets/sfx/gui/";
    public static final String WOOSHSFX_DIR = "/assets/sfx/woosh/";
    
    
    public java.net.URL loadImage(String filePath, String fileName) {
        return this.getClass().getResource(filePath + fileName);
    }
    
    public Icon loadTranspImage(String filePath, String fileName) {
        return addTranspBMP(filePath+fileName);
    }
    
    
}
