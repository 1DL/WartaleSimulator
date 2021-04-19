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

    private static final int FACE_S  = 0;
    private static final int FACE_SW = 1;
    private static final int FACE_W  = 2;
    private static final int FACE_NW = 3;
    private static final int FACE_N  = 4;
    private static final int FACE_NE = 5;
    private static final int FACE_E  = 6;
    private static final int FACE_SE = 7;
    
    private static final int LEFT   = 1;
    private static final int RIGHT  = 2;
    private static final int UP     = 3;
    private static final int DOWN   = 4;

    private ImageTile playerImage = new ImageTile(assetsController.SPRITE_SHEET_KS, 32, 48);

    private int direction = FACE_S;
    private float animationFrame = 0;
    private int tileX, tileY;
    private float offX, offY;

    private boolean run = true;
    private float walkRunModifier = 1;
    private float speed = 100;
    private float fallSpeed = 10;
    private float jump = -4;
    private boolean ground = false;
    private boolean groundLast = false;
    private float x_velocity = 0;
    private float y_velocity = 0;

    private float fallDistance = 0;
    
    private int lastDirectionKey = 0;

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
        //C key for enabling collision map
        if (ge.getInput().isKeyUp(KeyEvent.VK_C))
        {
            gm.setShowCollisionMap(!gm.isShowCollisionMap());
        }
        //B key for enabling smooth camera
        if (ge.getInput().isKeyUp(KeyEvent.VK_B))
        {
            gm.setCameraSmooth(!gm.isCameraSmooth());
        }
        //R key for toggle run/walk
        if (ge.getInput().isKeyUp(KeyEvent.VK_R))
        {
            toggleRun();
            gm.setWalkRunMode(this.run);
        }
        
        //Beginning of Moving
        
        animationFrame = 0;
         
        //Facing DOWN LEFT, pressed S A
        if (ge.getInput().isKey(KeyEvent.VK_S) && ge.getInput().isKey(KeyEvent.VK_A))
        {
            if (gm.getCollision(tileX - 1, tileY) || gm.getCollision(tileX - 1, tileY + (int) Math.signum((int) offY)))
            {
                if (offX < -padding)
                {
                    offX = -padding;
                }
            } else
            { 
                move(FACE_SW, deltaTime);  
            }
        }
        
        //FACING RIGHT DOWN, presset D S
        else if (ge.getInput().isKey(KeyEvent.VK_D) && ge.getInput().isKey(KeyEvent.VK_S))
        {
            if (gm.getCollision(tileX - 1, tileY) || gm.getCollision(tileX - 1, tileY + (int) Math.signum((int) offY)))
            {
                if (offX < -padding)
                {
                    offX = -padding;
                }
            } else
            { 
                move(FACE_SE, deltaTime);  
            }
        }
        //Moving DOWN while S key is pressed
        else if (ge.getInput().isKey(KeyEvent.VK_S))
        {
            if (gm.getCollision(tileX, tileY + 1) || gm.getCollision(tileX, tileY + 1))
            {
                if (offY < padding)
                {
                    offY = padding;
                }
            } else
            {
                move(FACE_S, deltaTime);
            }
        }
        //FACING UP LEFT, pressed A W
        else if (ge.getInput().isKey(KeyEvent.VK_A) && ge.getInput().isKey(KeyEvent.VK_W))
        {
            if (gm.getCollision(tileX - 1, tileY) || gm.getCollision(tileX - 1, tileY + (int) Math.signum((int) offY)))
            {
                if (offX < -padding)
                {
                    offX = -padding;
                }
            } else
            { 
                move(FACE_NW, deltaTime);  
            }
        }
        //FACING UP RIGHT, presset W D
        else if (ge.getInput().isKey(KeyEvent.VK_W) && ge.getInput().isKey(KeyEvent.VK_D))
        {
            if (gm.getCollision(tileX - 1, tileY) || gm.getCollision(tileX - 1, tileY + (int) Math.signum((int) offY)))
            {
                if (offX < -padding)
                {
                    offX = -padding;
                }
            } else
            { 
                move(FACE_NE, deltaTime);  
            }
        }
        //FACING LEFT, pressed A
        else if (ge.getInput().isKey(KeyEvent.VK_A))
        {
            if (gm.getCollision(tileX - 1, tileY) || gm.getCollision(tileX - 1, tileY + (int) Math.signum((int) offY)))
            {
                if (offX < -padding)
                {
                    offX = -padding;
                }
            } else
            { 
                move(FACE_W, deltaTime);  
            }
        }
        
        
        //FACING UP, pressed W
        else if (ge.getInput().isKey(KeyEvent.VK_W))
        {
            if (gm.getCollision(tileX - 1, tileY) || gm.getCollision(tileX - 1, tileY + (int) Math.signum((int) offY)))
            {
                if (offX < -padding)
                {
                    offX = -padding;
                }
            } else
            { 
                move(FACE_N, deltaTime);  
            }
        }
        
        //FACING RIGHT, pressed D
        else if (ge.getInput().isKey(KeyEvent.VK_D))
        {
            if (gm.getCollision(tileX - 1, tileY) || gm.getCollision(tileX - 1, tileY + (int) Math.signum((int) offY)))
            {
                if (offX < -padding)
                {
                    offX = -padding;
                }
            } else
            { 
                move(FACE_E, deltaTime);  
            }
        }
        
        
        //End of moving left and right and up and down
                
