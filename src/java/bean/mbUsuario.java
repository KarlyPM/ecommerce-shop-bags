/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.UsuarioDao;
import dao.UsuarioDaoImple;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Usuario;

/**
 *
 * @author User
 */
@Named(value = "mbUsuario")
@ViewScoped
public class mbUsuario implements Serializable{

    Usuario obj_Usuario;

    public mbUsuario() {
        obj_Usuario= new Usuario();

    }

    public Usuario getObj_Usuario() {
        return obj_Usuario;
    }

    public void setObj_Usuario(Usuario obj_Usuario) {
        this.obj_Usuario = obj_Usuario;
    }
    
    public List<Usuario> getLstUsuario(){
        UsuarioDao obj_UsuarioDao= new UsuarioDaoImple();
        return obj_UsuarioDao.ConsultarUsuario();
    }
    
    
    
    public void agregarUsuario(){
        UsuarioDao obj_UsuarioDao= new UsuarioDaoImple();
         try{
            obj_UsuarioDao.agregarUsuario(obj_Usuario);
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"",e.getMessage()));
        }
        obj_Usuario= new Usuario();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","DATOS INGRESADOS CORRECTAMENTE"));
    }
    public void modificarUsuario(){
        UsuarioDao obj_UsuarioDao= new UsuarioDaoImple();
         try{
            obj_UsuarioDao.modificarUsuario(obj_Usuario);
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"",e.getMessage()));
        }
        obj_Usuario= new Usuario();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","DATOS MODIFICADOS CORRECTAMENTE"));
        
    }
    public void eliminarUsuario(){
        UsuarioDao obj_UsuarioDao= new UsuarioDaoImple();
         try{
            obj_UsuarioDao.eliminarUsuario(obj_Usuario);
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"",e.getMessage()));
        }
        obj_Usuario= new Usuario();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","DATOS ELIMINADOS CORRECTAMENTE"));
    }
    
    
    public String agregarRegistro(){
        
        String ruta="";
        UsuarioDao obj_UsuarioDao= new UsuarioDaoImple();
         try{
            obj_UsuarioDao.agregarRegistro(obj_Usuario);
            ruta="login?faces-redirect=true";
        }
        catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERROR",e.getMessage()));
        }
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Msg","REGISTRADO CORRECTAMENTE. PROCEDA A INICIAR SESION"));
        return ruta;
    }

    
    
}
