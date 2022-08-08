/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.CategoriaDaoImple;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.Categoria;
import dao.CategoriaDao;

/**
 *
 * @author User
 */
@Named(value = "mbCategoria")
@ViewScoped
public class mbCategoria  implements Serializable{

    
    Categoria obj_Categoria;
    
    
    public mbCategoria() {
        obj_Categoria= new Categoria();
    }

    public Categoria getObj_Categoria() {
        return obj_Categoria;
    }

    public void setObj_Categoria(Categoria obj_Categoria) {
        this.obj_Categoria = obj_Categoria;
    }
    
    public List<Categoria> getLstCategoria(){
        CategoriaDao obj_CategoriaDao = new CategoriaDaoImple();
        return obj_CategoriaDao.ConsultarCategoria();
    }
    
    
    
    public void agregarCategoria(){
        CategoriaDao obj_CategoriaDao = new CategoriaDaoImple();
         try{
            obj_CategoriaDao.agregarCategoria(obj_Categoria);
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"",e.getMessage()));
        }
        obj_Categoria= new Categoria();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","LOS DATOS INGRESADOS CORRECTAMENTE"));
    }
    public void modificarCategoria(){
        CategoriaDao obj_CategoriaDao = new CategoriaDaoImple();
         try{
            obj_CategoriaDao.modificarCategoria(obj_Categoria);
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"",e.getMessage()));
        }
        obj_Categoria= new Categoria();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","DATOS MODIFICADOS CORRECTAMENTE"));
        
    }
    public void eliminarCategoria(){
        CategoriaDao obj_CategoriaDao = new CategoriaDaoImple();
         try{
            obj_CategoriaDao.eliminarCategoria(obj_Categoria);
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"",e.getMessage()));
        }
        obj_Categoria= new Categoria();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","DATOS ELIMINADOS CORRECTAMENTE"));
    }
    
    public List<String> getLstCategoriaDescripc(){
        CategoriaDao obj_CategoriaDao = new CategoriaDaoImple();

        return obj_CategoriaDao.consultarCategoriaDescrip();
    }
        
    
    
}
