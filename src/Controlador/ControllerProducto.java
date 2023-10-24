package Controlador;

import Modelo.DatosProducto;
import Modelo.Producto;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import vista.FrmConsultarProducto;
import vista.FrmListarProductos;
import vista.FrmRegistrarProducto;

/**
 *
 * @author SENA
 */
public class ControllerProducto {
    private DatosProducto dProducto = new DatosProducto();
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }
    
    /**
     * Recibe de la vista los datos para agregar un producto
     * @param frm: formulario con los datos del producto
     * @return true or false
     */
    
    public boolean registrar(FrmRegistrarProducto frm){
        int codigo = Integer.parseInt(frm.txtCodigo.getText());
        String nombre = frm.txtNombre.getText();
        double precio = Double.parseDouble(frm.txtPrecio.getText());
        Producto p = new Producto(codigo, nombre, precio);
        boolean existe = dProducto.existeProductoCodigo(codigo);
        if(!existe){
            boolean agregado = dProducto.agregar(p);
            mensaje = dProducto.getMensaje();
            return agregado;
        }else{
            mensaje="Ya existe un producto con ese codigo, verificar";
            return false;
        }
    }
    
    /**
     * Recibe de la vista la solicitud para listar los productos
     * @param frm: Formulario donde se van a listar
     */
    
    public void listar(FrmListarProductos frm){
        DefaultTableModel modelo = (DefaultTableModel)frm.tblProductos.getModel();
        String[] datos = new String[3];
        ArrayList<Producto> lista = dProducto.listar();
        modelo.setRowCount(0);
        for (Producto producto : lista){
            datos[0]= String.valueOf(producto.getCodigo());
            datos[1]= producto.getNombre();
            datos[2]= String.valueOf(producto.getPrecio());
            modelo.addRow(datos);
        }
    }
    
    /**
     * Recibe petición de la vista para consultar
     * un producto por el código
     * @param frm
     * @return 
     */
    public boolean consultarProducto(FrmConsultarProducto frm){
        int codigo = Integer.parseInt(frm.txtCodigo.getText());
        Producto p = dProducto.consultarPorCodigo(codigo);
        
        frm.txtNombre.setText("");
        frm.txtPrecio.setText("");
        if(p!=null){
            
            frm.txtNombre.setText(p.getNombre());
            frm.txtPrecio.setText(String.valueOf(p.getPrecio()));
            return true;
        }else{
            mensaje="No existe producto con ese código";
            return false;            
        }
    }
    
}
