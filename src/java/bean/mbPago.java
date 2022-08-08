/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PedidoDao;
import dao.PedidoDaoImple;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.Pago;

/**
 *
 * @author pazan mera
 */
@Named(value = "mbPago")
@ViewScoped
public class mbPago implements Serializable{

    /**
     * Creates a new instance of mbPago
     */
    Pago obj_pago;
    public mbPago() {
        obj_pago = new  Pago();
    }

    public Pago getObj_pago() {
        return obj_pago;
    }

    public void setObj_pago(Pago obj_pago) {
        this.obj_pago = obj_pago;
    }
    
    
    public void agregarPago(){
        
        PedidoDao objPedido = new PedidoDaoImple();
        try{

              objPedido.agregarPago(obj_pago);        

       }
          
      catch(Exception e){
           FacesContext.getCurrentInstance().addMessage(null,
                   new FacesMessage(FacesMessage.SEVERITY_ERROR,"",e.getMessage()));
        }
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","PAGO AGREGADO CORRECTAMENTE"));        
        
    }
    

    
}
