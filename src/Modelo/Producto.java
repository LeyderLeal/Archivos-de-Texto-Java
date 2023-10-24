
package Modelo;

/**
 *
 * @author SENA
 */
public class Producto {
    private int Codigo;
    private String Nombre;
    private double precio;

    public Producto(int Codigo, String Nombre, double precio) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.precio = precio;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
