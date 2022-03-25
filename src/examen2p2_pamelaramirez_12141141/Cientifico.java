
package examen2p2_pamelaramirez_12141141;

import java.util.ArrayList;


public class Cientifico {
    private String nom;
    private ArrayList <Planeta> planetas = new ArrayList();

    public Cientifico(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Planeta> getPlanetas() {
        return planetas;
    }

    public void setPlanetas(ArrayList<Planeta> planetas) {
        this.planetas = planetas;
    }

    @Override
    public String toString() {
        return nom;
    }
    
}
