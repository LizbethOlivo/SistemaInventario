/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConsultasPro;
import modelo.Producto;
import vista.frmProducto;

/**
 *
 * @author user name
 */
public class CtrProducto implements ActionListener {
    private Producto mod;
    private ConsultasPro modC;
    private frmProducto frm;
    
    
    public CtrProducto(Producto mod,ConsultasPro modC,frmProducto frm )
    {
        this.mod =mod;
        this.modC= modC;
        this.frm=frm;
        this.frm.btnGuardar.addActionListener(this);
     this.frm.btnModificar.addActionListener(this);
      this.frm.btnEliminar.addActionListener(this);
       this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
     
     
    }    
    
    public void iniciar(){
      frm.setTitle("Productos");
      frm.setLocationRelativeTo(null);  
      frm.txtId.setVisible(false);
    
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
    
    
    if(e.getSource()== frm.btnGuardar)
    {
        mod.setCodigo(frm.txtCodigo.getText());
        mod.setNombre(frm.txtNombre.getText());
        mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
        mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
        
        try {
            if(modC.registar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CtrProducto.class.getName()).log(Level.SEVERE, null, ex);
            limpiar();        }
    }
    
    if(e.getSource()== frm.btnModificar)
    {
        mod.setId(Integer.parseInt(frm.txtId.getText()));
        mod.setCodigo(frm.txtCodigo.getText());
        mod.setNombre(frm.txtNombre.getText());
        mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
        mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
        
        try {
            if(modC.modificar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CtrProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
     if(e.getSource()== frm.btnEliminar)
    {
        mod.setId(Integer.parseInt(frm.txtId.getText()));
        
        try {
            if(modC.eliminar(mod))
            {
                JOptionPane.showMessageDialog(null, "Eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CtrProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
      if(e.getSource()== frm.btnBuscar)
    {
        mod.setCodigo(frm.txtBuscar.getText());
        
       
        try {
            if(modC.buscar(mod))
            {
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));
                
                
              
            }else{
                JOptionPane.showMessageDialog(null, "No encontro el producto");
                limpiar();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CtrProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
      
      if (e.getSource()==frm.btnLimpiar){
          limpiar();
      }
    
     
    }
    
    public void limpiar()
    {
        
        frm.txtId.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtCantidad.setText(null);
        frm.txtBuscar.setText(null);
        
    }
}
