/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game;

import com.dl.engine.game.objects.Player;
import com.dl.engine.game.objects.GameObject;
import com.dl.engine.AbstractGame;
import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
import com.dl.engine.audio.SoundClip;
import com.dl.engine.game.objects.Platform;
import com.dl.engine.game.objects.SoundEmitter;
import com.dl.engine.gfx.Image;
import com.dl.engine.gfx.Light;
import controller.assets.assetsController;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Luiz
 */
public class GameManager extends AbstractGame
{

    public static final int TILE_SIZE = 16;

    public static final boolean SOUND_3D = true;
    public static final boolean SOUND_CENTER = false;
    
    final int BLACK = 0xff000000;
    final int RED = 0xffff0000;
    final int GREEN = 0xff00ff00;
    final int BLUE = 0xff0000ff;
    final int YELLOW = 0xffffff00;

    public static final int WALL = 1;
    public static final int WATER = 2;
    public static final int SAND = 3;
    public static final int GRASS = 4;
    public static final int AIR = 5;

    //debug info
    private boolean cameraSmooth = true;
    private boolean showCollisionMap = true;
    private boolean walkRunMode = true;
    private float x_velocity = 0;
    private float y_velocity = 0;
    private Point centerOfScreen;

    private Image skyImage = new Image(assetsController.STAGES_DIR + "backgroundStageWIP.png");
    private Image levelImage = new Image(assetsController.TILEMAP_BLESSCASTLE);
    private Image levelCollisionImage = new Image(assetsController.TILEMAP_BLESSCASTLE_COLLISION);

    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    private Camera camera;

    private boolean[] collision;
    private int[] tileType;
    private int levelW;
    private int levelH;

    public int playerTileX = 0;
    public int playerTileY = 0;
    public int playerPosX = 0;
    public int playerPosY = 0;
    public String currentTileType = "none";
    Random rnd;
    
    private Point microphone;


    public GameManager()
    {
        microphone = new Point(256, 144);
        
        objects.add(new Player(30, 30));
        objects.add(new Platform(26 * TILE_SIZE, 7 * TILE_SIZE));
        objects.add(new Platform(29 * TILE_SIZE, 7 * TILE_SIZE));
        objects.add(new Platform(32 * TILE_SIZE, 7 * TILE_SIZE));
        objects.add(new SoundEmitter("Background Music", assetsController.BGM_HUNTER_ENDING, 60, 20, SOUND_3D));
        loadLevel(assetsController.COLLISION_BLESSCASTLE);
        camera = new Camera("player");

        rnd = new Random();

//        bgm = new SoundClip(assetsController.BGM_HUNTER_ENDING);
//        bgm.play();
//        bgm.setVolume(-10.0f);

        centerOfScreen = new Point(512 / 2, 288 / 2);

        //levelImage.setLightBlock(Light.FULL);
    }

    @Override
    public void init(GameEngine ge)
    {
        ge.getRenderer().setAmbientColor(-1);
    }

    @Override
    public void update(GameEngine ge, float deltaTime)
    {
        for (int i = 0; i < objects.size(); i++)
        {
            objects.get(i).update(ge, this, deltaTime);
            if (objects.get(i).isDead())
            {
                objects.remove(i);
                i--;
            }
        }

        Physics.update();
        camera.update(ge, this, deltaTime);
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        camera.render(r);

        r.drawImage(skyImage, (int) camera.getOffX(), (int) camera.getOffY());
        r.drawImage(levelImage, 0, 0);
        if (isShowCollisionMap())
        {
            r.drawImage(levelCollisionImage, 0, 0);
        }

        //Debug text
        r.drawText("Tile X: " + playerTileX, (int) camera.getOffX(), (int) camera.getOffY() + 10, 0xffff0000);
        r.drawText("Tile Y: " + playerTileY, (int) camera.getOffX(), (int) camera.getOffY() + 20, 0xffff0000);
        r.drawText("Type: " + getTileTypeString(playerTileX, playerTileY), (int) camera.getOffX(), (int) camera.getOffY() + 30, 0xffff0000);
        r.drawText("Pos X: " + playerPosX, (int) camera.getOffX(), (int) camera.getOffY() + 40, 0xffff0000);
        r.drawText("Pos Y: " + playerPosY, (int) camera.getOffX(), (int) camera.getOffY() + 50, 0xffff0000);
        r.drawText("Cam Mode: " + getCameraSmoothString(), (int) camera.getOffX(), (int) camera.getOffY() + 60, 0xffff0000);
        r.drawText("Cam Pos X: " + (int) camera.getOffX(), (int) camera.getOffX(), (int) camera.getOffY() + 70, 0xffff0000);
        r.drawText("Cam Pos Y: " + (int) camera.getOffY(), (int) camera.getOffX(), (int) camera.getOffY() + 80, 0xffff0000);
        r.drawText("Run Mode: " + getWalkRunModeString(), (int) camera.getOffX(), (int) camera.getOffY() + 90, 0xffff0000);
        r.drawText("X Vel.: " + getX_velocity(), (int) camera.getOffX(), (int) camera.getOffY() + 100, 0xffff0000);
        r.drawText("Y Vel.: " + getY_velocity(), (int) camera.getOffX(), (int) camera.getOffY() + 110, 0xffff0000);
        r.drawText("Microphone X: " + microphone.x, (int) camera.getOffX(), (int) camera.getOffY() + 120, 0xffff0000);
        r.drawText("Microphone Y" + microphone.y, (int) camera.getOffX(), (int) camera.getOffY() + 130, 0xffff0000);

        /*
        for(int y = 0; y < levelH; y++)
        {
            for(int x = 0; x < levelW; x++)
            {
                if(collision[x + y * levelW])
                {
                    r.drawFillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, 0xff0f0f0f);    
                }
                else
                {
                    r.drawFillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, 0xfff9f9f9);    
                }
            }
        }
         */
        for (GameObject obj : objects)
        {
            obj.render(ge, r);
        }
    }

