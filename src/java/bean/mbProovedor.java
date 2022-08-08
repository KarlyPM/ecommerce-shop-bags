/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ProveedoresDao;
import dao.ProveedoresDaoImple;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.Proveedor;

/**
 *
 * @author User
 */
@Named(value = "mbProovedor")
@ViewScoped
public class mbProovedor implements Serializable{

    Proveedor obj_Proveedor;
    public mbProovedor() {
        obj_Proveedor= new Proveedor();
        
    }
    
    public Proveedor getObj_Proveedor() {
        return obj_Proveedor;
    }

    public void setObj_Proveedor(Proveedor obj_Proveedor) {
        this.obj_Proveedor = obj_Proveedor;
    }
    
    public List<Proveedor> getLstProveedor(){
        ProveedoresDao objProveedoresDao = new ProveedoresDaoImple();
        return objProveedoresDao.ConsultarProveedor();
    }
    
    
    public void agregarProveedor(){
        ProveedoresDao objProveedoresDao = new ProveedoresDaoImple();
         try{
            objProveedoresDao.agregarProveedor(obj_Proveedor);
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"",e.getMessage()));
        }
        obj_Proveedor= new Proveedor();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","LOS DATOS INGRESADOS CORRECTAMENTE"));
    }
    public void modificarProveedor(){
         ProveedoresDao objProveedoresDao = new ProveedoresDaoImple();
         try{
            objProveedoresDao.modificarProveedor(obj_Proveedor);
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"",e.getMessage()));
        }
        obj_Proveedor= new Proveedor();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","DATOS MODIFICADOS CORRECTAMENTE"));
        
    }
    public void eliminarProveedor(){
          ProveedoresDao objProveedoresDao = new ProveedoresDaoImple();
         try{
            objProveedoresDao.eliminarProveedor(obj_Proveedor);
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"",e.getMessage()));
        }
        obj_Proveedor= new Proveedor();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","DATOS ELIMINADOS CORRECTAMENTE"));
    }

}
