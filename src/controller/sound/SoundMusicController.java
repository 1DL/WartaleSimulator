package controller.sound;

import controller.game.main;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.Player;

public class SoundMusicController {
    //private static int frameCounter = 0;
    private static int trackIndex = 0;
    private final static int NOTSTARTED = 0;
    private final static int PLAYING = 1;
    private final static int PAUSED = 2;
    private final static int FINISHED = 3;
    private final static int NEXTSONG = 4;
    ArrayList<String> trackList;
    // the player actually doing all the work
    private Player player;

    // locking object used to communicate with player thread
    private final Object playerLock = new Object();

    // status variable what player thread is doing/supposed to do
    private int playerStatus = NOTSTARTED;
    
    public SoundMusicController(ArrayList<String> trackList)throws JavaLayerException, FileNotFoundException {
        //Recebe um array list de strings contendo o nome das músicas
        this.trackList = trackList;
        //Embaralha a ordem
        Collections.shuffle(trackList);
        //Cria um FileInputStream dos dados do arquivo
        String trackPath = "/assets/bgm/"+trackList.get(trackIndex);
        InputStream music = getClass().getResourceAsStream(trackPath); 
        //Inicializa o player com o stream
        player = new Player(music);
    }
    
    public SoundMusicController(String singleTrack)throws JavaLayerException, FileNotFoundException {
        //Cria um arraylist auxiliar para adicionar a única música a ser tocada
        ArrayList<String> lista = new ArrayList<>();
        lista.add(singleTrack);
        //Adiciona ao array de tracklist, o array auxiliar
        this.trackList = lista;
        //Cria um FileInputStream dos dados do arquivo
        String trackPath = "/assets/bgm/"+trackList.get(trackIndex);
        InputStream music = getClass().getResourceAsStream(trackPath); 
        //Inicializa o player com o stream
        player = new Player(music);
    }

    public SoundMusicController(final InputStream inputStream, final AudioDevice audioDevice) throws JavaLayerException {
        this.player = new Player(inputStream, audioDevice);
    }

    /**
     * Starts playback (resumes if paused)
     */
    public void play() throws JavaLayerException {
        synchronized (playerLock) {
            switch (playerStatus) {
                case NOTSTARTED:
                    final Runnable r = new Runnable() {
                        public void run() {
                            playInternal();
                        }
                    };
                    final Thread t = new Thread(r);
                    t.setDaemon(true);
                    t.setPriority(Thread.MAX_PRIORITY);
                    playerStatus = PLAYING;
                    t.start();
                    break;
                case PAUSED:
                    resume();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Pauses playback. Returns true if new state is PAUSED.
     */
    public boolean pause() {
        synchronized (playerLock) {
            if (playerStatus == PLAYING) {
                playerStatus = PAUSED;
            }
            return playerStatus == PAUSED;
        }
    }

    /**
     * Resumes playback. Returns true if the new state is PLAYING.
     * @return 
     */
    public boolean resume() {
        synchronized (playerLock) {
            if (playerStatus == PAUSED) {
                playerStatus = PLAYING;
                playerLock.notifyAll();
            }
            return playerStatus == PLAYING;
        }
    }

    /**
     * Stops playback. If not playing, does nothing
     */
    public void stop() {
        synchronized (playerLock) {
            playerStatus = FINISHED;
            playerLock.notifyAll();
        }
    }
    
    /**
     * Calls for next Song playback. If not playing, does nothing
     */
    public void nextSong() {
        synchronized (playerLock) {
            playerStatus = NEXTSONG;
            playerLock.notifyAll();
        }
    }

    private void playInternal() {
        while (playerStatus != FINISHED) {
            //frameCounter++;
            //System.out.println(frameCounter);
            try {
                
                if (!player.play(1) || (playerStatus == NEXTSONG)) {
                    close();
                    trackIndex++;
                    if (trackIndex > trackList.size()-1){
                        trackIndex = 0;
                    }
                    String trackPath = "/assets/bgm/"+trackList.get(trackIndex);
                    InputStream music = getClass().getResourceAsStream(trackPath);
                    player = new Player(music);
                    player.play();
                    playerStatus = PLAYING;
                }
            } catch (final JavaLayerException e) {
                e.printStackTrace();
                break;
            }
            // check if paused or terminated
            synchronized (playerLock) {
                while (playerStatus == PAUSED) {
                    try {
                        playerLock.wait();
                    } catch (final InterruptedException e) {
                        // terminate player
                        break;
                    }
                }
            }
        }
        close();
    }

    /**
     * Closes the player, regardless of current state.
     */
    public void close() {
        synchronized (playerLock) {
            playerStatus = FINISHED;
        }
        try {
            player.close();
        } catch (final Exception e) {
            // ignore, we are terminating anyway
        }
    }
    
    public void playPause(JButton btn){
        if (main.flagBgm) {
            this.pause();
            btn.setIcon(new ImageIcon(getClass().getResource("/assets/images/btnBGMoff.png")));
            main.flagBgm = false;
        } else {
            this.resume();
            btn.setIcon(new ImageIcon(getClass().getResource("/assets/images/btnBGM.png")));
            main.flagBgm = true;
        }
    }

    // demo how to use
    /*
    public static void main(String[] argv) {
        try { 
            //File file = new File("/assets/bgm/tos_SFA_The_Dignity_of_Wrath.mp3");
            String[] musicas = {"tos_SoundTeMP_Topaz.mp3", "tos_SFA_The_Dignity_of_Wrath.mp3"};
            FileInputStream input = new FileInputStream("src/assets/bgm/"+musicas[1]); 
            Mp3 player = new Mp3(input);

            // start playing
            player.play();

            // after 5 secs, pause
            Thread.sleep(5000);
            player.playerStatus = FINISHED;
            FileInputStream input2 = new FileInputStream("src/assets/bgm/"+musicas[0]); 
            Mp3 player2 = new Mp3(input2);
            player2.play();
            //player.pause();     

            // after 5 secs, resume
            Thread.sleep(5000);
            //player.resume();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
    */
    

}