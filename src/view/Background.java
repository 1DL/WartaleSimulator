package view;

/**
 *
 * @author Luiz a.k.a. DL
 */
public class Background {
    public int timerCounter = 0;
    public int NegY = 0;
    public int NegX = 0;
    public int PosY = 0;
    public int PosX = 0;
    boolean flagFadeActive = false;
    String bgImagePath = "";

    public Background(int x, int y, String bgImagePath) {
        NegX = (800 - x);
        NegY = (600 - y);
        PosX = (x - 800);
        PosY = (y - 600);
        this.bgImagePath = bgImagePath;
    }
    
    
}
