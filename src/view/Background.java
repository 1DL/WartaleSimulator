package view;

import java.util.ArrayList;
import java.util.Collections;

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

    public Background(int x, int y, String charClass) {
        
        NegX = (800 - x);
        NegY = (600 - y);
        PosX = (x - 800);
        PosY = (y - 600);
        this.bgImagePath = "/assets/images/background/"+generateBGImages(charClass).get(0);
    }
    
    public ArrayList<String> generateBGImages(String characterClass){
        ArrayList<String> lista = new ArrayList<>();
        switch (characterClass) {
            case "Knight":
                lista.add("all.jpg");
                lista.add("knight_fighter.jpg");
                lista.add("knight_priest_ata.jpg");
                lista.add("knight_ata.jpg");
                lista.add("knight_mage_priest_ata01.jpg");
                lista.add("knight_mage_priest_ata02.jpg");
                lista.add("knight01.jpg");
                lista.add("knight02.jpg");
                lista.add("morion01.jpg");
                lista.add("pillai01.png");
                lista.add("pillai02.png");
                lista.add("pillai03.jpg");
                lista.add("pillai04.jpg");
                lista.add("pillai05.jpg");
                lista.add("pillai06.jpg");
                lista.add("pillai07.jpg");
                lista.add("pillai08.jpg");
                Collections.shuffle(lista);
                break;
        }
        String imageNames = "";
        for (int i = 0; i < lista.size(); i++) {
            imageNames += lista.get(i) + "\n";
        }
        System.out.println("Ordem das imagens aleatórias: "+imageNames);
        return lista;
    }
    
    
}
