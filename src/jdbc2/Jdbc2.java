/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import tg.univlome.cic.apoo.jdbc2.util.Connexion;

/**
 *
 * @author leBoulanger
 */
public class Jdbc2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Connection connexion = Connexion.getInstance();
            String sql = "UPDATE user SET nom = ? WHERE id = ?";
            PreparedStatement statement = connexion.prepareStatement(sql);
            statement.setString(1, "ADENYO");
            statement.setInt(2, 2);
            statement.executeUpdate();
        } catch(Exception ex) {
            Logger.getLogger(Jdbc2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main1(String[] args) {
        // TODO code application logic here
                try {
            // TODO code application logic here
            FileInputStream fichier = new FileInputStream("conf.properties");
            Properties proprietes = new Properties();
            try {
                proprietes.load(fichier);
                try {
                    Class.forName(proprietes.getProperty("jdbc.driver.class"));
                    try {
                        Connection connection = DriverManager.getConnection(
                                proprietes.getProperty("jdbc.url"),
                                proprietes.getProperty("jdbc.login"),
                                proprietes.getProperty("jdbc.password")
                        );
                        String sql = "INSERT INTO user(nom, prenom, age) VALUES(?, ?, ?)";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, "ADENYO");
                        statement.setString(2, "Franck");
                        statement.setInt(3, 25);
                        statement.executeUpdate();
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Jdbc2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Jdbc2.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(proprietes.getProperty("jdbc.driver.class"));
            } catch (IOException ex) {
                Logger.getLogger(Jdbc2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Jdbc2.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
}
