/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import modelo.Proveedor;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;
/**
 *
 * @author User
 */
public class ProveedoresDaoImple implements ProveedoresDao{

    @Override
    public List<Proveedor> ConsultarProveedor() {
        Session session = null;
        List<Proveedor> lstProveedor = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("From Proveedor order by idProveedor"); 
            lstProveedor = query.list();    
        }
        catch(HibernateException e){
            System.out.println(e);
            
            
        }
        finally{
            if(session != null){
                session.close(); 
            }
        }

        
        return lstProveedor;
    }

    @Override
    public void agregarProveedor(Proveedor obj_proveedor) {
        Session session= null;
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(obj_proveedor);
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
    public void modificarProveedor(Proveedor obj_proveedor) {
        Session session= null;
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(obj_proveedor);
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
    public void eliminarProveedor(Proveedor obj_proveedor) {
       
        Session session= null;
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(obj_proveedor);
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
    
}
