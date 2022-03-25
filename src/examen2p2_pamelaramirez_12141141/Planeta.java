
package examen2p2_pamelaramirez_12141141;

import java.util.Random;


public abstract class Planeta {
    protected String nom;
    protected int tam, peso, x, y;
    protected Random r = new Random();
    
    public abstract boolean seCrea();

    public Planeta(int tam, int peso, String nom, int x, int y) {
        this.tam = tam;
        this.peso = peso;
        this.x = x;
        this.y = y;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return nom;
    }
    
}
