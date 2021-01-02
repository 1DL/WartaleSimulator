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
import com.dl.engine.gfx.ImageTile;
import controller.assets.assetsController;
import java.awt.event.KeyEvent;

/**
 *
 * @author Luiz
 */
public class Player extends GameObject
{

    private static final int RIGHT = 0;
    private static final int LEFT = 1;

    private ImageTile playerImage = new ImageTile(assetsController.CHAR_SPRITES_DIR + "playerSprites.png", 16, 16);

    private int direction = RIGHT;
    private float animationFrame = 0;
    private int tileX, tileY;
    private float offX, offY;

    private float speed = 100;
    private float fallSpeed = 10;
    private float jump = -4;
    private boolean ground = false;
    private boolean groundLast = false;

    private float fallDistance = 0;

    public Player(int posX, int posY)
    {
        this.tag = "player";
        this.tileX = posX;
        this.tileY = posY;
        this.offX = 0;
        this.offY = 0;
        this.posX = posX * GameManager.TILE_SIZE;
        this.posY = posY * GameManager.TILE_SIZE;
        this.width = GameManager.TILE_SIZE;
        this.height = GameManager.TILE_SIZE;
        padding = 5;
        paddingTop = 2;
        
        this.addComponent(new AABBComponent(this));
    }

    @Override
    public void update(GameEngine ge, GameManager gm, float deltaTime)
    {
        //Beginning of Move Left and Right
        
        //Moving left while A key is pressed
        if (ge.getInput().isKey(KeyEvent.VK_A))
        {
            if (gm.getCollision(tileX - 1, tileY) || gm.getCollision(tileX - 1, tileY + (int) Math.signum((int) offY)))
            {
                offX -= deltaTime * speed;
                if (offX < -padding)
                {
                    offX = -padding;
                }
            } else
            {
                offX -= deltaTime * speed;
            }
        }
        
        //Moving right while D key is pressed
        if (ge.getInput().isKey(KeyEvent.VK_D))
        {
            if (gm.getCollision(tileX + 1, tileY) || gm.getCollision(tileX + 1, tileY + (int) Math.signum((int) offY)))
            {
                offX += deltaTime * speed;
                if (offX > padding)
                {
                    offX = padding;
                }
            } else
            {
                offX += deltaTime * speed;
            }
        }
        //End of moving left and right
                
        //Beginning of Jump and Gravity
        
        //Setting the next vertical distance to be travelled based on dt and fallspeed
        fallDistance += deltaTime * fallSpeed;
        
        
        //Collision detection of when going upwards
        if (fallDistance < 0)
        {
            if ((gm.getCollision(tileX, tileY - 1) 
                    || gm.getCollision(tileX + (int) Math.signum((int) Math.abs(offX) > padding ? offX : 0), tileY - 1)) 
                    && offY < -paddingTop)
            {
                fallDistance = 0;
                offY = -paddingTop;
            }
        }      

        //Collision detection of when going downards
        if (fallDistance >= 0)
        {
            if ((gm.getCollision(tileX, tileY + 1) 
                    || gm.getCollision(tileX + (int) Math.signum((int) Math.abs(offX) > padding ? offX : 0), tileY + 1)) 
                    && offY > 0)
            {
                fallDistance = 0;
                offY = 0;
                ground = true;
            }
        }
        
        //Jump action when grounded, and as soon as W key is pressed
        if (ge.getInput().isKeyDown(KeyEvent.VK_W) && ground)
        {
            fallDistance = jump;
            ground = false;
        }
        
        //Setting the offset Y position based on current falldistance
        offY += fallDistance;  
        
        
        //End of Jump and Gravity
                
        //Beginning of final position
        if (offY > GameManager.TILE_SIZE / 2)
        {
            tileY++;
            offY -= GameManager.TILE_SIZE;
        }
        if (offY < -GameManager.TILE_SIZE / 2)
        {
            tileY--;
            offY += GameManager.TILE_SIZE;
        }
        if (offX > GameManager.TILE_SIZE / 2)
        {
            tileX++;
            offX -= GameManager.TILE_SIZE;
        }
        if (offX < -GameManager.TILE_SIZE / 2)
        {
            tileX--;
            offX += GameManager.TILE_SIZE;
        }

        posX = tileX * GameManager.TILE_SIZE + offX;
        posY = tileY * GameManager.TILE_SIZE + offY;
        //End of final position
        

        //Beginning of Shooting projetile
        
        //Shooting Upwards when pressing arrow up
        if (ge.getInput().isKey(KeyEvent.VK_UP))
        {
            gm.addObject(new Bullet(tileX, tileY, offX + width / 2, offY + height / 2, Bullet.UP_DIRECTION));
        }
        //Shooting to the right when pressing arrow right
        if (ge.getInput().isKey(KeyEvent.VK_RIGHT))
        {
            gm.addObject(new Bullet(tileX, tileY, offX + width / 2, offY + height / 2, Bullet.RIGHT_DIRECTION));
        }
        //Shooting downwards when pressing arrow down
        if (ge.getInput().isKey(KeyEvent.VK_DOWN))
        {
            gm.addObject(new Bullet(tileX, tileY, offX + width / 2, offY + height / 2, Bullet.DOWN_DIRECTION));
        }
        //Shooting to the left when pressing arrow left
        if (ge.getInput().isKey(KeyEvent.VK_LEFT))
        {
            gm.addObject(new Bullet(tileX, tileY, offX + width / 2, offY + height / 2, Bullet.LEFT_DIRECTION));
        }
        //End of Shooting projetile

        
        //Beggining of Animation
        
        /*
        If pressing D, Set character to face right and use right walking animation
        Else if pressing A, Set character to face left and use left walking animation
        Else, stop at current facing direction and sets to the default idle animation frame
        */
        if (ge.getInput().isKey(KeyEvent.VK_D))
        {
            direction = RIGHT;
            animationFrame += deltaTime * 8;    //Sets the right walking animation loop speed
            if (animationFrame >= 4)            //When reach the last frame of animation on the tile image, resets to idle
            {
                animationFrame = 0;
            }
        }else if (ge.getInput().isKey(KeyEvent.VK_A))
        {
            direction = LEFT;
            animationFrame += deltaTime * 8;    //Sets the left walking animation loop speed
            if (animationFrame >= 4)            //When reach the last frame of animation on the tile image, resets to idle
            {
                animationFrame = 0;
            }
        } else
        {
            //When no left or right key is being held, stop animation loop and set the idle frame at the last facing direction
            animationFrame = 0;                 
        }
        
        //If being airbone, going either upwards or downwards, display animation frame 1
        if ((int) fallDistance != 0)
        {
            animationFrame = 1;
            ground = false;
        }

        //If landing from airbone and being grounded for the first moment, display animation frame 2
        if (ground && !groundLast)
        {
            animationFrame = 2;
        }
        //Boolean flag to determine if it was being grounded for the first moment after being airbone
        groundLast = ground;
        //End of Animation
        
        //Update all components 
        this.updateComponents(ge, gm, deltaTime);
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        r.drawImageTile(playerImage, (int) posX, (int) posY, (int) animationFrame, direction);
        //r.drawFillRect((int)posX, (int)posY, width, height, 0xff00ff00);
        this.renderComponents(ge, r);
    }

