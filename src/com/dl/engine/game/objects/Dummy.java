/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game.objects;

import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
import com.dl.engine.game.GameManager;
import com.dl.engine.game.components.AABBComponent;
import com.dl.engine.gfx.Image;
import com.dl.engine.helpers.PlayerState;
import controller.assets.assetsController;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 *
 * @author Luiz
 */
public class Dummy extends GameObject
{
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_RIGHT = 2;
    
    private int tileX, tileY;
    private Image dummyImage;
    private float offX, offY;
    private int midX;
    private int midY;
    
    private float dynamicX;
    private int side = SIDE_RIGHT;
    
    private Player player;
    
    float vertical_speed = 2f;
    
    public Dummy(String tag, int posX, int posY)
    {
        this.tag = tag;
        this.tileX = posX ;
        this.tileY = posY;
        this.offX = 0;
        this.offY = 0;
        this.posX = posX;
        this.posY = posY;
        this.width = GameManager.TILE_SIZE * 2;
        this.height = GameManager.TILE_SIZE * 2;
        dummyImage = new Image(assetsController.SPRITE_TRAININGLOG);
        this.midX = posX + (width / 2);
        this.midY = posY + (height / 2);
        
        this.addComponent(new AABBComponent(this));
        
        
    }
    

    @Override
    public void update(GameEngine ge, GameManager gm, float deltaTime)
    {
        this.updateComponents(ge, gm, deltaTime);
        
        if (side == SIDE_LEFT) {
            dynamicX = dynamicX - deltaTime * vertical_speed;
        } else if (side == SIDE_RIGHT) {
            dynamicX = dynamicX + deltaTime * vertical_speed;
        }
        
        if (dynamicX >= 5) {
            side = SIDE_LEFT;
        } if (dynamicX <= -5) {
            side = SIDE_RIGHT;
        }
        
        this.posX += (int) dynamicX;
               
        
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        r.drawRect((int)posX, (int)posY, width, height, 0xff00ffff);
        r.drawImage(dummyImage, (int) posX, (int) posY);
        r.drawText("Tag: " + this.tag, (int) posX +10, (int) posY +30, 0xff0000ff);
        this.renderComponents(ge, r);
    }

    @Override
    public void collision(GameObject other)
    {
        
    }
    
}
