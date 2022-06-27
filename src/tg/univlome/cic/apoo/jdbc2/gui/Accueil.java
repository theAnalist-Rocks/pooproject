/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.jdbc2.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author leBoulanger
 */
public class Accueil extends JFrame {
    
    public static void main(String[] args) {
        Accueil accueil = new Accueil();
        accueil.setSize(1600, 600);
        accueil.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel panel = (JPanel) accueil.getContentPane();
        panel.setLayout(new BorderLayout());
        
        JPanel nord = new JPanel();
        nord.setBackground(Color.BLUE);
        panel.add(nord, BorderLayout.NORTH);
        
        JPanel sud = new JPanel();
        sud.setBackground(Color.BLACK);
        panel.add(sud, BorderLayout.SOUTH);
    
        JPanel est = new JPanel();
        est.setBackground(Color.ORANGE);
        panel.add(est, BorderLayout.EAST);
        
        JPanel ouest = new JPanel();
        ouest.setBackground(Color.RED);
        panel.add(ouest, BorderLayout.WEST);
        
        JPanel centre = new JPanel();
        panel.add(centre);
        
        
        JButton btn = new JButton("Mon bouton");
        JTextField txt = new JTextField("Mon texte Swing");
        JLabel label = new JLabel("Mon Label");
        JTextArea txtArea = new JTextArea("Un long texte ici");
        JButton btn2 = new JButton("Un bouton pour finir");
        
        nord.add(btn);
        sud.add(txt);
        centre.add(label);
        est.add(txtArea);
        ouest.add(btn2);
        
        accueil.setVisible(true);
    }
}
