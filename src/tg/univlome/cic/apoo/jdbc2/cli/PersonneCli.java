/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.jdbc2.cli;

import java.util.List;
import tg.univlome.cic.apoo.jdbc2.dao.IPersonnePao;
import tg.univlome.cic.apoo.jdbc2.dao.PersonneDaoImp;
import tg.univlome.cic.apoo.jdbc2.entities.Personne;

/**
 *
 * @author leBoulanger
 */
public class PersonneCli {
    IPersonnePao personneDao = new PersonneDaoImp();
    
    
    public void lister() {
        List<Personne> personnes = personneDao.lister();
        for (Personne personne : personnes) {
            System.out.println(personne);
        }
    }
    
    public void lister(String key) {
        List<Personne> personnes = personneDao.lister(key);
        for (Personne personne : personnes) {
            System.out.println(personne);
        }
    }
}
