/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Producto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

/**
 *
 * @author pazan mera
 */
public class ProductoDaoImple implements ProductoDao{

    @Override
    public List<Producto> ConsultarProducto() {
        Session session = null;
        List<Producto> lstProducto = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("From Producto p  inner join fetch p.categoria inner join fetch p.proveedor inner join fetch p.marca order by id_Producto"); 
            lstProducto = query.list();    
        }
        catch(HibernateException e){
            System.out.println(e);
            
            
        }
        finally{
            if(session != null){
                session.close(); 
            }
        }

        
        return lstProducto;
        
    }

    @Override
    public void agregarProducto(Producto producto) {
        Session session= null;
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(producto);
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
    public void modificarProducto(Producto producto) {
        Session session= null;
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(producto);
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
    public void eliminarProducto(Producto producto) {
          Session session= null;
        try{
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(producto);
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
