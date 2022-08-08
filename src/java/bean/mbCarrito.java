/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Carrito;
import modelo.Pedido;
import modelo.Producto;

/**
 *
 * @author pazan mera
 */
@Named(value = "mbCarrito")
@SessionScoped
public class mbCarrito implements Serializable {

    /**
     * Creates a new instance of mbCarrito
     */
    List<Carrito> lstAddCarrrito;
    Producto obj_product;
    Carrito obj_carrito;
    Pedido obj_pedido;
    double total= 0;
   
    public mbCarrito() {
        lstAddCarrrito =new ArrayList<>();
        obj_product = new Producto();
        obj_carrito = new Carrito();
        obj_pedido = new Pedido();

    }

    public Pedido getObj_pedido() {
        return obj_pedido;
    }

    public void setObj_pedido(Pedido obj_pedido) {
        this.obj_pedido = obj_pedido;
    }
    
    

    public List<Carrito> getLstAddCarrrito() {
        return lstAddCarrrito;
    }

    public void setLstAddCarrrito(List<Carrito> lstAddCarrrito) {
        this.lstAddCarrrito = lstAddCarrrito;
    }

    public Producto getObj_product() {
        return obj_product;
    }

    public void setObj_product(Producto obj_product) {
        this.obj_product = obj_product;
    }
    
    
    
    public void actionAgregarProducto(Producto producto){ //PANEL CARRITO
        try{
            lstAddCarrrito= AProducto(lstAddCarrrito , producto);
            
            for (Carrito carrito : lstAddCarrrito) {
                //System.out.println("Producto"+carrito.getProducto());
                
            }
            System.out.println(lstAddCarrrito.size());
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR",e.getMessage()));        
        }
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","PORDUCTO AGREGADO A CARRITO CORRECTAMENTE"));
            
        

    } 
    
    
    public List<Carrito>AProducto(List<Carrito> productos,Producto producto){
        int index = this.existe(producto);
        double subtotal = 0;

        if (index == -1) { 
		this.lstAddCarrrito.add(new Carrito(producto, 1, producto.getPrecioUnitario()));
	} else { 
               
		int cantidad = this.lstAddCarrrito.get(index).getCantidad()+ 1;
		this.lstAddCarrrito.get(index).setCantidad(cantidad);  
                subtotal += this.lstAddCarrrito.get(index).getProducto().getPrecioUnitario() * cantidad; 
                this.lstAddCarrrito.get(index).setSubtotal(subtotal);
                
	}
        return productos;
    }
    
    private int existe(Producto product) {
		for (int i = 0; i < this.lstAddCarrrito.size(); i++) {
			if (this.lstAddCarrrito.get(i).getProducto().getIdProducto()== product.getIdProducto()) {
                            return i;
			}
		}
		return -1;
    }

    public String delete(Producto product) {
	int index = this.existe(product);
	this.lstAddCarrrito.remove(index);
	
        return "carrito?faces-redirect=true";
    }
    
    public double subtotalCarrito() {
            double resp = 0;
            for(Carrito carrito : this.lstAddCarrrito) {
                resp += carrito.getProducto().getPrecioUnitario() * carrito.getCantidad();

          }
            return resp;
    }
    
    public double obtenerIva(double base, double porcentaje) {
        return  base * porcentaje / 100;
                        

    }

    public double getTotal() {
        return total;
    }
    
    

    public void total() {
            double iva = 0;
            double subtotal =0;
            
            for(Carrito carrito : this.lstAddCarrrito) {
                subtotal += carrito.getProducto().getPrecioUnitario() * carrito.getCantidad();
                obj_pedido.setSubtotal(subtotal);
                
                
                iva = obtenerIva(subtotal, 12);
                obj_pedido.setIva(iva);
                
                total = iva + subtotal;
                obj_pedido.setTotal(total);
                //obj_detalle.getProducto().setIdProducto(carrito.getProducto().getIdProducto());               
                System.out.println(total);
               // System.out.println("PRODUCTOoooS: "+ carrito.getProducto().getNombre());              

            }
          

           
    }    



    
}
