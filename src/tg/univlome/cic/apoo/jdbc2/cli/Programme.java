/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.jdbc2.cli;

import tg.univlome.cic.apoo.jdbc2.dao.IPersonnePao;
import tg.univlome.cic.apoo.jdbc2.dao.PersonneDaoImp;
import tg.univlome.cic.apoo.jdbc2.entities.Personne;

/**
 *
 * @author leBoulanger
 */
public class Programme {
    private static final PersonneCli personneCli = new PersonneCli();
    public static void main(String[] args) {
        //Personne p = new Personne("MELANCHON", "Jean-Luc", 39);
        //personneDao.ajouter(p);
        //personneDao.lister("Junior");
//        Personne p = personneDao.trouver(3);
//        System.out.println(p);
//        p.setPrenom("Valère");
//        p.setAge(20);
//        Personne p2 = personneDao.modifier(p);
//        System.out.println(p2);
//        personneDao.lister();
          personneCli.lister();
    }
}
