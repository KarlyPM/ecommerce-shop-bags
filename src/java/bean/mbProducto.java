/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ProductoDao;
import dao.ProductoDaoImple;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.Producto;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author pazan mera
 */
@Named(value = "mbProducto")
@ViewScoped
public class mbProducto  implements Serializable{

    /**
     * Creates a new instance of mbProducto
     */
    Producto obj_producto;
    private UploadedFile archivo;
    ProductoDao productoDao = new ProductoDaoImple(); 
    
    List<Producto> lstProductosFiltrados;

    
    
    public mbProducto() {
        obj_producto = new  Producto();

    }

    public Producto getObj_producto() {
        return obj_producto;
    }

    public void setObj_producto(Producto obj_producto) {
        this.obj_producto = obj_producto;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    public List<Producto> getListProduImg() {
        ProductoDao daoproducto = new ProductoDaoImple(); 


        return daoproducto.ConsultarProducto();
    }

    public List<Producto> getLstProductosFiltrados() {
        return lstProductosFiltrados;
    }

    public void setLstProductosFiltrados(List<Producto> lstProductosFiltrados) {
        this.lstProductosFiltrados = lstProductosFiltrados;
    }
    
      
    public void agregarProducto(){
        String ruta ="..\\web\\resources\\imagen"; //Agregar tu ruta completa

        try{
            if(archivo.getSize() > 0){


                obj_producto.setImagennombre(archivo.getFileName());
                obj_producto.setImagen(archivo.getContent());

                productoDao.agregarProducto(obj_producto);

                convertirBytes(IOUtils.toByteArray(archivo.getInputStream()), ruta, archivo.getFileName());
                
                FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Msg", "Los datos ingresaron corrrectamente")); 
                
            }
            
        }
        catch(IOException e){
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
            
        }
        
     }
    
    public void convertirBytes(byte[] bytes, String carpeta, String nmbreImagen){
       try{
           Path path = Paths.get(carpeta, nmbreImagen);
           Files.write(path, bytes);
       }
       catch(IOException ex){
           System.out.println("error en los bytes");
       }
    } 
    
    public void modificarProducto(){
        
        try{
            productoDao.modificarProducto(obj_producto);
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"",e.getMessage()));
        }
        obj_producto= new Producto();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","DATOS MODIFICADOS CORRECTAMENTE"));
        
    }
    
    public void eliminarProducto(){ //PANEL ADMINISTRACION
         try{
            productoDao.eliminarProducto(obj_producto);
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"",e.getMessage()));
        }
        obj_producto= new Producto();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","DATOS ELIMINADOS CORRECTAMENTE"));
    }
     
    
    
    
}
