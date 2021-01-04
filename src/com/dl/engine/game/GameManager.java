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
import com.dl.engine.game.objects.Fade;
import com.dl.engine.game.objects.Platform;
import com.dl.engine.gfx.Image;
import com.dl.engine.gfx.Light;
import controller.assets.assetsController;
import java.util.ArrayList;

/**
 *
 * @author Luiz
 */
public class GameManager extends AbstractGame
{

    public static final int TILE_SIZE = 16;
    public static final int STATE_INITIALIZING = 0;
    public static final int STATE_BUFF_PHASE = 1;
    public static final int STATE_BATTLE_PHASE = 2;

    private Image backgroundImage;

    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    private Camera camera;

    private boolean[] collision;
    private int levelW;
    private int levelH;
    private int gameState;

    public GameManager()
    {
        objects.add(new Fade(Fade.FADE_IN, 100, 0xFF000000));

        backgroundImage = new Image(assetsController.BACKGROUND_DIR + "battleBG720.png");
        backgroundImage.setAlpha(false);
        //camera = new Camera("player");

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
        //camera.update(ge, this, deltaTime);
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        //camera.render(r);
        r.drawImage(backgroundImage, 0, 0);

        for (GameObject obj : objects)
        {
            obj.render(ge, r);
        }
    }

    public void loadLevel(String path)
    {

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

    public int getLevelW()
    {
        return levelW;
    }

    public int getLevelH()
    {
        return levelH;
    }

    public static void main(String args[])
    {
        GameEngine ge = new GameEngine(new GameManager());
        if (args.length > 0)
        {
            ge.setTitle("DL Java 2D Engine: " + args[0] + " - " + args[1] + ", LV: "
                    + args[2] + " VS " + args[3] + " - " + args[4] + ", LV: " + args[5]);
        }
        ge.setWidth(1280);
        ge.setHeight(720);
        ge.setScale(1f);
        ge.setUseFpsCap(false);
        ge.start();
    }

}
