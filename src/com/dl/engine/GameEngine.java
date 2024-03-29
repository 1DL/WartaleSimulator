/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine;

import com.dl.engine.gfx.Image;
import controller.assets.assetsController;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Luiz
 */
public class GameEngine implements Runnable
{

    private Thread thread;
    private Window window;
    private Renderer renderer;
    private Input input;
    private AbstractGame game;

    private boolean running = false;
    private final double UPDATE_CAP = 1.0 / 60.0;
    private int width = 320;
    private int height = 240;
    private float scale = 3f;
    private String title = "DL Java Engine v1.0";

    private Image cursorImage = new Image(assetsController.CURSOR_DEFAULT);
    private Point mousePoint = new Point();

    public GameEngine(AbstractGame game)
    {
        this.game = game;
    }

    public void start()
    {
        window = new Window(this);
        renderer = new Renderer(this);
        input = new Input(this);

        thread = new Thread(this);
        thread.run();
    }

    public void stop()
    {

    }

    public void run()
    {
        running = true;

        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        game.init(this);

        while (running)
        {
            //set true for uncapped rendering
            render = true;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while (unprocessedTime >= UPDATE_CAP)
            {
                unprocessedTime -= UPDATE_CAP;
                render = true;

                //TODO: Update game
                game.update(this, (float) UPDATE_CAP);

                mousePoint.x = input.getMouseX();
                mousePoint.y = input.getMouseY();


                input.update();

                if (frameTime >= 1.0)
                {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                }
            }

            if (render)
            {
                renderer.clear();
                //TODO: Render game
                game.render(this, renderer);
                renderer.process();
                renderer.setCamX(0);
                renderer.setCamY(0);
                renderer.drawText("FPS: " + fps, 0, 0, 0xffff00ff);
                renderer.drawText("Mouse X: " + input.getMouseX(), 60, 0, 0xffff00ff);
                renderer.drawText("Mouse Y: " + input.getMouseY(), 150, 0, 0xffff00ff);

                renderer.drawImage(cursorImage, input.getMouseX(), input.getMouseY());
                window.update();
                frames++;
            } else
            {
                try
                {
                    Thread.sleep(1);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }

        dispose();
    }


    private void dispose()
    {

    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public float getScale()
    {
        return scale;
    }

    public void setScale(float scale)
    {
        this.scale = scale;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Window getWindow()
    {
        return window;
    }

    public Input getInput()
    {
        return input;
    }

    public Renderer getRenderer()
    {
        return renderer;
    }

}
