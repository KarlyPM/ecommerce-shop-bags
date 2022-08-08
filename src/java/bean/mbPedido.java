/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PedidoDao;
import dao.PedidoDaoImple;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import modelo.Carrito;
import modelo.Pedido;

/**
 *
 * @author User
 */
@Named(value = "mbPedido")
@ViewScoped
public class mbPedido implements Serializable{

    Pedido obj_pedido;
    
    @Inject
    mbCarrito car;  

    @Inject
    mbSession mbUser;
    
    public mbPedido() {
        obj_pedido = new Pedido(); 
        mbUser = new mbSession();
        car = new  mbCarrito();
    }
    
    public List<Pedido> getLstPedido(){
        PedidoDao obj_pedideoDao= new PedidoDaoImple();
        return obj_pedideoDao.consultarDetalle();
    }

    public Pedido getObj_pedido() {
        return obj_pedido;
    }

    public void setObj_pedido(Pedido obj_pedido) {
        this.obj_pedido = obj_pedido;
    }

    
    public void agregarPedido(){ 
        PedidoDao objPedido = new PedidoDaoImple();
        try{
          
          for(Carrito carrito : car.getLstAddCarrrito()){ //Iterando todos los productos
              
              obj_pedido.setTotal(car.getTotal());
              
              System.out.println("TOTALLL "+car.getTotal());
              System.out.println("MI ID " + mbUser.getObj_Usuario().getIdUsuario());
             // System.out.println("MIS PRODUCTOSSSSSS" + car.getObj_product().getIdProducto()); traer ID producto, not use
          }
              objPedido.agregarDetalle(obj_pedido, mbUser.getObj_Usuario().getIdUsuario());
            

       }
          
      catch(Exception e){
           FacesContext.getCurrentInstance().addMessage(null,
                   new FacesMessage(FacesMessage.SEVERITY_ERROR,"Msg",e.getMessage()));
        }
        //obj_Direccion= new Direccion();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","PEDIDO GENERADO CORRECTAMENTE"));
    
    }
    


    
}   
