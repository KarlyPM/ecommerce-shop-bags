/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.List;
import modelo.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

/**
 *
 * @author User
 */
public class UsuarioDaoImple implements UsuarioDao{

    @Override
    public List<Usuario> ConsultarUsuario() {
        Session session = null;
        List<Usuario> lstUsuario = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("From Usuario order by idUsuario"); 
            lstUsuario = query.list();    
        }
        catch(HibernateException e){
            System.out.println(e);
            
            
        }
        finally{
            if(session != null){
                session.close(); 
            }
        }
        return lstUsuario;
        
    }

    @Override
    public void agregarUsuario(Usuario obj_usuario) {
       Session session= null;
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(obj_usuario);
            session.getTransaction().commit();
        
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }  
        
        finally{
            if(session !=null){
                session.close();
            }
        }  
    }

    @Override
    public void modificarUsuario(Usuario obj_usuario) {
         Session session= null;
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(obj_usuario);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }  
        finally{
            if(session !=null){
                session.close();
            }
        } 
    }

    @Override
    public void eliminarUsuario(Usuario obj_usuario) {
        Session session= null;
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(obj_usuario);
            session.getTransaction().commit();
        }
        catch(HibernateException e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }  
        finally{
            if(session !=null){
                session.close();
            }
        } 
    }

    

    @Override
    public Usuario IniciarSesion(Usuario u) throws Exception{
        Session session = null;
        Usuario us=new Usuario();
       
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Usuario WHERE correoElectronico = '" + u.getCorreoElectronico()+ "' and contrasena ='" + u.getContrasena()+"' and tipoUsuario = '" + u.getTipoUsuario() + "'";
            Query query = session.createQuery(hql); 
               
            if(!query.list().isEmpty()){
                us = (Usuario) query.list().get(0);
                
            }
        }
        catch(HibernateException e){
            throw e;
            
            
        }
        
        return us;
    }

    @Override
    public void agregarRegistro(Usuario usuario) {
        
        Session session = null;
        List<Usuario> lstUsuario = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("insert into Usuario (nombre, apellido, correo_electronico, contrasena, tipo_usuario) values (?, ?, ?, ?, ?)"); 
            query.setParameter(0,usuario.getNombre());
            query.setParameter(1,usuario.getApellido());
            query.setParameter(2,usuario.getCorreoElectronico());
            query.setParameter(3,usuario.getContrasena());
            query.setParameter(4,usuario.getTipoUsuario());
            query.executeUpdate();
            
            session.getTransaction().commit();
               
        }
        catch(HibernateException e){
            System.out.println(e);
            
            
        }
       
        }

    @Override
    public Usuario getDatosUsuarios(Integer id) { 
        Usuario usuario = new Usuario();
        Session session = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("select u From Usuario u where u.idUsuario = :idUsuario order by idUsuario"); 
            query.setParameter("idUsuario", id);
            
            query.uniqueResult();
            
            
        }
        catch(HibernateException e){
            System.out.println(e);
            
            
        }
   
        return usuario;
    }
    

}
