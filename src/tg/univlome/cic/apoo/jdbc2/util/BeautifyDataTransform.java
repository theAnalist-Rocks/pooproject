/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.jdbc2.util;

import java.util.ArrayList;
import java.util.List;
import tg.univlome.cic.apoo.jdbc2.entities.Personne;

/**
 *
 * @author leBoulanger
 */
public class BeautifyDataTransform {
    public String[] transformStringPersonne(Personne p) {
        String[] infos = new String[4];
        infos[0] = p.getId() + "";
        infos[1] = p.getNom();
        infos[2] = p.getPrenom();
        infos[3] = ""+p.getAge()+"";
        return infos;
    }
    
    public String[][] transform(List<Personne> l) {
        String[][] data = new String[40][4];
        int cpt=0;
        for (Personne personne : l) {
            data[cpt][0] = personne.getId() +"";
            data[cpt][1] = personne.getNom();
            data[cpt][2] = personne.getPrenom();
            data[cpt][3] = personne.getAge()+"";
            cpt ++;
        }
        return data;
    }
   
}
