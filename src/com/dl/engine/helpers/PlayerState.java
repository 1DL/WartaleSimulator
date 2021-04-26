/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.helpers;

import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
import com.dl.engine.audio.SoundClip;
import com.dl.engine.game.GameManager;
import com.dl.engine.game.objects.Player;
import com.dl.engine.gfx.ImageTile;
import controller.assets.assetsController;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Luiz
 */
public class PlayerState
{

    static final int ACTION_IDLE = 0;
    static final int ACTION_SPAWNING = 1;
    static final int ACTION_WALKING = 2;
    static final int ACTION_RUNNING = 3;

    private int currentState;

    private float currentFrame = 0;
    private float playBackSpeed = 1f;
    private int tileY = 0;
    private int tileX = 0;
    private String spriteSheetDir;

    private ImageTile movementImage;
    private ImageTile activeImage;
    private Point mousePoint;
    
    protected Player player;
    
    private SoundClip sfx_spawn = new SoundClip(assetsController.SFX_EFFECT_SPAWN);
    private SoundClip sfx_spawn_end = new SoundClip(assetsController.SFX_EFFECT_SPAWN_END);
    private SoundClip sfx_footstep_grass_01 = new SoundClip(assetsController.SFX_FOOTSTEP_GRASS_01);
    private SoundClip sfx_footstep_grass_02 = new SoundClip(assetsController.SFX_FOOTSTEP_GRASS_02);
    public PlayerState(Player player)
    {
        this.player = player;
        this.currentState = ACTION_SPAWNING;
        movementImage = new ImageTile(player.getMovementSheetDir(), 32, 48);
        activeImage = movementImage;
        mousePoint = new Point();
        
    }

    public void update(GameEngine ge, GameManager gm, float deltaTime)
    {
        currentFrame = currentFrame + 1f * playBackSpeed;
        switch (currentState)
        {
            case ACTION_SPAWNING:
                activeImage = movementImage;
                tileY = player.getSpriteAngle();
                switch ((int) currentFrame)
                {
                    case 2:
                        sfx_spawn.play();
                    case 900:
                        sfx_spawn_end.play();
                        currentState = ACTION_IDLE;
                        currentFrame = 0;
                    break;
                }
            break;
            case ACTION_IDLE:
                activeImage = movementImage;
                tileY = player.getSpriteAngle();
                switch ((int) currentFrame)
                {
                    case 1:
                        tileX = 0;
                    break;
                    case 20:
                        tileX = 1;
                    break;
                    case 40:
                        tileX = 0;
                        currentFrame = 0;
                    break;
                }

                if (ge.getInput().isButtonDown(MouseEvent.BUTTON1))
                {
                    if (player.isRun()) {
                        currentState = ACTION_RUNNING;
                    } else {
                        currentState = ACTION_WALKING;
                    }
                    currentFrame = 0;
                    mousePoint.x = ge.getInput().getMouseX();
                    mousePoint.y = ge.getInput().getMouseY();
                }
            break;
            case ACTION_WALKING:
                activeImage = movementImage;
                tileY = player.getSpriteAngle();
                
                mousePoint.x = ge.getInput().getMouseX();
                mousePoint.y = ge.getInput().getMouseY();
                player.move(gm, deltaTime, mousePoint);
                
                switch ((int) currentFrame)
                {
                    case 1:
                        tileX = 1;
                        gm.playFootstep(player.getTileX(), player.getTileY());
                    break;
                    case 6:
                        tileX = 2;
                    break;
                    case 12:
                        tileX = 3;
                    break;
                    case 18:
                        tileX = 2;
                    break;
                    case 24:
                        tileX = 1;
                        gm.playFootstep(player.getTileX(), player.getTileY());
                    break;
                    case 30:
                        tileX = 4;
                    break;
                    case 36:
                        tileX = 5;
                    break;
                    case 42:
                        tileX = 4;
                    break;
                    case 48:
                        tileX = 1;
                        currentFrame = 0;
                    break;
                }
                
                if (player.isRun()){
                    currentState = ACTION_RUNNING;
                    currentFrame = 0;
                }
                
                if (ge.getInput().isButtonUp(MouseEvent.BUTTON1)){
                    currentState = ACTION_IDLE;
                    currentFrame = 0;
                }
                
            break;
            case ACTION_RUNNING:
                activeImage = movementImage;
                tileY = player.getSpriteAngle();
                
                mousePoint.x = ge.getInput().getMouseX();
                mousePoint.y = ge.getInput().getMouseY();
                player.move(gm, deltaTime, mousePoint);
                
                switch ((int) currentFrame)
                {
                    case 1:
                        tileX = 1;
                        gm.playFootstep(player.getTileX(), player.getTileY());
                    break;
                    case 3:
                        tileX = 2;
                    break;
                    case 6:
                        tileX = 3;
                    break;
                    case 9:
                        tileX = 2;
                    break;
                    case 12:
                        tileX = 1;
                        gm.playFootstep(player.getTileX(), player.getTileY());
                    break;
                    case 15:
                        tileX = 4;
                    break;
                    case 18:
                        tileX = 5;
                    break;
                    case 21:
                        tileX = 4;
                        
                    break;
                    case 24:
                        tileX = 1;
                        currentFrame = 0;
                    break;
                }
                
                if (!player.isRun()){
                    currentState = ACTION_WALKING;
                    currentFrame = 0;
                }
                
                if (ge.getInput().isButtonUp(MouseEvent.BUTTON1)){
                    currentState = ACTION_IDLE;
                    currentFrame = 0;
                }
                
            break;
            
        }
    }
    
    public void render(GameEngine ge, Renderer r)
    {
        
        r.drawImageTile(activeImage, (int) player.getPosX(), (int) player.getPosY() - 5, (int) tileX, tileY);
    }

    public int getCurrentState()
    {
        return currentState;
    }
    
    public String getCurrentStateString()
    {
        switch (currentState) {
            case ACTION_SPAWNING:
                return "Spawning";
            case ACTION_IDLE:
                return "Idle";
            case ACTION_WALKING:
                return "Walking";
            case ACTION_RUNNING:
                return "Running";
            default:
                return "Unkwnown";
        }
    }

    public void setCurrentState(int currentState)
    {
        this.currentState = currentState;
    }

    public float getCurrentFrame()
    {
        return currentFrame;
    }
    
    
}
