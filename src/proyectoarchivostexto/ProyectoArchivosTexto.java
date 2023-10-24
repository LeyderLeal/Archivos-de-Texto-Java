package proyectoarchivostexto;

import vista.FrmRegistrarProducto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author SENA
 */

public class ProyectoArchivosTexto {

    static File archivo;
    static FileReader fr;
    static FileWriter fw;
    static BufferedReader br;
    static BufferedWriter bw;
    
    private static void crearArchivo(){
        archivo = new File("Productos.txt");
        try {
            fw = new FileWriter(archivo,true);
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    private static void agregarProductos(String producto){
        try{
            fw = new FileWriter(archivo,true);
            bw = new BufferedWriter(fw);
            bw.write(producto + "\n");
            bw.close();
            fw.close();
            System.out.println("Producto Agregado");
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private static void leerArchivo(){
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            while(br.ready()){
                String linea = br.readLine();
                System.out.println(linea);
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        crearArchivo();
        leerArchivo();
        FrmRegistrarProducto frm = new FrmRegistrarProducto(null, true);
        frm.setVisible(true);
    }
    
}
