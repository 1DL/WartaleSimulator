/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

/**
 *
 * @author Administrator
 */
public class Sound {

    Clip clip;

    public void playSound(final String url) {
        if (main.flagBgm) {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        MainFrame.class.getResourceAsStream("/assets/sfx/" + url));
                clip.open(inputStream);
                clip.start();

                clip.addLineListener(new LineListener() {
                    public void update(LineEvent evt) {
                        if (evt.getType() == LineEvent.Type.STOP) {
                            evt.getLine().close();
                        }
                    }
                });

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

    public synchronized void playMusic(final String url) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            MainFrame.class.getResourceAsStream("/assets/bgm/" + url));

                    clip.open(inputStream);
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                    clip.start();

                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}
