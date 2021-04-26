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
import com.dl.engine.helpers.PlayerState;
import controller.assets.assetsController;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.Point;

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
    
    private String movementSheetDir;

    private float faceAngle;
    private int spriteAngle;
    private int tileX, tileY;
    private float offX, offY;

    private boolean run = true;
    private float walkRunModifier = 1;
    private float speed = 200;
    private float fallSpeed = 10;
    private float jump = -4;
    private boolean ground = false;
    private boolean groundLast = false;
    private float x_velocity = 0;
    private float y_velocity = 0;
    private Point centerPoint;

    private float fallDistance = 0;
    
    private int lastDirectionKey = 0;
    
    private PlayerState state;

   

    public Player(int posX, int posY)
    {
        this.tag = "player";
        this.tileX = posX;
        this.tileY = posY;
        this.offX = 0;
        this.offY = 0;
        this.posX = posX * GameManager.TILE_SIZE;
        this.posY = posY * GameManager.TILE_SIZE;
        this.width = GameManager.TILE_SIZE * 2;
        this.height = GameManager.TILE_SIZE * 3;
        padding = 5;
        paddingTop = 2;
        this.movementSheetDir = assetsController.SPRITE_SHEET_MOVE_KS;
        this.faceAngle = 45f;
        centerPoint = new Point();
        centerPoint.x = 256;
        centerPoint.y = 144;
        
        this.addComponent(new AABBComponent(this));
        
        state = new PlayerState(this);
        
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
        
        centerPoint.x = (int) posX + gm.TILE_SIZE;
        centerPoint.y = (int) posY + gm.TILE_SIZE + gm.TILE_SIZE / 2;
        
        state.update(ge, gm, deltaTime);
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        //r.drawImageTile(playerImage, (int) posX, (int) posY, (int) animationFrame, direction);
        //this.renderComponents(ge, r);
        
        r.drawText("State: " + state.getCurrentStateString(), (int) posX, (int) posY + 80, 0xffff0000);
        r.drawText("State Frame: " + state.getCurrentFrame(), (int)posX, (int)posY + 90, 0xffff0000);
        r.drawText("Angle: " + faceAngle, (int)posX, (int)posY + 100, 0xffff0000);
        r.drawText("Sprite Angle: " + spriteAngle, (int)posX, (int)posY + 110, 0xffff0000);
        state.render(ge, r);
        
        //Center of character
        r.drawFillRect(centerPoint.x, centerPoint.y, 1, 1, 0xffff0000);
        //His supposed collision box
        r.drawRect(centerPoint.x - 10, centerPoint.y - 5, 20, 10, 0xffff0000);
        //His target area
        r.drawRect(centerPoint.x - 13, centerPoint.y - 30, 25, 40, 0xff00ffff);
        
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
    
    public void move(GameManager gm, float deltaTime, Point targetPoint){
        y_velocity = 0;
        x_velocity = 0;

        faceAngle = gm.getAngle(gm.getCenterOfScreen(), targetPoint);
        
        x_velocity += deltaTime * (int) (Math.sin(Math.toRadians(faceAngle)) * (walkRunModifier * speed));
        y_velocity += deltaTime * (int) (Math.cos(Math.toRadians(faceAngle)) * (walkRunModifier * speed));
        
        y_velocity = -y_velocity * 0.5f;
        
        
        if (faceAngle >= 21 && faceAngle <= 70) {
            spriteAngle = FACE_NE;
        } else if (faceAngle >= 70 && faceAngle <= 110) {
            spriteAngle = FACE_E;
        } else if (faceAngle >= 110 && faceAngle <= 160) {
            spriteAngle = FACE_SE;
        } else if (faceAngle >= 160 && faceAngle <= 200) {
            spriteAngle = FACE_S;
        } else if (faceAngle >= 200 && faceAngle <= 250) {
            spriteAngle = FACE_SW;
        } else if (faceAngle >= 250 && faceAngle <= 290) {
            spriteAngle = FACE_W;
        } else if (faceAngle >= 290 && faceAngle <= 340) {
            spriteAngle = FACE_NW;
        } else  {
            spriteAngle = FACE_N;
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

    public String getMovementSheetDir()
    {
        return movementSheetDir;
    }

    public int getSpriteAngle()
    {
        return spriteAngle;
    }

    public void setSpriteAngle(int spriteAngle)
    {
        this.spriteAngle = spriteAngle;
    }

    public float getFaceAngle()
    {
        return faceAngle;
    }

    public void setFaceAngle(float faceAngle)
    {
        this.faceAngle = faceAngle;
    }

    public int getTileX()
    {
        return tileX;
    }

    public int getTileY()
    {
        return tileY;
    }
    
}
