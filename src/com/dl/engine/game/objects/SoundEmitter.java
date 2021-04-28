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

    private final int VERTICAL = 0;
    private final int HORIZONTAL = 1;

    SoundClip soundclip;
    private boolean isPlaying = true;
    private float pan = 0f;
    private float newPan = 0f;
    private float volume = 0f;
    private float v_fade = 0f;
    private float h_fade = 0f;
    private float fade = 0f;
    private float new_fade = 0f;
    private float masterVolume = 0f;
    private boolean isDead = false;

    private int posX;
    private int posY;

    private Point distanceToMic;

    private boolean is3d = false;
    private final int pan_min = -128;
    private final int pan_max = 128;
    private final int fade_min = -1000;
    private final int fade_max = 1000;

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
            newPan = normalize(distanceToMic.x, HORIZONTAL);
            h_fade = normalize(distanceToMic.x, VERTICAL);
            v_fade = normalize(distanceToMic.y, VERTICAL);
            if (newPan != pan)
            {
                pan = newPan;
                this.soundclip.setPan(pan);
            }
            new_fade = v_fade + h_fade / 2;
            
            if (new_fade != fade)
            {
                fade = new_fade;
                
                masterVolume = volume + fade;
                
                if (masterVolume < -80)
                {
                    masterVolume = -80;
                }
                if (masterVolume > 0)
                {
                    masterVolume = 0;
                }
                this.soundclip.setVolume(masterVolume);
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
        r.drawText("Master Vol.: " + masterVolume, posX, posY + 30, 0xff000000);
        r.drawText("Dist. to Mic. X: " + distanceToMic.x, posX, posY + 40, 0xff000000);
        r.drawText("Dist. to Mic. Y: " + distanceToMic.y, posX, posY + 50, 0xff000000);
        r.drawText("Norm. Dist H: " + pan, posX, posY + 60, 0xff000000);
        r.drawText("Norm. Dist V: " + fade, posX, posY + 70, 0xff000000);
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
        this.dead = true;
    }

    public float normalize(float input, int axis)
    {
        float average = 0;
        float range = 0;
        if (axis == VERTICAL)
        {
            average = (fade_min + fade_max) / 1;
            range = (fade_max - fade_min) / 80;
        } else if (axis == HORIZONTAL)
        {
            average = (pan_min + pan_max) / 2;
            range = (pan_max - pan_min) / 2;
        }

        float normalized_x = (input - average) / range;

        if (axis == VERTICAL)
        {
            if (normalized_x > 0)
            {
                normalized_x = -normalized_x;
            }
        }

        return normalized_x;
    }

    public Point getDistanceToMicrophone(Point microphone)
    {
        Point p = new Point();

        p.x = this.posX - microphone.x;
        p.y = this.posY - microphone.y;

        return p;
    }

    public float getVolume()
    {
        return volume;
    }

    public void setVolume(float volume)
    {
        this.volume = volume;
    }

}
