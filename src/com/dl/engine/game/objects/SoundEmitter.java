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
import com.dl.engine.gfx.Image;
import controller.assets.assetsController;
import java.awt.Point;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

/**
 *
 * @author Luiz
 */
public class SoundEmitter extends GameObject
{

    SoundClip soundclip;
    private boolean isPlaying = true;
    private float pan = 0f;
    private float newPan = 0f;
    private float volume = 0f;
    private boolean isDead = false;

    private int posX;
    private int posY;

    private Point distanceToMic;

    private boolean is3d = false;
    private final int min = -256;
    private final int max = 256;

    private Image speakerImage;

    public SoundEmitter(String tag, String path, int posX, int posY, boolean is3d)
    {
        this.tag = tag;
        this.soundclip = new SoundClip(path);
        this.posX = posX * GameManager.TILE_SIZE;
        this.posY = posY * GameManager.TILE_SIZE;
        this.is3d = is3d;

        distanceToMic = new Point(posX, posY);
        speakerImage = new Image(assetsController.ICON_SPEAKER);

        play();
    }

    @Override
    public void update(GameEngine ge, GameManager gm, float deltaTime)
    {
        if (is3d)
        {
            distanceToMic = getDistanceToMicrophone(gm.getMicrophone());
            newPan = normalize(distanceToMic.x);
            if (newPan != pan) {
                pan = newPan;
                
                this.soundclip.setPan(pan);
            }
            //volume -= 1f;
            //this.soundclip.setVolume(volume);
        }

        
        
        /*
        soundclip.getClip().addLineListener(new LineListener()
        {
            public void update(LineEvent evt)
            {
                if (evt.getType() == LineEvent.Type.STOP)
                {
                    evt.getLine().close();
                    isDead = true;
                }
            }
        });
        */

        this.dead = isDead;
    }

    @Override
    public void render(GameEngine ge, Renderer r)
    {
        r.drawImage(speakerImage, posX, posY);

        r.drawText("Tag: " + this.tag, posX - 4, posY + 20, 0xff000000);
        r.drawText("Dist. to Mic. X: " + distanceToMic.x, posX, posY + 30, 0xff000000);
        r.drawText("Dist. to Mic. Y: " + distanceToMic.y, posX, posY + 40, 0xff000000);
        r.drawText("Norm. Dist H: " + pan, posX, posY + 50, 0xff000000);
    }

    @Override
    public void collision(GameObject other)
    {

    }

    public void play()
    {
        soundclip.play();
    }

    public void pause()
    {
        soundclip.pauseResume();
        this.isPlaying = !isPlaying;
    }

    public void stop()
    {
        soundclip.stop();
    }

    public float normalize(float input)
    {
        float average = (min + max) / 2;
        float range = (max - min) / 2;
        float normalized_x = (input - average) / range;
        return normalized_x;
    }

    public Point getDistanceToMicrophone(Point microphone)
    {
        Point p = new Point();

        p.x = this.posX - microphone.x;
        p.y = this.posY - microphone.y;

        return p;
    }

}
