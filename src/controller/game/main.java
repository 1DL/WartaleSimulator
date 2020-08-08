/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.game;

import controller.sound.SoundFXController;
import controller.game.formula.CharacterStats;
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
    
    public static final int CAM_AUTO = 0;
    public static final int CAM_LOCK = 1;
    public static final int CAM_MANUAL = 2;

    public static boolean isRunWalk() {
        return runWalk;
    }

    public static void setRunWalk() {
       main.runWalk = !main.runWalk;
    }

    public static int getCameraMode() {
        return cameraMode;
    }

    public static void setCameraMode() {
        main.cameraMode++;
        if (main.cameraMode > 2) {
            main.cameraMode = 0;
        }
    }

    public static boolean isShowHideMap() {
        return showHideMap;
    }

    public static void setShowHideMap() {
        main.showHideMap = !main.showHideMap;
    }
    
    public static boolean runWalk = false;
    public static int cameraMode = 0;
    public static boolean showHideMap = false;
    
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
