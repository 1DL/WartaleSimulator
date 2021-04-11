/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.assets;

import controller.TextureWork;
import controller.game.main;
import javax.swing.Icon;

/**
 *
 * @author Luiz
 */
public class assetsController extends TextureWork {
    
    public static final String AGING_DIR = "/assets/item/aging/";
    public static final String GEARICON_DIR = "/assets/item/gearicon/";
    public static final String SKILLSFX_DIR = "/assets/sfx/skill/";
    public static final String SKILLIMG_DIR = "/assets/skills/";
    public static final String ITEMSFX_DIR = "/assets/sfx/item/";
    public static final String GUISFX_DIR = "/assets/sfx/gui/";
    public static final String WOOSHSFX_DIR = "/assets/sfx/woosh/";
    public static final String HUDIMG_DIR = "/assets/battle/hud/mainhud/";
    public static final String TOOLTIPIMG_DIR = "/assets/battle/tooltip/";
    public static final String GAME_DIR = "/assets/game/";
    public static final String GAME_FONT_DIR = "/assets/game/fonts/";
    public static final String BGM_DIR = "/assets/bgm/";
    public static final String BGM_WAV_DIR = "/assets/bgm/wav/";
    public static final String STAGES_DIR = "/assets/game/stages/";
    public static final String CHAR_SPRITES_DIR = "/assets/game/character/";
    
    //Bless Castle
    
    public static final String TILEMAP_BLESSCASTLE = "/assets/engine/tilemaps/blesscastle.png";
    public static final String COLLISION_BLESSCASTLE = "/assets/engine/collisionmaps/blesscastle.png";
    public static final String TILEMAP_BLESSCASTLE_COLLISION = "/assets/engine/tilemaps/collision_blesscastle.png";
    
    //WIP
    public static final String TILEMAP_WIP = "/assets/game/stages/stageWIP.png";
    public static final String COLLISION_WIP = "/assets/game/stages/stageWIPColision.png";
    
    
    
    
    public java.net.URL loadImage(String filePath, String fileName) {
        return this.getClass().getResource(filePath + fileName);
    }
    
    public Icon loadTranspImage(String filePath, String fileName) {
        return addTranspBMP(filePath+fileName);
    }
    
    public static String getCurrentRunWalkIcon(){
        if (main.isRunWalk()){
            return null;
        } else {
            return HUDIMG_DIR + "btnwalk.png";
        }
    }
    
    public static String getCurrentRunWalkTooltipIcon(){
        if (main.isRunWalk()){
            return TOOLTIPIMG_DIR + "tooltiprun.png";
        } else {
            return TOOLTIPIMG_DIR + "tooltipwalk.png";
        }
    }
    
    public static String getCurrentShowHideMapIcon(){
        if (main.isShowHideMap()){
            return HUDIMG_DIR + "btnmap.png";
        } else {
            return null;
        }
    }
    
    public static String getCurrentShowHideMapTooltipIcon(){
        if (main.isShowHideMap()){
            return TOOLTIPIMG_DIR + "tooltipmap.png";
        } else {
            return TOOLTIPIMG_DIR + "tooltipmapoff.png";
        }
    }
    
    public static String getCurrentCameraModeIcon(){
        switch(main.getCameraMode()) {
            case main.CAM_AUTO:
                return HUDIMG_DIR + "btncameraauto.png";
            case main.CAM_LOCK:
                return HUDIMG_DIR + "btncameralock.png";
            default:
                return null;
        }
    }
    
    public static String getCurrentCameraModeTooltipIcon(){
        switch(main.getCameraMode()) {
            case main.CAM_AUTO:
                return TOOLTIPIMG_DIR + "tooltipautocamera.png";
            case main.CAM_LOCK:
                return TOOLTIPIMG_DIR + "tooltipfixedcamera.png";
            default:
                return TOOLTIPIMG_DIR + "tooltipmanualcamera.png";
        }
    }
        
}