//        //Beginning of Jump and Gravity
//        
//        //Setting the next vertical distance to be travelled based on dt and fallspeed
//        fallDistance += deltaTime * fallSpeed;
//        
//        
//        //Collision detection of when going upwards
//        if (fallDistance < 0)
//        {
//            if ((gm.getCollision(tileX, tileY - 1) 
//                    || gm.getCollision(tileX + (int) Math.signum((int) Math.abs(offX) > padding ? offX : 0), tileY - 1)) 
//                    && offY < -paddingTop)
//            {
//                fallDistance = 0;
//                offY = -paddingTop;
//            }
//        }      
//
//        //Collision detection of when going downards
//        if (fallDistance >= 0)
//        {
//            if ((gm.getCollision(tileX, tileY + 1) 
//                    || gm.getCollision(tileX + (int) Math.signum((int) Math.abs(offX) > padding ? offX : 0), tileY + 1)) 
//                    && offY > 0)
//            {
//                fallDistance = 0;
//                offY = 0;
//                ground = true;
//            }
//        }
//        
//        //Jump action when grounded, and as soon as W key is pressed
//        if (ge.getInput().isKeyDown(KeyEvent.VK_W) && ground)
//        {
//            fallDistance = jump;
//            ground = false;
//        }
//        
//        //Setting the offset Y position based on current falldistance
//        offY += fallDistance;  
//        
//        
//        //End of Jump and Gravity
                
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
//        if (ge.getInput().isKey(KeyEvent.VK_D))
//        {
//            direction = RIGHT;
//            animationFrame += deltaTime * 8;    //Sets the right walking animation loop speed
//            if (animationFrame >= 4)            //When reach the last frame of animation on the tile image, resets to idle
//            {
//                animationFrame = 0;
//            }
//        }else if (ge.getInput().isKey(KeyEvent.VK_A))
//        {
//            direction = LEFT;
//            animationFrame += deltaTime * 8;    //Sets the left walking animation loop speed
//            if (animationFrame >= 4)            //When reach the last frame of animation on the tile image, resets to idle
//            {
//                animationFrame = 0;
//            }
//        } else
//        {
//            //When no left or right key is being held, stop animation loop and set the idle frame at the last facing direction
//            animationFrame = 0;                 
//        }
//        
//        //If being airbone, going either upwards or downwards, display animation frame 1
//        if ((int) fallDistance != 0)
//        {
//            animationFrame = 1;
//            ground = false;
//        }
//
//        //If landing from airbone and being grounded for the first moment, display animation frame 2
//        if (ground && !groundLast)
//        {
//            animationFrame = 2;
//        }
//        //Boolean flag to determine if it was being grounded for the first moment after being airbone
//        groundLast = ground;
//        //End of Animation
        
        //Update all components 
        this.updateComponents(ge, gm, deltaTime);
        gm.playerTileX = tileX;
        gm.playerTileY = tileY;
        gm.playerPosX = (int) posX;
        gm.playerPosY = (int) posY;
        gm.setX_velocity(x_velocity);
        gm.setY_velocity(y_velocity);
        
        System.out.println(deltaTime);
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        r.drawImageTile(playerImage, (int) posX, (int) posY, (int) animationFrame, direction);
        //r.drawFillRect((int)posX, (int)posY, width, height, 0xff00ff00);
        
        //this.renderComponents(ge, r);
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
    
    private void move(int direction, float deltaTime){
        this.direction = direction;
        y_velocity = 0;
        x_velocity = 0;
        switch (direction) {
            case FACE_S:
                y_velocity += deltaTime * (walkRunModifier * speed) / 2;
            break;
            case FACE_SW:
                y_velocity += deltaTime * (walkRunModifier * speed) / 4;
                x_velocity -= deltaTime * (walkRunModifier * speed) / 2;
            break;
            case FACE_W:
                x_velocity -= deltaTime * (walkRunModifier * speed);
            break;
            case FACE_NW:
                y_velocity -= deltaTime * (walkRunModifier * speed) / 4;
                x_velocity -= deltaTime * (walkRunModifier * speed) / 2;
            break;  
            case FACE_N:
                y_velocity -= deltaTime * (walkRunModifier * speed) / 2;
            break;
            case FACE_NE:
                y_velocity -= deltaTime * (walkRunModifier * speed) / 4;
                x_velocity += deltaTime * (walkRunModifier * speed) / 2;
            break;
            case FACE_E:
                x_velocity += deltaTime * (walkRunModifier * speed);
            break;
            case FACE_SE:
                y_velocity += deltaTime * (walkRunModifier * speed) / 4;
                x_velocity += deltaTime * (walkRunModifier * speed) / 2;
            break;
        }
        
        offX += x_velocity;
        offY += y_velocity;
    }

    public boolean isRun()
    {
        return run;
    }

    public void toggleRun()
    {
        this.run = !this.run;
        if (run) {
            walkRunModifier = 1;
        } else {
            walkRunModifier = 0.5f;
        }
    }
    
    

}
