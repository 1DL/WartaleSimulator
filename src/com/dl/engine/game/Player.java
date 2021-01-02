/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.game;

import com.dl.engine.GameEngine;
import com.dl.engine.Renderer;
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

    private int padding;
    private int paddingTop;

    private int direction = RIGHT;
    private float animationFrame = 0;

    private int tileX;
    private int tileY;
    private float offX;
    private float offY;

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
        this.padding = 5;
        this.paddingTop = 2;
    }

    @Override
    public void update(GameEngine ge, GameManager gm, float deltaTime)
    {
        //Andar para esquerda e direita
        //direita
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
        //esquerda
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

        //Fim do movimento lateral
        //Começo do pulo e gravidade
        fallDistance += deltaTime * fallSpeed;

        if (ge.getInput().isKeyDown(KeyEvent.VK_W) && ground)
        {
            fallDistance = jump;
            ground = false;
        }

        offY += fallDistance;

        if (fallDistance < 0)
        {
            if ((gm.getCollision(tileX, tileY - 1) || gm.getCollision(tileX + (int) Math.signum((int) Math.abs(offX) > padding ? offX : 0), tileY - 1)) 
                    && offY < -paddingTop)
            {
                fallDistance = 0;
                offY = -paddingTop;
            }
        }

        if (fallDistance > 0)
        {
            ground = false;
            if ((gm.getCollision(tileX, tileY + 1) || gm.getCollision(tileX + (int) Math.signum((int) Math.abs(offX) > padding ? offX : 0), tileY + 1)) 
                    && offY > 0)
            {
                fallDistance = 0;
                offY = 0;
                ground = true;
            }
        }

        //Fim do pulo e gravidade
        //Posição Final
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

        //Verifica se apertou botao para atirar projetil
        if (ge.getInput().isKey(KeyEvent.VK_UP))
        {
            gm.addObject(new Bullet(tileX, tileY, offX + width / 2, offY + height / 2, 0));
        }

        if (ge.getInput().isKey(KeyEvent.VK_RIGHT))
        {
            gm.addObject(new Bullet(tileX, tileY, offX + width / 2, offY + height / 2, 1));
        }

        if (ge.getInput().isKey(KeyEvent.VK_DOWN))
        {
            gm.addObject(new Bullet(tileX, tileY, offX + width / 2, offY + height / 2, 2));
        }

        if (ge.getInput().isKey(KeyEvent.VK_LEFT))
        {
            gm.addObject(new Bullet(tileX, tileY, offX + width / 2, offY + height / 2, 3));
        }

        //Check which direction character should face
        if (ge.getInput().isKey(KeyEvent.VK_D))
        {
            direction = RIGHT;
            animationFrame += deltaTime * 8;
            if (animationFrame >= 4)
            {
                animationFrame = 0;
            }
        } else if (ge.getInput().isKey(KeyEvent.VK_A))
        {
            direction = LEFT;
            animationFrame += deltaTime * 8;
            if (animationFrame >= 4)
            {
                animationFrame = 0;
            }
        } else
        {
            animationFrame = 0;
        }

        if (!ground)
        {
            animationFrame = 1;
        }

        if (ground && !groundLast)
        {
            animationFrame = 2;
        }

        groundLast = ground;
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        r.drawImageTile(playerImage, (int) posX, (int) posY, (int) animationFrame, direction);
        //r.drawFillRect((int)posX, (int)posY, width, height, 0xff00ff00);
    }

}
