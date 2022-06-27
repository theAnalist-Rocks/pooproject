/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.apoo.jdbc2.entities;

/**
 *
 * @author leBoulanger
 */
public class Personne {
    private int id;
    private int age;
    private String nom;
    private String prenom;
    
    public Personne() {
        
    }
    
    public Personne(String wNom, String wPrenom, int wAge) {
        nom = wNom;
        prenom = wPrenom;
        age = wAge;
    }
    
    public Personne(String nom, String prenom, int age, int id) {
        this(nom, prenom, age);
        this.id = id;        
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    public String getNom() {
        return this.nom;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", age=" + age + ", nom=" + nom + ", prenom=" + prenom + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
