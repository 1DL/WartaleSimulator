package view;

/**
 *
 * @author Luiz a.k.a. DL
 */
public class Background {
    public int timerCounter = 0;
    public int maxNegY = 0;
    public int maxNegX = 0;
    public int maxPosY = 0;
    public int maxPosX = 0;
    boolean flagFadeActive = false;
    String bgImagePath = "";

    public Background(int x, int y, String bgImagePath) {
        maxNegX = (800 - x);
        maxNegY = (600 - y);
        maxPosX = (x - 800);
        maxPosY = (y - 600);
        this.bgImagePath = bgImagePath;
    }
    
    
}
