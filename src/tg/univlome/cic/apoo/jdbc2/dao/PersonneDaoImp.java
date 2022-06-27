/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.jdbc2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc2.Jdbc2;
import java.sql.*;
import java.util.ArrayList;
import tg.univlome.cic.apoo.jdbc2.entities.Personne;
import tg.univlome.cic.apoo.jdbc2.util.Connexion;

/**
 *
 * @author junior=
 */
public class PersonneDaoImp implements IPersonnePao {

    @Override
    public Personne ajouter(Personne p) {
        try{
            Connection connexion = Connexion.getInstance();
            String sql = "INSERT INTO personne(nom, prenom, age) VALUES (?, ?, ?)";
            PreparedStatement statement = connexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getNom());
            statement.setString(2, p.getPrenom());
            statement.setInt(3, p.getAge());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            
            if(result.next()) {
                int id = result.getInt(1);
                p.setId(id);
            }
        } catch(Exception ex) {
            Logger.getLogger(Jdbc2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public Personne modifier(Personne p) {
        // modifie une personne déjà enrégistrée
        if (p.getId()==0) {
            return p;
        }else {
            try {
                Connection con = Connexion.getInstance();
                String sql = "UPDATE personne SET nom=?, prenom=?, age=? WHERE id=?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, p.getNom());
                statement.setString(2, p.getPrenom());
                statement.setInt(3, p.getAge());
                statement.setInt(4, p.getId());
                statement.executeUpdate();
                return p;
            }catch (Exception ex) {
                Logger.getLogger(Jdbc2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return p;
    }

    @Override
    public Personne enregistrer(Personne p) {
//        if(p.getId()==0) {
//            ajouter(p);
//        }
//        else {
//            modifier(p);
//        }
//        return p;
          return (p.getId()==0) ? ajouter(p) : modifier(p);
          
    }

    @Override
    public void supprimer(Personne p) {
        supprimer(p.getId());
    }

    @Override
    public void supprimer(int id) {
            try {
                Connection con = Connexion.getInstance();
                String sql = "DELETE FROM personne WHERE id=?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, id);
                statement.executeUpdate();
            }catch(Exception ex) {
                Logger.getLogger(Jdbc2.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public List<Personne> lister() {
        List<Personne> listePersonnes = new ArrayList<>();
        try {
        Connection connection = Connexion.getInstance();
        String sql = "SELECT * FROM personne"; 
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultat = statement.executeQuery(); 

        while (resultat.next()) {
            listePersonnes.add(this.getPersonne(resultat));
        }
        }catch(Exception ex) {
            Logger.getLogger(Jdbc2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listePersonnes;
    }

    @Override
    public List<Personne> lister(String key) {
        List<Personne> personnes = new ArrayList<>();
        try {
            Connection connection = Connexion.getInstance();
            String sql = "SELECT * FROM personne WHERE nom LIKE ? OR prenom LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql); 
            statement.setString(1, "%"+key+"%");
            statement.setString(2, "%"+key+"%");
            ResultSet resultat = statement.executeQuery();

            while(resultat.next()) {
                personnes.add(getPersonne(resultat));
            }
            
        }catch(Exception ex) {
            Logger.getLogger(Jdbc2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personnes;   
    }

    @Override
    public Personne trouver(int id) {
        Personne p = null;
        try {
            Connection conn = Connexion.getInstance();
            String sql = " SELECT * FROM personne WHERE id = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultat = statement.executeQuery();
            
            
            while(resultat.next()) {
                p = this.getPersonne(resultat);
            }
            
        }
        catch(Exception ex) {
            Logger.getLogger(Jdbc2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    private Personne getPersonne(ResultSet resultat) throws SQLException {
        return new Personne(
                        resultat.getString("nom"),
                        resultat.getString("prenom"),
                        resultat.getInt("age"),
                        resultat.getInt("id"));
    }
    
}
