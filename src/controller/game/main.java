/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.game;

import controller.sound.SoundFXController;
import formula.CharacterStats;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.StartupFrame;

/**
 *
 * @author LuizV1
 */
public class main {
    public static String player = "Knight";
    public static String enemy = "Knight";
    public static CharacterStats pChar;
    public static CharacterStats eChar;
    public static boolean flagBgm = true;
    public static final String version = "1.0";
    public static final String by = " - by Luiz Henrique a.k.a. DarkLink64";
    static boolean animRunning = false;
    
    
    //Sound related
    
    public static SoundFXController sfx;
    
    public static void main(String[] args) {
        
        System.setProperty("sun.java2d.opengl", "true");
        
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }
        
        

        StartupFrame window = new StartupFrame();
        window.setVisible(true);
        
        sfx = new SoundFXController();
    }
}