    public void loadLevel(String path)
    {
        Image collisionImage = new Image(path);

        levelW = collisionImage.getW();
        levelH = collisionImage.getH();
        collision = new boolean[levelW * levelH];
        tileType = new int[levelW * levelH];

        for (int y = 0; y < collisionImage.getH(); y++)
        {
            for (int x = 0; x < collisionImage.getW(); x++)
            {
                if (collisionImage.getP()[x + y * collisionImage.getW()] == 0xff000000)
                {
                    collision[x + y * collisionImage.getW()] = true;
                } else
                {
                    collision[x + y * collisionImage.getW()] = false;
                }
            }
        }

        for (int y = 0; y < collisionImage.getH(); y++)
        {
            for (int x = 0; x < collisionImage.getW(); x++)
            {
                switch (collisionImage.getP()[x + y * collisionImage.getW()])
                {
                    case BLACK:
                        tileType[x + y * collisionImage.getW()] = WALL;
                        break;
                    case BLUE:
                        tileType[x + y * collisionImage.getW()] = WATER;
                        break;
                    case YELLOW:
                        tileType[x + y * collisionImage.getW()] = SAND;
                        break;
                    case GREEN:
                        tileType[x + y * collisionImage.getW()] = GRASS;
                        break;
                    default:
                        tileType[x + y * collisionImage.getW()] = AIR;
                        break;
                }
            }
        }
    }

    public void addObject(GameObject object)
    {
        objects.add(object);
    }

    public GameObject getObject(String tag)
    {
        for (int i = 0; i < objects.size(); i++)
        {
            if (objects.get(i).getTag().equals(tag))
            {
                return objects.get(i);
            }
        }

        return null;
    }

    public boolean getCollision(int x, int y)
    {
        if (x < 0 || x >= levelW || y < 0 || y >= levelH)
        {
            return true;
        }
        return collision[x + y * levelW];
    }

    public int getTileType(int x, int y)
    {
        if (x < 0 || x >= levelW || y < 0 || y >= levelH)
        {
            return AIR;
        }
        return tileType[x + y * levelW];
    }

    public String getTileTypeString(int tileType)
    {
        String tileName = "None";
        
        switch (tileType)
        {
            case WALL:
                tileName = "Wall";
                break;
            case WATER:
                tileName = "Water";
                break;
            case SAND:
                tileName = "Sand";
                break;
            case GRASS:
                tileName = "Grassland";
                break;
            case AIR:
                tileName = "Air";
                break;
            default:
                tileName = "None";
                break;
        }

        return tileName;
    }
    
    public String getTileTypeString(int x, int y)
    {
        String tileName = "None";
        if (x < 0 || x >= levelW || y < 0 || y >= levelH)
        {
            return tileName;
        }
        switch (tileType[x + y * levelW])
        {
            case WALL:
                tileName = "Wall";
                break;
            case WATER:
                tileName = "Water";
                break;
            case SAND:
                tileName = "Sand";
                break;
            case GRASS:
                tileName = "Grassland";
                break;
            case AIR:
                tileName = "Air";
                break;
            default:
                tileName = "None";
                break;
        }

        return tileName;
    }

    public int getLevelW()
    {
        return levelW;
    }

    public int getLevelH()
    {
        return levelH;
    }

    public float getAngle(Point centerPoint, Point targetPoint)
    {
        float theta = (float) Math.atan2(targetPoint.y - centerPoint.y, targetPoint.x - centerPoint.x);

        float angle = (float) Math.toDegrees(theta) + 90;

        if (angle < 0)
        {
            angle += 360;
        }

        return angle;
    }

    public int getIntRandom(int min, int max)
    {
        return min + this.rnd.nextInt(max + 1);
    }

    public static void main(String args[])
    {
        GameEngine ge = new GameEngine(new GameManager());
        ge.setWidth(512);
        ge.setHeight(288);
        ge.setScale(3f);
        ge.start();
    }

    public boolean isCameraSmooth()
    {
        return cameraSmooth;
    }

    public void setCameraSmooth(boolean cameraSmooth)
    {
        this.cameraSmooth = cameraSmooth;
    }

    public boolean isShowCollisionMap()
    {
        return showCollisionMap;
    }

    public void setShowCollisionMap(boolean showCollisionMap)
    {
        this.showCollisionMap = showCollisionMap;
    }

    public String getCameraSmoothString()
    {
        if (isCameraSmooth())
        {
            return "Smooth";
        } else
        {
            return "Fixed";
        }
    }

    public boolean isWalkRunMode()
    {
        return walkRunMode;
    }

    public void setWalkRunMode(boolean walkRunMode)
    {
        this.walkRunMode = walkRunMode;
    }

    public String getWalkRunModeString()
    {
        if (isWalkRunMode())
        {
            return "Running";
        } else
        {
            return "Walking";
        }
    }

    public float getX_velocity()
    {
        return x_velocity;
    }

    public void setX_velocity(float x_velocity)
    {
        this.x_velocity = x_velocity;
    }

    public float getY_velocity()
    {
        return y_velocity;
    }

    public void setY_velocity(float y_velocity)
    {
        this.y_velocity = y_velocity;
    }

    public Point getCenterOfScreen()
    {
        return centerOfScreen;
    }

    public Point getMicrophone()
    {
        return microphone;
    }

    public void setMicrophone(Point microphone)
    {
        this.microphone = microphone;
    }

}