    @Override
    public void collision(GameObject other)
    {
        //Checks if colliding with a object with tag set to platform
        if (other.getTag().equalsIgnoreCase("platform"))
        {
            AABBComponent thisComponent = (AABBComponent) this.findComponent("aabb");
            AABBComponent otherComponent = (AABBComponent) other.findComponent("aabb");
            
            if(Math.abs(thisComponent.getLastCenterX() - otherComponent.getLastCenterX()) < thisComponent.getHalfWidth() + otherComponent.getHalfWidth())
            {
                if (thisComponent.getCenterY() < otherComponent.getCenterY())
                {
                    int distance = (thisComponent.getHalfHeight() + otherComponent.getHalfHeight()) - (otherComponent.getCenterY() - thisComponent.getCenterY());
                    offY -= distance;
                    posY -= distance;
                    thisComponent.setCenterY(thisComponent.getCenterY() - distance);
                    fallDistance = 0;
                    ground = true;
 
                }
 
                if (thisComponent.getCenterY() > otherComponent.getCenterY())
                {
                    int distance = (thisComponent.getHalfHeight() + otherComponent.getHalfHeight()) - (thisComponent.getCenterY() - otherComponent.getCenterY());
                    offY += distance;
                    posY += distance;
                    thisComponent.setCenterY(thisComponent.getCenterY() + distance);
                    fallDistance = 0;
                }
            }
            else
            {
                if (thisComponent.getCenterX() < otherComponent.getCenterX())
                {
                    int distance = (thisComponent.getHalfWidth() + otherComponent.getHalfWidth()) - (otherComponent.getCenterX() - thisComponent.getCenterX());
                    offX -= distance;
                    posX -= distance;
                    thisComponent.setCenterX(thisComponent.getCenterX() - distance);
                }
 
                
                if (thisComponent.getCenterX() > otherComponent.getCenterX())
                {
                    int distance = (thisComponent.getHalfWidth() + otherComponent.getHalfWidth()) - (thisComponent.getCenterX() - otherComponent.getCenterX());
                    offX += distance;
                    posX += distance;
                    thisComponent.setCenterX(thisComponent.getCenterX() + distance);
                }
            }
        }
    }

}
