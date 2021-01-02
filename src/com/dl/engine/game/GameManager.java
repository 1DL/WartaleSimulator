/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game;

import com.dl.engine.AbstractGame;
import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
import com.dl.engine.gfx.Image;
import controller.assets.assetsController;
import java.util.ArrayList;

/**
 *
 * @author Luiz
 */
public class GameManager extends AbstractGame
{
    public static final int TILE_SIZE = 16;
    
    private boolean[] collision;
    private int levelW;
    private int levelH;
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    
    public GameManager()
    {
        objects.add(new Player(6, 4));
        loadLevel(assetsController.STAGES_DIR + "stage1.png");
    }
    
    

    @Override
    public void init(GameEngine ge)
    {
        ge.getRenderer().setAmbientColor(-1);
    }

    @Override
    public void update(GameEngine ge, float deltaTime)
    {
        for(int i = 0; i < objects.size(); i++)
        {
            objects.get(i).update(ge, this, deltaTime);
            if(objects.get(i).isDead())
            {
                objects.remove(i);
                i--;
            }
        }
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
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
        
        for(GameObject obj : objects)
        {
            obj.render(ge, r);
        }
    }
    
    public void loadLevel(String path)
    {
        Image levelImage = new Image(path);
        
        levelW = levelImage.getW();
        levelH = levelImage.getH();
        collision = new boolean[levelW * levelH];
        
        for(int y = 0; y < levelImage.getH(); y++)
        {
            for(int x = 0; x < levelImage.getW(); x++)
            {
                if(levelImage.getP()[x + y * levelImage.getW()] == 0xff000000)
                {
                    collision[x + y * levelImage.getW()] = true;
                }
                else
                {
                    collision[x + y * levelImage.getW()] = false;
                }
            }
        }
    }
    
    public void addObject(GameObject object)
    {
        objects.add(object);
    }
    
    public boolean getCollision(int x, int y)
    {
        if (x < 0 || x >= levelW || y < 0 || y >= levelH)
        {
            return true;
        }
        return collision[x + y * levelW];
    }
    
    public static void main(String args[])
    {
        GameEngine ge = new GameEngine(new GameManager());
        ge.setWidth(320);
        ge.setHeight(240);
        ge.setScale(4f);
        ge.start();
    }
    
}