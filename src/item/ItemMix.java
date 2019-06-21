/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

/**
 *
 * @author Luiz
 */
public class ItemMix extends Item {

    private String listaMix[];
    private String efeito[];
    String sheltomRequired;
    
    public ItemMix(){
        
    }

    public String[] gerarListaMix(String itemType) {
        switch (itemType) {
            case "Weapon":
                String lista[] = {
                    "Transparo Critical Mix",
                    "Murky Dexterity Mix",
                    "Murky Critical Mix",
                    "Devine Dexterity Mix",
                    "Devine Critical Mix",
                    "Celesto Dexterity Mix",
                    "Celesto Critical Mix #1",
                    "Celesto Critical Mix #2",
                    "Mirage Dexterity Mix",
                    "Mirage Critical Mix #1",
                    "Mirage Critical Mix #2",
                    "Inferna Dexterity Mix",
                    "Inferna Critical Mix #1",
                    "Inferna Critical Mix #2",
                    "Enigma Dexterity Mix",
                    "Enigma Critical Mix #1",
                    "Enigma Critical Mix #2",
                    "Bellum Dexterity Mix",
                    "Bellum Critical Mix #1",
                    "Bellum Critical Mix #2",
                    "Oredo Dexterity Mix",
                    "Oredo Critical Mix #1",
                    "Oredo Critical Mix #2",
                    "Oredo Swiftness Mix",
                    "Sapphire Dexterity Mix",
                    "Sapphire Critical Mix #1",
                    "Sapphire Critical Mix #2",
                    "Sapphire Vigor Mix",
                    "Sapphire Swiftness Mix",
                    "Sol Dexterity Mix",
                    "Sol Critical Mix #1",
                    "Sol Critical Mix #2",
                    "Sol Vigor Mix",
                    "Sol Swiftness Mix",};

                String listaEfeito[] = {
                    "MinAP+3/MaxAP+4/Crit+1",
                    "MaxAP+6/AR+45/HP+10",
                    "MinAP+4/MaxAP+5/Crit+2",
                    "MinAP+4/MaxAP+7/AR+55/HP+15",
                    "MinAP+5/MaxAP+6/Crit+2",
                    "MinAP+5/MaxAP+9/AR+75/HP+20",
                    "MinAP+8/MaxAP+8/Crit+3/MP+20",
                    "MinAP+8/MaxAP+8/Crit+2/HP+20",
                    "MinAP+6/MaxAP+11/AR+90/HP+20",
                    "MinAP+8/MaxAP+10/Crit+3/MP+25",
                    "MinAP+8/MaxAP+10/Crit+2/HP+20",
                    "MinAP+8/MaxAP+13/AR+100/HP+25",
                    "MinAP+10/MaxAP+12/Crit+4/MP+25",
                    "MinAP+10/MaxAP+12/Crit+3/HP+25",
                    "MinAP+10/MaxAP+15/AR+115/HP+25",
                    "MinAP+12/MaxAP+14/Crit+4/MP+30",
                    "MinAP+12/MaxAP+14/Crit+3/HP+25",
                    "MinAP+12/MaxAP+17/AR+130/HP+30",
                    "MinAP+14/MaxAP+16/Crit+5/MP+30",
                    "MinAP+14/MaxAP+16/Crit+4/HP+30",
                    "MinAP+14/MaxAP+19/AR+150/HP+30",
                    "MinAP+16/MaxAP+18/Crit+5/MP+40",
                    "MinAP+16/MaxAP+18/Crit+4/HP+35",
                    "WpnSpd+1/AR+130/MP+80",
                    "MinAP+17/MaxAP+22/AR+180/HP+40",
                    "MinAP+19/MaxAP+21/Crit+7/MP+50",
                    "MinAP+19/MaxAP+21/Crit+5/HP+40",
                    "MinAP+26/MaxAP+26/MP+25",
                    "WpnSpd+1/AR+150/Crit+6/MP+100",
                    "MinAP+20/MaxAP+25/AR+210/HP+50",
                    "MinAP+22/MaxAP+24/Crit+9/MP+60",
                    "MinAP+22/MaxAP+24/Crit+7/HP+45",
                    "MinAP+29/MaxAP+29/MP+35",
                    "WpnSpd+1/AR+170/Crit+8/MP+120",};

                listaMix = lista;
                efeito = listaEfeito;
                break;

            case "Armor":
            case "Robe":
                String lista2[] = {
                    "Transparo Fortitude Mix",
                    "Transparo Vitality Mix",
                    "Murky Fortitude Mix",
                    "Murky Vitality Mix",
                    "Devine Fortitude Mix",
                    "Devine Vitality Mix",
                    "Celesto Fortitude Mix",
                    "Celesto Vitality Mix",
                    "Mirage Fortitude Mix",
                    "Mirage Vitality Mix",
                    "Inferna Fortitude Mix",
                    "Inferna Vitality Mix",
                    "Enigma Fortitude Mix",
                    "Enigma Vitality Mix",
                    "Bellum Fortitude Mix",
                    "Bellum Vitality Mix",
                    "Oredo Fortitude Mix",
                    "Oredo Vitality Mix",
                    "Sapphire Fortitude Mix",
                    "Sapphire Vitality Mix",
                    "Sapphire Finesse Mix",
                    "Sol Fortitude Mix",
                    "Sol Vitality Mix",
                    "Sol Finesse Mix",};

                String listaEfeito2[] = {
                    "MP+10/Def+50/Abs+1",
                    "HP+8/Def+20/Abs+0.6",
                    "MP+15/Def+75/Abs+2",
                    "HP+8/Def+30/Abs+1",
                    "MP+20/Def+100/Abs+3",
                    "HP+25/Def+10",
                    "MP+30/Def+150/Abs+3.5",
                    "HP+10/Def+50/Abs+2",
                    "MP+50/Def+200/Abs+4",
                    "HP+15/Def+75/Abs+2.5",
                    "MP+70/Def+250/Abs+4.5",
                    "HP+25/Def+100/Abs+3",
                    "MP+90/Def+300/Abs+5",
                    "HP+35/Def+125/Abs+3.5",
                    "MP+110/Def+350/Abs+6",
                    "HP+45/Def+150/Abs+4",
                    "MP+130/Def+400/Abs+7",
                    "HP+60/Def+200/Abs+5",
                    "MP+150/Def+450/Abs+8",
                    "HP+75/Def+250/Abs+6",
                    "HP+80/Abs+15/Org+15/Ice+15/Lgt+15/Psn+15",
                    "MP+170/Def+500/Abs+9",
                    "HP+90/Def+300/Abs+7",
                    "HP+100/Abs+17/Org+17/Ice+17/Lgt+17/Psn+17",};
                listaMix = lista2;
                efeito = listaEfeito2;
                break;

            case "Shield":
                String lista3[] = {
                    "Transparo Vitality Mix",
                    "Murky Vitality Mix",
                    "Devine Vitality Mix",
                    "Celesto Vitality Mix #1",
                    "Celesto Vitality Mix #2",
                    "Mirage Fortitude Mix",
                    "Mirage Vitality Mix",
                    "Inferna Fortitude Mix",
                    "Inferna Vitality Mix",
                    "Enigma Vitality Mix",
                    "Enigma Fortitude Mix",
                    "Bellum Fortitude Mix",
                    "Bellum Vitality Mix",
                    "Oredo Vitality Mix #1",
                    "Oredo Vitality Mix #2",
                    "Sapphire Vitality Mix #1",
                    "Sapphire Vitality Mix #2",
                    "Sapphire Block Mix",
                    "Sol Vitality Mix #1",
                    "Sol Vitality Mix #2",
                    "Sol Block Mix",};

                String listaEfeito3[] = {
                   "HP+4/Def+20/Abs+0.6/Blk+1",
                    "HP+6/Def+25/Abs+0.8/Blk+1",
                    "HP+8/Def+30/Abs+1/Blk+2",
                    "HP+10/Def+35/Abs+1.2/Blk+2",
                    "HP+15/Def+45/Abs+1.6/Blk+2",
                    "HP+40/Def+80/Abs+1",
                    "HP+25/Def+50/Abs+1.8/Blk+4",
                    "HP+40/MP+80",
                    "HP+30/Def+75/Abs+2.5/Blk+4",
                    "HP+30/Def+100/Abs+3/Blk+5",
                    "HP+35/MP+10/Def+100/Abs+2.8/Blk+5",
                    "HP+40/MP+10/Def+120/Abs+2.4/Blk+5",
                    "HP+45/Def+150/Abs+4.6/Blk+5",
                    "HP+50/Def+175/Abs+5/Blk+6",
                    "HP+60/Def+200/Abs+5.4/Blk+7",
                    "HP+65/Def+225/Abs+6/Blk+7",
                    "HP+70/Def+250/Abs+6.5/Blk+8",
                    "HP+80/Blk+12",
                    "HP+75/Def+275/Abs+6.9/Blk+8",
                    "HP+80/Def+300/Abs+7.3/Blk+9",
                    "HP+90/Blk+14",};
                listaMix = lista3;
                efeito = listaEfeito3;
                break;

            case "Orb":
                String lista4[] = {
                    "Transparo Vitality Mix",
                    "Murky Vitality Mix",
                    "Devine Vitality Mix",
                    "Celesto Vitality Mix",
                    "Mirage Vitality Mix",
                    "Inferna Vitality Mix",
                    "Enigma Vitality Mix",
                    "Bellum Vitality Mix",
                    "Oredo Vitality Mix",
                    "Sapphire Fortitude Mix",
                    "Sapphire Vitality Mix",
                    "Sapphire Block Mix",
                    "Sol Fortitude Mix",
                    "Sol Vitality Mix",
                    "Sol Block Mix",};

                String listaEfeito4[] = {
                    "HP+4/Def+20/Abs+0.6/Blk+1",
                    "HP+6/Def+30/Abs+1/Blk+1",
                    "HP+8/Def+40/Abs+1.4/Blk+1",
                    "HP+15/Def+60/Abs+2/Blk+1",
                    "HP+25/Def+70/Abs+2.2/Blk+1",
                    "HP+30/Def+95/Abs+2.8/Blk+1",
                    "HP+35/Def+120/Abs+3.6/Blk+2",
                    "HP+45/Def+170/Abs+6/Blk+2",
                    "HP+60/Def+220/Abs+7/Blk+3",
                    "MP+200/Def+270/Abs+8/Blk+5",
                    "HP+80/Def+270/Abs+8/Blk+4",
                    "HP+130/SP+60/Blk+10",
                    "MP+250/Def+320/Abs+9/Blk+6",
                    "HP+100/Def+320/Abs+9/Blk+5",
                    "HP+150/SP+80/Blk+12",};
                listaMix = lista4;
                efeito = listaEfeito4;
                break;

            case "Bracelet":
                String lista5[] = {
                    "Devine Dexterity Mix",
                    "Devine Vitality Mix",
                    "Celesto Vitality Mix",
                    "Celesto Dexterity Mix",
                    "Mirage Vitality Mix",
                    "Mirage Dexterity Mix",
                    "Inferna Dexterity Mix",
                    "Inferna Vitality Mix",
                    "Enigma Dexterity Mix",
                    "Enigma Vitality Mix",
                    "Bellum Dexterity Mix",
                    "Bellum Vitality Mix",
                    "Oredo Dexterity Mix",
                    "Oredo Vitality Mix",
                    "Sapphire Dexterity Mix",
                    "Sapphire Vitality Mix",
                    "Sol Dexterity Mix",
                    "Sol Vitality Mix",};

                String listaEfeito5[] = {
                    "AR+20/Def+20/MP+15/SP+12",
                    "HP+3/Def+15/MP+10/SP+8",
                    "HP+5/Def+20/MP+15/SP+10",
                    "AR+30/Def+25/MP+20/SP+15",
                    "HP+10/Def+30/MP+20/SP+20",
                    "AR+50/Def+40/MP+25/SP+25",
                    "AR+70/Def+55/MP+30/SP+35",
                    "HP+15/Def+40/MP+25/SP+30",
                    "AR+90/Def+70/MP+35/SP+45",
                    "HP+20/Def+50/MP+30/SP+40",
                    "AR+110/Def+95/MP+40/SP+55",
                    "HP+25/Def+60/MP+35/SP+50",
                    "AR+130/Def+110/MP+45/SP+65",
                    "HP+30/Def+70/MP+40/SP+60",
                    "AR+150/Def+130/MP+55/SP+75",
                    "HP+40/Def+80/MP+50/SP+70",
                    "AR+170/Def+150/MP+65/SP+85",
                    "HP+50/Def+90/MP+60/SP+80",};
                listaMix = lista5;
                efeito = listaEfeito5;
                break;

            case "Gauntlet":
                String lista6[] = {
                    "Devine Vitality Mix",
                    "Devine Fortitude Mix",
                    "Celesto Fortitude Mix",
                    "Celesto Vitality Mix",
                    "Mirage Fortitude Mix",
                    "Mirage Vitality Mix",
                    "Inferna Fortitude Mix",
                    "Inferna Vitality Mix",
                    "Enigma Fortitude Mix",
                    "Enigma Vitality Mix",
                    "Bellum Fortitude Mix",
                    "Bellum Vitality Mix",
                    "Oredo Fortitude Mix",
                    "Oredo Vitality Mix",
                    "Sapphire Fortitude Mix",
                    "Sapphire Vitality Mix",
                    "Sol Fortitude Mix",
                    "Sol Vitality Mix",};

                String listaEfeito6[] = {
                    "HP+8/SP+30/Abs+0.8/Def+10",
                    "MP+25/SP+30/Abs+0.8/Def+40",
                    "MP+30/SP+40/Abs+1/Def+50",
                    "HP+10/SP+40/Abs+1/Def+20",
                    "MP+40/SP+60/Abs+2/Def+75",
                    "HP+15/SP+60/Abs+2/Def+40",
                    "MP+50/SP+80/Abs+3/Def+100",
                    "HP+20/SP+80/Abs+3/Def+60",
                    "MP+60/SP+100/Abs+4/Def+125",
                    "HP+25/SP+100/Abs+4/Def+80",
                    "MP+70/SP+120/Abs+5/Def+150",
                    "HP+30/SP+120/Abs+5/Def+100",
                    "MP+80/SP+140/Abs+6/Def+175",
                    "HP+35/SP+140/Abs+6/Def+120",
                    "MP+90/SP+160/Abs+7/Def+200",
                    "HP+40/SP+160/Abs+7/Def+140",
                    "MP+100/SP+180/Abs+8/Def+225",
                    "HP+45/SP+180/Abs+8/Def+160",};
                listaMix = lista6;
                efeito = listaEfeito6;
                break;

            case "Boots":
                String lista7[] = {
                    "Devine Velocity Mix",
                    "Devine Fortitude Mix",
                    "Celesto Fortitude Mix",
                    "Celesto Velocity Mix",
                    "Mirage Fortitude Mix",
                    "Mirage Velocity Mix",
                    "Inferna Fortitude Mix",
                    "Inferna Velocity Mix",
                    "Enigma Fortitude Mix",
                    "Enigma Velocity Mix",
                    "Bellum Fortitude Mix",
                    "Bellum Velocity Mix",
                    "Oredo Fortitude Mix",
                    "Oredo Velocity Mix",
                    "Sapphire Fortitude Mix",
                    "Sapphire Velocity Mix",
                    "Sol Fortitude Mix",
                    "Sol Velocity Mix",
                    "Sol Endurance Mix",};

                String listaEfeito7[] = {
                    "HP+8/Abs+1.2/Spd+0.6",
                    "HP+15/MP+8/Spd+0.4",
                    "HP+20/MP+10/Spd+0.6",
                    "HP+10/Abs+1.8/Spd+1",
                    "HP+25/MP+20/Spd+1",
                    "HP+10/Abs+2.4/Spd+1.6",
                    "HP+30/MP+30/Spd+1.4",
                    "HP+15/Abs+3/Spd+2.2",
                    "HP+35/MP+40/Spd+1.8",
                    "HP+20/Abs+3.6/Spd+3",
                    "HP+40/MP+50/Spd+2.2",
                    "HP+25/Abs+4.2/Spd+3.8",
                    "HP+45/MP+60/Spd+2.6",
                    "HP+30/Abs+4.8/Spd+4.6",
                    "HP+60/MP+70/Spd+3",
                    "HP+35/Abs+5.5/Spd+5.4",
                    "HP+70/MP+80/Spd+3.4",
                    "HP+40/Abs+6.2/Spd+6",
                    "SP+1000/Spd+9",};
                listaMix = lista7;
                efeito = listaEfeito7;
                break;

            case "Amulet":
                String lista8[] = {
                    "Transparo Efficiency Mix",
                    "Murky Efficiency Mix",
                    "Devine Efficiency Mix",
                    "Celesto Efficiency Mix #1",
                    "Celesto Efficiency Mix #2",
                    "Mirage Efficiency Mix #1",
                    "Mirage Efficiency Mix #2",
                    "Inferna Efficiency Mix #1",
                    "Inferna Efficiency Mix #2",
                    "Enigma Efficiency Mix #1",
                    "Enigma Efficiency Mix #2",
                    "Bellum Efficiency Mix #1",
                    "Bellum Efficiency Mix #2",
                    "Oredo Efficiency Mix #1",
                    "Oredo Efficiency Mix #2",
                    "Sapphire Efficiency Mix #1",
                    "Sapphire Efficiency Mix #2",
                    "Sol Efficiency Mix #1",
                    "Sol Efficiency Mix #2",};

                String listaEfeito8[] = {
                    "MP+3/MPReg+0.1",
                    "MP+3/MPReg+0.2",
                    "MP+5/HPReg+0.2/MPReg+0.2",
                    "MP+6/HPReg+0.4/MPReg+0.3",
                    "MP+8/HPReg+0.8/MPReg+0.6",
                    "MP+10/HPReg+1.2/MPReg+0.9",
                    "MP+12/HPReg+1.6/MPReg+1.2",
                    "MP+14/HPReg+2/MPReg+1.5",
                    "MP+16/HPReg+2.4/MPReg+1.8",
                    "MP+18/HPReg+2.8/MPReg+2.1",
                    "MP+20/HPReg+3.2/MPReg+2.4",
                    "MP+22/HPReg+3.6/MPReg+2.7",
                    "MP+24/HPReg+4/MPReg+3",
                    "MP+26/HPReg+4.4/MPReg+3.3",
                    "MP+28/HPReg+4.6/MPReg+3.6",
                    "MP+30/HPReg+5.2/MPReg+3.9",
                    "MP+32/HPReg+5.4/MPReg+4.2",
                    "MP+34/HPReg+6/MPReg+4.5",
                    "MP+36/HPReg+6.2/MPReg+4.8",};
                listaMix = lista8;
                efeito = listaEfeito8;
                break;

            case "Ring":
                String lista9[] = {
                    "Transparo Efficiency Mix",
                    "Murky Efficiency Mix",
                    "Devine Efficiency Mix",
                    "Celesto Efficiency Mix #1",
                    "Celesto Efficiency Mix #2",
                    "Mirage Efficiency Mix #1",
                    "Mirage Efficiency Mix #2",
                    "Inferna Efficiency Mix #1",
                    "Inferna Efficiency Mix #2",
                    "Enigma Efficiency Mix #1",
                    "Enigma Efficiency Mix #2",
                    "Bellum Efficiency Mix #1",
                    "Bellum Efficiency Mix #2",
                    "Oredo Efficiency Mix #1",
                    "Oredo Efficiency Mix #2",
                    "Sapphire Efficiency Mix #1",
                    "Sapphire Efficiency Mix #2",
                    "Sol Efficiency Mix #1",
                    "Sol Efficiency Mix #2",};

                String listaEfeito9[] = {
                    "SP+3/SPReg+0.6",
                    "SP+4/SPReg+0.8",
                    "SP+5/SPReg+1",
                    "SP+6/SPReg+1.2",
                    "SP+8/SPReg+1.6",
                    "HP+2/SP+10/MP+6/SPReg+1",
                    "HP+4/SP+12/MP+8/SPReg+1.4",
                    "HP+6/SP+14/MP+10/SPReg+1.8",
                    "HP+8/SP+16/MP+12/SPReg+2.2",
                    "HP+10/SP+18/MP+14/SPReg+2.6",
                    "HP+12/SP+20/MP+16/SPReg+3",
                    "HP+14/SP+22/MP+18/SPReg+3.4",
                    "HP+16/SP+24/MP+20/SPReg+3.8",
                    "HP+18/SP+26/MP+22/SPReg+4.2",
                    "HP+20/SP+28/MP+24/SPReg+4.6",
                    "HP+22/SP+30/MP+26/SPReg+5",
                    "HP+24/SP+32/MP+28/SPReg+5.4",
                    "HP+26/SP+34/MP+30/SPReg+5.8",
                    "HP+28/SP+36/MP+32/SPReg+6.2",};
                listaMix = lista9;
                efeito = listaEfeito9;
                break;

            case "Sheltom":
                String lista10[] = {
                    "Celesto Aegis Mix",
                    "Celesto Vigor Mix",
                    "Mirage Aegis Mix",
                    "Mirage Vigor Mix",
                    "Inferna Aegis Mix",
                    "Inferna Vigor Mix",
                    "Enigma Aegis Mix",
                    "Enigma Vigor Mix",
                    "Bellum Aegis Mix",
                    "Bellum Vigor Mix",
                    "Oredo Aegis Mix",
                    "Oredo Vigor Mix",
                    "Sapphire Aegis Mix",
                    "Sapphire Vigor Mix",
                    "Sol Aegis Mix",
                    "Sol Vigor Mix",};

                String listaEfeito10[] = {
                    "Def+25",
                    "MinAP+0/MaxAP+1",
                    "Def+60",
                    "MinAP+1/MaxAP+1",
                    "Def+95",
                    "MinAP+1/MaxAP+2",
                    "Def+130",
                    "MinAP+2/MaxAP+2",
                    "Def+165",
                    "MinAP+2/MaxAP+3",
                    "Def+200",
                    "MinAP+3/MaxAP+3",
                    "Def+250",
                    "MinAP+3/MaxAP+4",
                    "Def+300",
                    "MinAP+4/MaxAP+4",};
                listaMix = lista10;
                efeito = listaEfeito10;
                break;

        }
        return listaMix;
    }

    public String[] getListaMix() {
        return listaMix;
    }

    public String[] getEfeito() {
        return efeito;
    }
}
