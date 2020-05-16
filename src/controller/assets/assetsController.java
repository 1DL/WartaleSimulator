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
    
    
    public java.net.URL loadImage(String filePath, String fileName) {
        return this.getClass().getResource(filePath + fileName);
    }
    
    public Icon loadTranspImage(String filePath, String fileName) {
        return addTranspBMP(filePath+fileName);
    }
    
}
