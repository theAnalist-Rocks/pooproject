/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.jdbc2.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.sql.*;

/**
 *
 * @author leBoulanger
 */
public class Connexion {
    //pattern singleton: il n'y a qu'une seule instance
    final private static Connexion instance;
    
    static {
       instance = new Connexion();
    }
    private Connexion() {
        
    }
    
    //public static Connexion getInstance() {
    //    return instance;
    //}
    public static Connection getInstance() throws Exception {
        return instance.getConnexion();
    }
    
    
    public Connection getConnexion() throws Exception {
        Properties proprietes = new Properties();
        try(FileInputStream fichier = new FileInputStream("conf.properties")) {
            proprietes.load(fichier);
        }
        return DriverManager.getConnection(
                proprietes.getProperty("jdbc.url"),
                proprietes.getProperty("jdbc.login"), 
                proprietes.getProperty("jdbc.password"));
    }
}
