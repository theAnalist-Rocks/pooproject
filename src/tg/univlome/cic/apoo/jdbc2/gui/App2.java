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
import static tg.univlome.cic.apoo.jdbc2.gui.App.enregistrer;
import tg.univlome.cic.apoo.jdbc2.util.BeautifyDataTransform;

/**
 *
 * @author leBoulanger
 */
public class App2 extends JFrame {
    static JPanel principal = new JPanel();
    static String columns[] = {"ID Today", "Nom", "Prenom", "Age" };
    static IPersonnePao personneDao = new PersonneDaoImp();
    static DefaultTableModel model = new DefaultTableModel(columns, 0);
    static BeautifyDataTransform transform = new BeautifyDataTransform();
    static int compteurInsertion = 0;
    
    
    public static JPanel formDelete() {
        JPanel form = new JPanel();
        
        /* Text Field gestion */
        JTextField jTextFiled1 = new JTextField("Nom Ou Prénom");
        jTextFiled1.setPreferredSize(new Dimension(200, 20));
        JButton btn = new JButton("Supprimer");
        
        form.add(jTextFiled1);
        form.add(btn);
        form.setLayout(new FlowLayout());
        return form;
    }
    
    public static JPanel formSearch() {
        JPanel form = new JPanel();
        
        /* Text Field gestion */
        JTextField jTextFiled1 = new JTextField("Nom Ou Prénom");
        jTextFiled1.setPreferredSize(new Dimension(200, 20));
        JButton btn = new JButton("Chercher");
        
        form.add(jTextFiled1);
        form.add(btn);
        form.setLayout(new FlowLayout());
        return form;
    }
    
    
    public static JPanel formAddPerson() {
        JPanel form = new JPanel();
        
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
        form.setLayout(new FlowLayout());
        return form;
    }
    
    public static JPanel lister() {
        JPanel tableau = new JPanel();
        BeautifyDataTransform transform = new BeautifyDataTransform();
        
        String[][] data = transform.transform(personneDao.lister());
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table.setBackground(Color.white);
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        table.setEnabled(false);
        
        JScrollPane pane = new JScrollPane(table);
        tableau.add(pane);
        return tableau;
    }
    
    public static JPanel lister(String key) {
        JPanel tableau = new JPanel();
        BeautifyDataTransform transform = new BeautifyDataTransform();
        
        String[][] data = transform.transform(personneDao.lister(key));
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table.setBackground(Color.white);
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        table.setEnabled(false);
        
        JScrollPane pane = new JScrollPane(table);
        tableau.add(pane);
        return tableau;
    }
    
    public static void main(String[] args) {
        App2 app = new App2();
        app.setLayout(new BorderLayout());
        
        /* menu */
       JMenuBar jMenuBar = new JMenuBar();
        JMenu acc = new JMenu("DashBoard");
        JMenu formulaire = new JMenu("Formualire");
        JMenu lister = new JMenu("Lister");
        JMenu chercher = new JMenu("Chercher");
        JMenu supp = new JMenu("Supprimer");
        
        JMenuItem chercherKey = new JMenuItem("Chercher Clé");
        JMenuItem suppElmt = new JMenuItem("Avec une clé de recherche");
        JMenuItem listerTout = new JMenuItem("Lister Tout");
        JMenuItem dashBord = new JMenuItem("Main");
        
        lister.add(listerTout);
        acc.add(dashBord);
        supp.add(suppElmt);
        chercher.add(chercherKey);
        
        jMenuBar.add(acc);
        jMenuBar.add(formulaire);
        jMenuBar.add(lister);
        jMenuBar.add(chercher);
        jMenuBar.add(supp);
        
        /* Formulaire */
        JPanel form = new JPanel();
        
        /* Text Field gestion */
        JTextField jTextFiled1 = new JTextField("Nom");
        JTextField jTextFiled2 = new JTextField("Prénom");
        JTextField jTextFiled3 = new JTextField("Age");
        
        jTextFiled1.setPreferredSize(new Dimension(100, 20));
        jTextFiled2.setPreferredSize(new Dimension(100, 20));
        jTextFiled3.setPreferredSize(new Dimension(100, 20));
        JButton btn = new JButton("Ajouter");
        
        /* ActionListener */
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
                Personne p = new Personne();
                p.setNom(nom);
                p.setPrenom(prenom);
                p.setAge(age);
                p.setId(compteurInsertion);
                model.addRow(transform.transformStringPersonne(p));
                compteurInsertion ++;
            }
        }));
          
        /* Table */
        JTable table = new JTable(model);
        table.setBackground(Color.white);
        table.setShowGrid(true);
        table.setShowVerticalLines(true);
        JScrollPane scroll = new JScrollPane(table);
        
        form.add(jTextFiled1);
        form.add(jTextFiled2);
        form.add(jTextFiled3);
        form.add(btn);
        form.setLayout(new FlowLayout());
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout());
        pane.add(form, BorderLayout.NORTH);
        pane.add(scroll, BorderLayout.CENTER);
        
        app.add(jMenuBar, BorderLayout.NORTH);
        app.add(pane, BorderLayout.CENTER);
        app.setSize(460, 500);
        app.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        app.setVisible(true);
    }
}
