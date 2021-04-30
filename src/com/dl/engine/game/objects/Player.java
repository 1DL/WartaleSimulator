/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game.objects;

import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
import com.dl.engine.audio.SoundClip;
import com.dl.engine.game.GameManager;
import com.dl.engine.game.components.AABBComponent;
import com.dl.engine.gfx.Image;
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
    private int centerTileX, centerTileY;
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
    private int currentTileType;
    private String tileTypeStr;

    private float fallDistance = 0;
    
    private int lastDirectionKey = 0;
    
    private boolean chase = false;
    private String chaseTarget = "mouse";
    private GameObject targetObject;
    private Point targetPoint = new Point();
    
    private PlayerState state;
    
    private Image micImage;
    
    
    public Player(int posX, int posY)
    {
        this.tag = "player";
        this.tileX = posX ;
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
        this.spriteAngle = 5;
        centerPoint = new Point();
        centerPoint.x = 256;
        centerPoint.y = 144;
        
        this.addComponent(new AABBComponent(this));
        
        state = new PlayerState(this);
        
        micImage = new Image(assetsController.ICON_MIC);
        
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
        
        if (ge.getInput().isKeyUp(KeyEvent.VK_P))
        {
            try {
                gm.getSpeakerObject("Background Music").pause();
            } catch (NullPointerException npe) {
                System.out.println(npe.getMessage());
                //gm.addObject(new SoundEmitter("Background Music", assetsController.BGM_HUNTER_ENDING, centerPoint.x, centerPoint.y, GameManager.SOUND_3D, GameManager.ONCE));
            }
        }
        
        
        
        
        
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
        
        state.update(ge, gm, deltaTime);
        
        gm.playerTileX = tileX;
        gm.playerTileY = tileY;
        gm.playerPosX = (int) posX;
        gm.playerPosY = (int) posY;
        gm.setX_velocity(x_velocity);
        gm.setY_velocity(y_velocity);
        
        
        //Update all components 
        this.updateComponents(ge, gm, deltaTime);
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        
        //r.drawImageTile(playerImage, (int) posX, (int) posY, (int) animationFrame, direction);
        //this.renderComponents(ge, r);
        
        r.drawText("Is Chasing: " + chase , (int) posX, (int) posY - 30, 0xffff0000);
        r.drawText("Chase Target: " + chaseTarget , (int) posX, (int) posY - 20, 0xffff0000);
        
        
        r.drawText("State: " + state.getCurrentStateString(), (int) posX, (int) posY + 30, 0xffff0000);
        r.drawText("State Frame: " + state.getCurrentFrame(), (int)posX, (int)posY + 40, 0xffff0000);
        r.drawText("Angle: " + faceAngle, (int)posX, (int)posY + 50, 0xffff0000);
        r.drawText("Sprite Angle: " + spriteAngle, (int)posX, (int)posY + 60, 0xffff0000);
        r.drawText("Center X: " + centerPoint.x, (int)posX, (int)posY + 70, 0xffff0000);
        r.drawText("Center Y: " + centerPoint.y, (int)posX, (int)posY + 80, 0xffff0000);
        r.drawText("Off X: " + offX, (int)posX, (int)posY + 90, 0xffff0000);
        r.drawText("Off Y: " + offY, (int)posX, (int)posY + 100, 0xffff0000);
        r.drawText("C. Tile X: " + centerTileX, (int)posX, (int)posY + 110, 0xffff0000);
        r.drawText("C. Tile Y: " + centerTileY, (int)posX, (int)posY + 120, 0xffff0000);
        r.drawText("Type: " + tileTypeStr, (int)posX, (int)posY + 130, 0xffff0000);
        r.drawText("Sig. X: " + (int) Math.signum((int) offX), (int)posX, (int)posY + 140, 0xffff0000);
        r.drawText("Sig. Y: " + (int) Math.signum((int) offY), (int)posX, (int)posY + 150, 0xffff0000);
        
        
        
        //Center of character
        r.drawFillRect(centerPoint.x, centerPoint.y, 1, 1, 0xffff0000);
        //His supposed collision box
        r.drawRect(centerPoint.x - 10, centerPoint.y - 5, 20, 10, 0xffff0000);
        //His target area
        r.drawRect(centerPoint.x - 13, centerPoint.y - 30, 25, 40, 0xff00ffff);
        
        r.drawImage(micImage, centerPoint.x -5, centerPoint.y - 45);
        
        
        this.renderComponents(ge, r);
        
        state.render(ge, r);
        
        
    }

    @Override
    public void collision(GameObject other)
    {
//        aabbCollision(other, "dummy 1");
//        aabbCollision(other, "dummy 2");
//        aabbCollision(other, "dummy 3");
        aabbCollision(other, "platform");
    }
    
    public void playFootstep(GameManager gm)
    {
        switch (gm.getTileType(centerTileX, centerTileY))
        {
            case GameManager.GRASS:
                switch (gm.getIntRandom(1, 2))
                {
                    case 1:
                        gm.addSpeakerObject(new SoundEmitter("Footstep Grass 1",
                            assetsController.SFX_FOOTSTEP_GRASS_01,
                            (int) this.posX, (int) this.posY,
                            GameManager.SOUND_3D,
                            GameManager.ONCE)
                        );
                        break;
                    case 2:
                        gm.addSpeakerObject(new SoundEmitter("Footstep Grass 2", assetsController.SFX_FOOTSTEP_GRASS_02, centerPoint.x, centerPoint.y, GameManager.SOUND_3D, GameManager.ONCE));
                        break;
                }
                break;
            case GameManager.WATER:
                switch (gm.getIntRandom(1, 3))
                {
                    case 1:
                        gm.addSpeakerObject(new SoundEmitter("Footstep Water 1", assetsController.SFX_FOOTSTEP_WATER_01, centerPoint.x, centerPoint.y, GameManager.SOUND_3D, GameManager.ONCE));
                        break;
                    case 2:
                        gm.addSpeakerObject(new SoundEmitter("Footstep Water 2", assetsController.SFX_FOOTSTEP_WATER_02, centerPoint.x, centerPoint.y, GameManager.SOUND_3D, GameManager.ONCE));
                        break;
                    case 3:
                        gm.addSpeakerObject(new SoundEmitter("Footstep Water 3", assetsController.SFX_FOOTSTEP_WATER_03, centerPoint.x, centerPoint.y, GameManager.SOUND_3D, GameManager.ONCE));
                        break;
                }
                break;
            case GameManager.SAND:
                switch (gm.getIntRandom(1, 3))
                {
                    case 1:
                        gm.addSpeakerObject(new SoundEmitter("Footstep Sand 1", assetsController.SFX_FOOTSTEP_SAND_01, centerPoint.x, centerPoint.y, GameManager.SOUND_3D, GameManager.ONCE));
                        break;
                    case 2:
                        gm.addSpeakerObject(new SoundEmitter("Footstep Sand 2", assetsController.SFX_FOOTSTEP_SAND_02, centerPoint.x, centerPoint.y, GameManager.SOUND_3D, GameManager.ONCE));
                        break;
                    case 3:
                        gm.addSpeakerObject(new SoundEmitter("Footstep Sand 3", assetsController.SFX_FOOTSTEP_SAND_03, centerPoint.x, centerPoint.y, GameManager.SOUND_3D, GameManager.ONCE));
                        break;
                }
                break;
            default:
                switch (gm.getIntRandom(1, 5))
                {
                    case 1:
                        gm.addSpeakerObject(new SoundEmitter("Footstep Wood 1", assetsController.SFX_FOOTSTEP_WOOD_01, centerPoint.x, centerPoint.y, GameManager.SOUND_3D, GameManager.ONCE));
                        break;
                    case 2:
                        gm.addSpeakerObject(new SoundEmitter("Footstep Wood 2", assetsController.SFX_FOOTSTEP_WOOD_02, centerPoint.x, centerPoint.y, GameManager.SOUND_3D, GameManager.ONCE));
                        break;
                    case 3:
                        gm.addSpeakerObject(new SoundEmitter("Footstep Wood 3", assetsController.SFX_FOOTSTEP_WOOD_03, centerPoint.x, centerPoint.y, GameManager.SOUND_3D, GameManager.ONCE));
                        break;
                    case 4:
                        gm.addSpeakerObject(new SoundEmitter("Footstep Wood 4", assetsController.SFX_FOOTSTEP_WOOD_04, centerPoint.x, centerPoint.y, GameManager.SOUND_3D, GameManager.ONCE));
                        break;
                    case 5:
                        gm.addSpeakerObject(new SoundEmitter("Footstep Wood 5", assetsController.SFX_FOOTSTEP_WOOD_05, centerPoint.x, centerPoint.y, GameManager.SOUND_3D, GameManager.ONCE));
                        break;
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
        
        //Collision Check - Going Right
        if (x_velocity > 0) {
            if (gm.getCollision(centerTileX + 1, centerTileY))
            {
                x_velocity = 0;
            }
        }
        //Collision Check - Going Left
        if (x_velocity < 0) {
            if (gm.getCollision(centerTileX - 1, centerTileY))
            {
                x_velocity = 0;
            }
        }
        //Collision Check - Going Down
        if (y_velocity > 0) {
            if (gm.getCollision(centerTileX, centerTileY + 1))
            {
                y_velocity = 0;
            }
        }
        //Collision Check - Going Up
        if (y_velocity < 0) {
            if (gm.getCollision(centerTileX, centerTileY - 1))
            {
                y_velocity = 0;
            }
        }
        
        
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
        
        
        centerPoint.x = (int) posX + gm.TILE_SIZE;
        centerPoint.y = (int) posY + gm.TILE_SIZE + gm.TILE_SIZE / 2;
        centerTileX = centerPoint.x / GameManager.TILE_SIZE;
        centerTileY = centerPoint.y / GameManager.TILE_SIZE;
        
//        tileX = centerPoint.x / gm.TILE_SIZE;;
//        tileY = centerPoint.y / gm.TILE_SIZE;

        
        gm.setMicrophone(centerPoint);
        
        currentTileType = gm.getTileType(centerTileX, centerTileY);
        tileTypeStr = gm.getTileTypeString(currentTileType);
                
    }
    
    public void chaseMove(GameManager gm, float deltaTime){
        y_velocity = 0;
        x_velocity = 0;
        
        targetObject = gm.getObject(chaseTarget);
        
        
        
        targetPoint.x = (int) targetObject.posX + targetObject.width / 2;
        targetPoint.y = (int) targetObject.posY + targetObject.width / 2;

        faceAngle = gm.getAngle(centerPoint, targetPoint);
        
        x_velocity += deltaTime * (int) (Math.sin(Math.toRadians(faceAngle)) * (walkRunModifier * speed));
        y_velocity += deltaTime * (int) (Math.cos(Math.toRadians(faceAngle)) * (walkRunModifier * speed));
        
        y_velocity = -y_velocity * 0.5f;
        
        //Collision Check - Going Right
        if (x_velocity > 0) {
            if (gm.getCollision(centerTileX + 1, centerTileY))
            {
                x_velocity = 0;
            }
        }
        //Collision Check - Going Left
        if (x_velocity < 0) {
            if (gm.getCollision(centerTileX - 1, centerTileY))
            {
                x_velocity = 0;
            }
        }
        //Collision Check - Going Down
        if (y_velocity > 0) {
            if (gm.getCollision(centerTileX, centerTileY + 1))
            {
                y_velocity = 0;
            }
        }
        //Collision Check - Going Up
        if (y_velocity < 0) {
            if (gm.getCollision(centerTileX, centerTileY - 1))
            {
                y_velocity = 0;
            }
        }
        
        
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
        
        
        centerPoint.x = (int) posX + gm.TILE_SIZE;
        centerPoint.y = (int) posY + gm.TILE_SIZE + gm.TILE_SIZE / 2;
        centerTileX = centerPoint.x / GameManager.TILE_SIZE;
        centerTileY = centerPoint.y / GameManager.TILE_SIZE;
        
//        tileX = centerPoint.x / gm.TILE_SIZE;;
//        tileY = centerPoint.y / gm.TILE_SIZE;

        
        gm.setMicrophone(centerPoint);
        
        currentTileType = gm.getTileType(centerTileX, centerTileY);
        tileTypeStr = gm.getTileTypeString(currentTileType);
                
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

    public int getCenterTileX()
    {
        return centerTileX;
    }

    public int getCenterTileY()
    {
        return centerTileY;
    }
    
    public void aabbCollision(GameObject other, String tag) {
        //Checks if colliding with a object with tag set to platform
        if (other.getTag().equalsIgnoreCase(tag))
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

    public boolean isChase()
    {
        return chase;
    }

    public void setChase(boolean chase)
    {
        this.chase = chase;
    }

    public String getChaseTarget()
    {
        return chaseTarget;
    }

    public void setChaseTarget(String chaseTarget)
    {
        this.chaseTarget = chaseTarget;
    }
    
    
    
}
