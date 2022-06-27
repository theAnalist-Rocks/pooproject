/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.jdbc2.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import tg.univlome.cic.apoo.jdbc2.dao.IPersonnePao;
import tg.univlome.cic.apoo.jdbc2.dao.PersonneDaoImp;

/**
 *
 * @author leBoulanger
 */
public class Formulaire extends JFrame {
    static Formulaire main = new Formulaire();
    
    public static void main(String[] args) {
        JPanel panel = (JPanel) main.getContentPane();
        IPersonnePao personneDao = new PersonneDaoImp();
        String[][] data = {
            { "Kundan Kumar Jha", "4031", "CSE" },
            { "Anand Jha", "6014", "IT" }
        };
        // Column Names
        String[] columnNames = { "Nom", "Roll Number", "Department" };
        JTable table = new JTable(data, columnNames);
        table.setEnabled(false);
        table.setBounds(0, 0, 700, 300);
        panel.add(table);
        
        main.setSize(800, 500);
        main.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        main.setVisible(true);
        
    }
    
}
