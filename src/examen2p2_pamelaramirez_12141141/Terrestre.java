
package examen2p2_pamelaramirez_12141141;


public class Terrestre extends Planeta {

    public Terrestre(int tam, int peso, String nom, int x, int y) {
        super(tam, peso, nom, x, y);
    }

    @Override
    public boolean seCrea() {
        if (0 + r.nextInt(100) <= 25) {
            return true;
        }
        else {
            return false;
        }
    }
    
}
