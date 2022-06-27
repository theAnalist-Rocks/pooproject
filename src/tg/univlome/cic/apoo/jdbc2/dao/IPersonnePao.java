/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tg.univlome.cic.apoo.jdbc2.dao;

import java.util.List;
import tg.univlome.cic.apoo.jdbc2.entities.Personne;

/**
 *
 * @author leBoulanger
 */
public interface IPersonnePao {
    public Personne ajouter(Personne p);
    public Personne modifier(Personne p);
    public Personne enregistrer(Personne p);
    public void supprimer(Personne p);
    public void supprimer(int id);
    public List<Personne> lister();
    public List<Personne> lister(String key);
    public Personne trouver(int id);
}
