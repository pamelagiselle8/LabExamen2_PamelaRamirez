
package examen2p2_pamelaramirez_12141141;

import java.io.Serializable;


public class Gaseoso extends Planeta implements Serializable {

    public Gaseoso(int tam, int peso, String nom, int x, int y) {
        super(tam, peso, nom, x, y);
    }

    @Override
    public boolean seCrea() {
        if (0 + r.nextInt(100) <= 20) {
            return true;
        }
        else {
            return false;
        }
    }
    
}
