/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dl.engine.audio;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Luiz
 */
public class SoundClip {
    
    private static final float NO_PAN_CHANGE = 0.0f;
    
    private Clip clip;
    private FloatControl gainControl;
    
    public SoundClip (String path) {
        
        try {
            
            InputStream audioSrc = SoundClip.class.getResourceAsStream(path);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream ais = AudioSystem.getAudioInputStream(bufferedIn);
            AudioFormat baseFormat = ais.getFormat();
            
            AudioFormat decodeFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(), 
                    baseFormat.getChannels() * 2, 
                    baseFormat.getSampleRate(),
                    false
            );
            
            AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
            
            clip = AudioSystem.getClip();
            clip.open(dais);
            
            gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    public void play() {
        
        if (clip == null) {
            return;
        }
        
        stop();
        
        clip.setFramePosition(0);
        while(!clip.isRunning()) {
            clip.start();
        }
    }
    
    public void stop() {
        if (clip.isRunning()) {
            clip.stop();
        }
    }
    
    public void pauseResume() {
        if (clip.isRunning()) {
            clip.stop();
        } else {
            clip.start();
        }
    }
    
    public void close() {
        stop();
        clip.drain();
        clip.close();
    }
    
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        play();
    }
    
    public void setVolume(float value) {
        gainControl.setValue(value);
    }
    
    public boolean isRunning() {
        return clip.isRunning();
    }
    
    public void setPan(float pan)
    {
        if (pan < -1f) {
            pan = -1f;
        }
        if (pan > 1f) {
            pan = 1f;
        }
        
        if ((clip == null) || (pan == NO_PAN_CHANGE)) 
        {
            FloatControl panControl = (FloatControl) clip.getControl(FloatControl.Type.PAN);
            panControl.setValue(pan);
        } else if (clip.isControlSupported(FloatControl.Type.BALANCE)) {
            FloatControl balControl = (FloatControl) clip.getControl(FloatControl.Type.BALANCE);
            balControl.setValue(pan);
        } else {
            System.out.println("No Pan or Balance controls available");
        }
    }

    public Clip getClip()
    {
        return clip;
    }
    
    public float getVolume()
    {
        return gainControl.getValue();
    }
}
