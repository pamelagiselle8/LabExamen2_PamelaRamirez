
package examen2p2_pamelaramirez_12141141;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Binarios {
    private ArrayList <Cientifico> cientificos = new ArrayList();
    private File archivo = null;
    
    public Binarios(String path) {
        archivo = new File(path);
    }

    public ArrayList<Cientifico> getCientificos() {
        return cientificos;
    }

    public void setCientificos(ArrayList<Cientifico> cientificos) {
        this.cientificos = cientificos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    // Metodos de administracion
    public void addCientifico(Cientifico cientifico) {
        this.cientificos.add(cientifico);
        escribirArchivo();
    }
    
    public void addPlaneta(Cientifico cientifico, Planeta planeta) {
        if (!cientificos.isEmpty()) {
            for (Cientifico cient : cientificos) {
                if (cient.toString().equals(cientifico.toString())) {
                    cient.getPlanetas().add(planeta);
                }
            }
        }
        escribirArchivo();
    }
    
    public void cargarArchivo() {
        try {            
            cientificos = new ArrayList();
            Cientifico cientifico;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((cientifico = (Cientifico) objeto.readObject()) != null) {
                        cientificos.add(cientifico);
                    }
                } catch (EOFException e) {
                    
                }
                objeto.close();
                entrada.close();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Cientifico cientifico: cientificos) {
                bw.writeObject(cientifico);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
}
