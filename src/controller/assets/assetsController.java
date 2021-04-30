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
    
    //musics
    
    public static final String BGM_HUNTER_ENDING = BGM_WAV_DIR + "Hunter X Hunter - Kaze No Uta Instrumental - ORIGINAL SONG" + ".wav";
    public static final String BGM_TEMPORSCHE = BGM_WAV_DIR + "temporsche" + ".wav";
    
    //sound effects
    
    public static final String SFX_EFFECT_SPAWN = "/assets/sfx/effects/spawn.wav";
    public static final String SFX_EFFECT_SPAWN_END = "/assets/sfx/effects/hosound.wav";  
    
    //Debug
    
    public static final String ICON_MIC = "/assets/debug/microphone_01.png";
    public static final String ICON_SPEAKER = "/assets/debug/speaker_01.png";
    public static final String SPRITE_TRAININGLOG = "/assets/debug/training_log_01.png";
    
    //Footsteps
    public static final String SFX_FOOTSTEP_GRASS_01 = "/assets/sfx/effects/footsteps/step01.wav";  
    public static final String SFX_FOOTSTEP_GRASS_02 = "/assets/sfx/effects/footsteps/step02.wav";   
    public static final String SFX_FOOTSTEP_WATER_01 = "/assets/sfx/effects/footsteps/inwater 1.wav";   
    public static final String SFX_FOOTSTEP_WATER_02 = "/assets/sfx/effects/footsteps/inwater 2.wav";  
    public static final String SFX_FOOTSTEP_WATER_03 = "/assets/sfx/effects/footsteps/inwater 3.wav";  
    public static final String SFX_FOOTSTEP_STONE_01 = "/assets/sfx/effects/footsteps/stonerun1.wav";  
    public static final String SFX_FOOTSTEP_STONE_02 = "/assets/sfx/effects/footsteps/stonerun2.wav";  
    public static final String SFX_FOOTSTEP_STONE_03 = "/assets/sfx/effects/footsteps/stonerun3.wav";  
    public static final String SFX_FOOTSTEP_STONE_DUN_01 = "/assets/sfx/effects/footsteps/stone-dun1.wav";  
    public static final String SFX_FOOTSTEP_STONE_DUN_02 = "/assets/sfx/effects/footsteps/stone-dun2.wav";  
    public static final String SFX_FOOTSTEP_STONE_DUN_03 = "/assets/sfx/effects/footsteps/stone-dun3.wav"; 
    public static final String SFX_FOOTSTEP_SAND_01 = "/assets/sfx/effects/footsteps/sand01.wav"; 
    public static final String SFX_FOOTSTEP_SAND_02 = "/assets/sfx/effects/footsteps/sand02.wav"; 
    public static final String SFX_FOOTSTEP_SAND_03 = "/assets/sfx/effects/footsteps/sand03.wav"; 
    public static final String SFX_FOOTSTEP_WOOD_01 = "/assets/sfx/effects/footsteps/wood01.wav";
    public static final String SFX_FOOTSTEP_WOOD_02 = "/assets/sfx/effects/footsteps/wood02.wav";
    public static final String SFX_FOOTSTEP_WOOD_03 = "/assets/sfx/effects/footsteps/wood03.wav";
    public static final String SFX_FOOTSTEP_WOOD_04 = "/assets/sfx/effects/footsteps/wood04.wav";
    public static final String SFX_FOOTSTEP_WOOD_05 = "/assets/sfx/effects/footsteps/wood05.wav";
    
    public static final String CURSOR_DEFAULT = "/assets/cursor/pointer_01.png";
    
    //Bless Castle
    
    public static final String TILEMAP_BLESSCASTLE = "/assets/engine/tilemaps/blesscastle.png";
    public static final String COLLISION_BLESSCASTLE = "/assets/engine/collisionmaps/blesscastle.png";
    public static final String TILEMAP_BLESSCASTLE_COLLISION = "/assets/engine/tilemaps/collision_blesscastle.png";
    
    //WIP
    public static final String TILEMAP_WIP = "/assets/game/stages/stageWIP.png";
    public static final String COLLISION_WIP = "/assets/game/stages/stageWIPColision.png";
    
    //Character Sprite Sheet
    
    public static final String SPRITE_SHEET_MOVE_KS = "/assets/engine/character/spritesheet/knight_movement.png";
    
    
    
    
    
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
