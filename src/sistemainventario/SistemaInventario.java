/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemainventario;

import controlador.CtrProducto;
import modelo.ConsultasPro;
import modelo.Producto;
import vista.frmProducto;

/**
 *
 * @author user name
 */
public class SistemaInventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Producto mod = new Producto();
        ConsultasPro modC = new ConsultasPro();
        frmProducto frm = new frmProducto();
        
        CtrProducto ctrl = new CtrProducto(mod,modC,frm);    
        ctrl.iniciar();
        frm.setVisible(true);
    }
    
}
