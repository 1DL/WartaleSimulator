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
import com.dl.engine.game.objects.SoundEmitter;
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
    static final int ACTION_CHASING_WALKING = 4;
    static final int ACTION_CHASING_RUNNING = 5;
    static final int ACTION_BATTLE_IDLE = 6;

    private int currentState;

    private float currentFrame = 0;
    private float playBackSpeed = 1f;
    private int tileY = 0;
    private int tileX = 0;
    private String spriteSheetDir;

    private ImageTile movementImage;
    private ImageTile battleImage;
    private ImageTile activeImage;
    private Point mousePoint;
    
    protected Player player;
    
    
    
    public PlayerState(Player player)
    {
        this.player = player;
        this.currentState = ACTION_SPAWNING;
        movementImage = new ImageTile(player.getMovementSheetDir(), 32, 48);
        battleImage = new ImageTile(player.getBattleSheetDir(), 32, 48);
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
                tileY = player.getSpriteAngle8way();
                switch ((int) currentFrame)
                {
                    case 2:
                        gm.addSpeakerObject(new SoundEmitter("Spawning", 
                            assetsController.SFX_EFFECT_SPAWN, 
                            (int) player.getPosX(), (int) player.getPosY(), 
                            GameManager.SOUND_3D,
                            GameManager.ONCE)
                        );
                    break;
                    case 80:
                        gm.addSpeakerObject(new SoundEmitter("Cuckcoo", 
                            assetsController.SFX_EFFECT_SPAWN_END, 
                            (int) player.getPosX(), (int) player.getPosY(), 
                            GameManager.SOUND_3D,
                            GameManager.ONCE)
                        );
                        //currentState = ACTION_IDLE;
                        currentState = ACTION_BATTLE_IDLE;
                        currentFrame = 0;
                    break;
                }
            break;
            case ACTION_IDLE:
                activeImage = movementImage;
                tileY = player.getSpriteAngle8way();
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
                    player.setTarget(gm);
                    
                    if (player.isChase()) {
                        currentFrame = 0;
                        if (player.isRun()) {
                            currentState = ACTION_CHASING_RUNNING;
                        } else {
                            currentState = ACTION_CHASING_WALKING;
                        }
                    } else {
                        if (player.isRun()) {
                            currentState = ACTION_RUNNING;
                        } else {
                            currentState = ACTION_WALKING;
                        }
                        currentFrame = 0;
                        mousePoint.x = ge.getInput().getMouseX();
                        mousePoint.y = ge.getInput().getMouseY();
                    }
                }
                
                
            break;
            case ACTION_BATTLE_IDLE:
                activeImage = battleImage;
                tileY = player.getSpriteAngle4way();
                switch ((int) currentFrame)
                {
                    case 1:
                        tileX = 0;
                    break;
                    case 10:
                        tileX = 1;
                    break;
                    case 20:
                        tileX = 0;
                    break;
                    case 30:
                        tileX = 2;
                    break;
                    case 40:
                        tileX = 0;
                        currentFrame = 0;
                    break;
                }

                if (ge.getInput().isButtonDown(MouseEvent.BUTTON1))
                {
                    player.setTarget(gm);
                    
                    if (player.isChase()) {
                        currentFrame = 0;
                        if (player.isRun()) {
                            currentState = ACTION_CHASING_RUNNING;
                        } else {
                            currentState = ACTION_CHASING_WALKING;
                        }
                    } else {
                        if (player.isRun()) {
                            currentState = ACTION_RUNNING;
                        } else {
                            currentState = ACTION_WALKING;
                        }
                        currentFrame = 0;
                        mousePoint.x = ge.getInput().getMouseX();
                        mousePoint.y = ge.getInput().getMouseY();
                    }
                }
            break;
            case ACTION_WALKING:
                activeImage = movementImage;
                tileY = player.getSpriteAngle8way();
                
                mousePoint.x = ge.getInput().getMouseX();
                mousePoint.y = ge.getInput().getMouseY();
                player.move(gm, deltaTime, mousePoint);
                
                switch ((int) currentFrame)
                {
                    case 1:
                        tileX = 1;
                        player.playFootstep(gm);
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
                        player.playFootstep(gm);
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
                    //currentState = ACTION_IDLE;
                    currentState = ACTION_BATTLE_IDLE;
                    currentFrame = 0;
                }
                
            break;
            case ACTION_RUNNING:
                
                activeImage = movementImage;
                tileY = player.getSpriteAngle8way();
                
                mousePoint.x = ge.getInput().getMouseX();
                mousePoint.y = ge.getInput().getMouseY();
                player.move(gm, deltaTime, mousePoint);
                
                switch ((int) currentFrame)
                {
                    case 1:
                        tileX = 1;
                        player.playFootstep(gm);
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
                        player.playFootstep(gm);
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
                    //currentState = ACTION_IDLE;
                    currentState = ACTION_BATTLE_IDLE;
                    currentFrame = 0;
                }
                
            break;
            case ACTION_CHASING_WALKING:
                activeImage = movementImage;
                tileY = player.getSpriteAngle8way();
                
                mousePoint.x = ge.getInput().getMouseX();
                mousePoint.y = ge.getInput().getMouseY();
                player.chaseMove(gm, deltaTime);
                
                switch ((int) currentFrame)
                {
                    case 1:
                        tileX = 1;
                        player.playFootstep(gm);
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
                        player.playFootstep(gm);
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
                    currentState = ACTION_CHASING_RUNNING;
                    currentFrame = 0;
                }
                
                if (ge.getInput().isButtonDown(MouseEvent.BUTTON1)){
                    player.setTarget(gm);
                    if (!player.isChase()) {
                        currentState = ACTION_WALKING;
                        currentFrame = 0;
                    }
                }
                
            break;
            case ACTION_CHASING_RUNNING:
                activeImage = movementImage;
                tileY = player.getSpriteAngle8way();
                
                mousePoint.x = ge.getInput().getMouseX();
                mousePoint.y = ge.getInput().getMouseY();
                player.chaseMove(gm, deltaTime);
                
                switch ((int) currentFrame)
                {
                    case 1:
                        tileX = 1;
                        player.playFootstep(gm);
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
                        player.playFootstep(gm);
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
                    currentState = ACTION_CHASING_WALKING;
                    currentFrame = 0;
                }
                
                if (ge.getInput().isButtonDown(MouseEvent.BUTTON1)){
                    player.setTarget(gm);
                    if (!player.isChase()) {
                        currentState = ACTION_RUNNING;
                        currentFrame = 0;
                    }
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
            case ACTION_CHASING_WALKING:
                return "Chase Walk";
            case ACTION_CHASING_RUNNING:
                return "Chase Run";
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
