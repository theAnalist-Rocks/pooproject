/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.jdbc2.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import tg.univlome.cic.apoo.jdbc2.dao.IPersonnePao;
import tg.univlome.cic.apoo.jdbc2.dao.PersonneDaoImp;
import tg.univlome.cic.apoo.jdbc2.entities.Personne;
import tg.univlome.cic.apoo.jdbc2.util.BeautifyDataTransform;

/**
 *
 * @author leBoulanger
 */
public class App extends JFrame {
    private static IPersonnePao personneDao = new PersonneDaoImp();
    
    public static void enregistrer(String nom, String prenom, int age) {
        Personne p = new Personne();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setAge(age);
        personneDao.enregistrer(p);
    }
    
    public static JScrollPane lister(String key) {
        BeautifyDataTransform transform = new BeautifyDataTransform();
        String columns[] = {"ID", "Nom", "Prenom", "Age" };
        String[][] data = transform.transform(personneDao.lister(key));
        
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table.setBackground(Color.white);
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        
        JScrollPane pane = new JScrollPane(table);
        return pane;
    }
    
    public static JScrollPane lister() {
        BeautifyDataTransform transform = new BeautifyDataTransform();
        String columns[] = {"ID", "Nom", "Prenom", "Age" };
        String[][] data = transform.transform(personneDao.lister());
        
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table.setBackground(Color.white);
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        
        JScrollPane pane = new JScrollPane(table);
        return pane;
    }
    
    public static void accueil() {
        App app = new App();
        BeautifyDataTransform transform = new BeautifyDataTransform();
        String columns[] = {"ID", "Nom", "Prenom", "Age" };
        String[][] data = transform.transform(personneDao.lister());
        app.setLayout(new BorderLayout());
        
        /* Center */
        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        
        /* Top */
        
        JMenuBar jMenuBar = new JMenuBar();
        JMenu acc = new JMenu("Accueil");
        JMenu formulaire = new JMenu("Formualire");
        JMenu lister = new JMenu("Lister");
        JMenu chercher = new JMenu("Chercher");
        JMenu supp = new JMenu("Supprimer");
        
        JMenuItem chercherKey = new JMenuItem("Chercher Clé");
        JMenuItem suppElmt = new JMenuItem("Avec une clé de recherche");
        JMenuItem listerTout = new JMenuItem("Lister Tout");
        JMenuItem dashBord = new JMenuItem("DashBoard");
        
        lister.add(listerTout);
        acc.add(dashBord);
        supp.add(suppElmt);
        chercher.add(chercherKey);
        
        jMenuBar.add(acc);
        jMenuBar.add(formulaire);
        jMenuBar.add(lister);
        jMenuBar.add(chercher);
        jMenuBar.add(supp);
        
        /* Form */
        JPanel form = new JPanel();
        form.setPreferredSize(new Dimension(450, 50));
        form.setLayout(new FlowLayout());
        
        /* Text Field gestion */
        JTextField jTextFiled1 = new JTextField("Nom");
        JTextField jTextFiled2 = new JTextField("Prénom");
        JTextField jTextFiled3 = new JTextField("Age");
        
        jTextFiled1.setPreferredSize(new Dimension(100, 20));
        jTextFiled2.setPreferredSize(new Dimension(100, 20));
        jTextFiled3.setPreferredSize(new Dimension(100, 20));
        JButton btn = new JButton("Ajouter");
        
        form.add(jTextFiled1);
        form.add(jTextFiled2);
        form.add(jTextFiled3);
        form.add(btn);
        
        /* Table */
        JPanel jTable = new JPanel();
        JScrollPane pane = lister();
        jTable.add(pane);
        
        /* Action listenners */
        listerTout.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               center.remove(form);
               //center.remove(jTable);
               
               jTable.remove(pane);
               jTable.add(lister());
               
               center.add(jTable);
               //center.repaint();
            }
        }));
        
        btn.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nom, prenom;
                
                 /* récupération des données */
                nom = jTextFiled1.getText();
                prenom = jTextFiled2.getText();
                int age = 0;
                try {
                   age = Integer.parseInt(jTextFiled3.getText());
                } catch (NumberFormatException ex) {

                }
                enregistrer(nom, prenom, age);
                jTable.remove(pane);
                jTable.add(lister());

                center.add(jTable);
            }
        }));
        
        chercherKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nom, prenom;
                
                 /* récupération des données */
                nom = jTextFiled1.getText();
                prenom = jTextFiled2.getText();
                int age = 0;
                try {
                   age = Integer.parseInt(jTextFiled3.getText());
                } catch (NumberFormatException ex) {

                }
                enregistrer(nom, prenom, age);
                jTable.remove(pane);
                jTable.add(lister(nom));
                center.add(jTable);
            }
        });
        
        /* Ajout au Frame */
        center.add(form, BorderLayout.NORTH);
        center.add(jTable, BorderLayout.CENTER);
        
        app.add(center, BorderLayout.CENTER);
        app.add(jMenuBar, BorderLayout.NORTH);
        app.setSize(470, 500);
        app.setResizable(false);
        app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        app.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        accueil();
    }
}
