/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation;

import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author LuizV1
 */
public class FadeWorker {

    public SwingWorker bufferImg(String imagePath, float numAlphaSamples, int interval, boolean fadeInOut, JLabel label, JProgressBar bar) {
        SwingWorker<Void, ImageIcon> bufferWorker = new SwingWorker<Void, ImageIcon>() {
            
            float forStep = 1.0f / numAlphaSamples;
            int barCounter = 0;
            float i;
            float forCond;
            float test = numAlphaSamples;
            final boolean IN = true;
            final boolean OUT = false;

            @Override
            protected Void doInBackground() throws Exception {
                barCounter = 0;
                if (fadeInOut == OUT) {
                    for (float i = 1f; i >= 0f; i = i - numAlphaSamples) {
                        TransparentImg tImg = new TransparentImg(imagePath, i);
                        publish(tImg.gerarImgTransp());
                        if (interval != 0) {
                            Thread.sleep(interval);  
                        }                        
                        barCounter++;
                    }

                    TransparentImg tImg = new TransparentImg(imagePath, 0f);
                    publish(tImg.gerarImgTransp());
                    Thread.sleep(interval);
                    barCounter++;

                } else {
                    for (float i = 0f; i <= 1.0f; i = i + numAlphaSamples) {
                        TransparentImg tImg = new TransparentImg(imagePath, i);
                        publish(tImg.gerarImgTransp());
                        Thread.sleep(interval);
                        barCounter++;
                    }

                    TransparentImg tImg = new TransparentImg(imagePath, 1f);
                    publish(tImg.gerarImgTransp());
                    Thread.sleep(interval);
                    barCounter++;
                }

                return null;
            }

            @Override
            protected void process(List<ImageIcon> chunks) {
                ImageIcon icon = chunks.get(chunks.size() - 1);
                label.setIcon(icon);
                bar.setValue(barCounter);
            }

            @Override
            protected void done() {
                bar.setValue(bar.getMaximum());
                this.cancel(true);
            }

        };

        return bufferWorker;
    }
}
