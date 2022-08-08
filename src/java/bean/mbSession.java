/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.UsuarioDao;
import dao.UsuarioDaoImple;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Usuario;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

/**
 *
 * @author pazan mera
 */
@Named(value = "mbSession")
@SessionScoped
public class mbSession implements Serializable{

        Usuario obj_Usuario;
        UsuarioDao obj_usuarioDao = new UsuarioDaoImple();
    /**
     * Creates a new instance of mbSession
     */
    public mbSession() {
        obj_Usuario = new Usuario();
   
  
    }
    

    public Usuario getObj_Usuario() {
        return obj_Usuario;
    }

    public void setObj_Usuario(Usuario obj_Usuario) {
        this.obj_Usuario = obj_Usuario;
    }


    
    public String verificarDatos(){
        UsuarioDao usuarioDao= new UsuarioDaoImple();
        //Usuario obj_Usuario;
        String resultado ="";
        try{
            obj_Usuario=usuarioDao.IniciarSesion(this.obj_Usuario);
            System.out.println("us: " + obj_Usuario);
            if( obj_Usuario !=null && obj_Usuario.getTipoUsuario().equals("Cliente")){
                
                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().put("Usuario", obj_Usuario);
                
                resultado="indexTemplate";
                
                System.out.println(obj_Usuario.getNombre());
            }else if (obj_Usuario !=null && obj_Usuario.getTipoUsuario().equals("Administrador")){
                
                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().put("Usuario", obj_Usuario);
                
                resultado="adminUsuarios";
            }else{
                FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,"Msg","Credenciales incorrectas. Error de sesión"));
                //resultado="/faces/Login/error";
            }
   
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Credenciales incorrectas. Error de sesión"));
        }
        return resultado;
    }
    
    public boolean verificarSession() throws IOException{
        
        boolean estado;
        if(FacesContext.getCurrentInstance().getExternalContext().
                getSessionMap().get("Usuario")==null){
            estado=false;
            System.out.println(estado);
                 
                 
            FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
                           
        }
        else{
            estado = true;
            obj_usuarioDao.getDatosUsuarios(obj_Usuario.getIdUsuario());
            
            System.out.println(obj_Usuario.getIdUsuario());              
            System.out.println(estado);
        }
       return estado;
    } 
}
