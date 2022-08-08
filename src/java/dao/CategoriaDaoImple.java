/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Categoria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

/**
 *
 * @author User
 */
public class CategoriaDaoImple implements CategoriaDao{

    @Override
    public List<Categoria> ConsultarCategoria() {
        Session session = null;
        List<Categoria> lstCategoria = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("From Categoria  order by idCategoria"); 
            lstCategoria = query.list();    
        }
        catch(HibernateException e){
            System.out.println(e);
            
            
        }
        finally{
            if(session != null){
                session.close(); 
            }
        }

        
        return lstCategoria;
    }
    

    @Override
    public void agregarCategoria(Categoria obj_categoria) {
        Session session= null;
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(obj_categoria);
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
    public void modificarCategoria(Categoria obj_categoria) {
        Session session= null;
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(obj_categoria);
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
    public void eliminarCategoria(Categoria obj_categoria) {
          Session session= null;
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(obj_categoria);
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
    public List<String> consultarCategoriaDescrip() {
        Session session = null;
        List<String> lstCategoria = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("Select descripcion From Categoria  order by idCategoria"); 
            lstCategoria = query.list();    
        }
        catch(HibernateException e){
            System.out.println(e);
            
            
        }
        finally{
            if(session != null){
                session.close(); 
            }
        }

        
        return lstCategoria;
    }    
    
   
    
}
