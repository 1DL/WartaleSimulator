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
        this.bgImagePath = "/assets/images/background/" + generateBGImages(charClass).get(0);
    }

    public ArrayList<String> generateBGImages(String characterClass) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("desert01.jpg");
        lista.add("desert02.jpg");
        lista.add("gsant01.jpg");
        lista.add("gsant02.jpg");
        lista.add("gsant03.jpg");
        if (characterClass.equals("Knight")
                || characterClass.equals("Magician")
                || characterClass.equals("Atalanta")
                || characterClass.equals("Shaman")
                || characterClass.equals("Priestess")) {
            lista.add("all.jpg");
            lista.add("knight_mage_priest_ata01.jpg");
            lista.add("knight_mage_priest_ata02.jpg");
            lista.add("pillai01.jpg");
            lista.add("pillai02.jpg");
            lista.add("pillai03.jpg");
            lista.add("pillai04.jpg");
            lista.add("pillai05.jpg");
            lista.add("pillai06.jpg");
            lista.add("pillai07.jpg");
            lista.add("pillai08.jpg");
            lista.add("morion01.jpg");
            lista.add("morion02.jpg");
        } else {
            lista.add("all.jpg");
            lista.add("ricarten01.jpg");
            lista.add("ricarten02.jpg");
            lista.add("ricarten03.jpg");
            lista.add("ricarten04.jpg");
            lista.add("ricarten05.jpg");
            lista.add("tempskron01.jpg");
            lista.add("tempskron02.jpg");
            lista.add("tempskron03.jpg");
            lista.add("tempskron04.jpg");
        }
        switch (characterClass) {
            case "Knight":
                lista.add("knight_fighter.jpg");
                lista.add("knight_priest_ata.jpg");
                lista.add("knight_ata.jpg");
                lista.add("knight01.jpg");
                lista.add("knight02.jpg");
                break;
            case "Priestess":
                lista.add("priest01.jpg");
                lista.add("priest02.jpg");
                lista.add("priest03.jpg");
                lista.add("priest04.jpg");
                lista.add("priest05.jpg");
                lista.add("priest06.jpg");
                lista.add("priest07.jpg");
                lista.add("priest08.jpg");
                lista.add("priest09.jpg");
                lista.add("knight_priest_ata.jpg");
                lista.add("priest_ata.jpg");
                lista.add("priest_mage.jpg");
                lista.add("archer_ata_priest.jpg");
                break;
            case "Magician":
                lista.add("priest_mage.jpg");
                lista.add("mage01.jpg");
                lista.add("mage02.jpg");
                lista.add("mage03.jpg");
                lista.add("mage04.jpg");
                break;
            case "Shaman":
                break;
            case "Atalanta":
                lista.add("priest_ata.jpg");
                lista.add("knight_ata.jpg");
                lista.add("archer_ata_priest.jpg");
                lista.add("knight_priest_ata.jpg");
                lista.add("ata01.jpg");
                lista.add("ata02.jpg");
                lista.add("ata03.jpg");
                lista.add("ata04.jpg");
                lista.add("ata05.jpg");
                break;
            case "Archer":
                lista.add("archer_ata_priest.jpg");
                lista.add("archer01.jpg");
                lista.add("archer02.jpg");
                lista.add("archer03.jpg");
                lista.add("archer04.jpg");
                break;
            case "Pikeman":
                lista.add("pike01.jpg");
                lista.add("pike02.jpg");
                break;
            case "Mechanician":
                lista.add("mech01.jpg");
                break;
            case "Fighter":
                lista.add("knight_fighter.jpg");
                lista.add("fighter01.jpg");
                break;
            case "Assassin":
                break;

        }

        Collections.shuffle(lista);
        String imageNames = "";
        for (int i = 0; i < lista.size(); i++) {
            imageNames += lista.get(i) + "\n";
        }
        System.out.println("Ordem das imagens aleatórias: " + imageNames);
        return lista;
    }

}
