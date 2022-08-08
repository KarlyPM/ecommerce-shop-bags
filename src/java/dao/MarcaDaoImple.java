/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Marca;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

/**
 *
 * @author pazan mera
 */
public class MarcaDaoImple implements MarcaDao{

    @Override
    public List<Marca> ConsultarMarca() {

        Session session = null;
        List<Marca> lstMarca = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("From Marca order by idMarca"); 
            lstMarca = query.list();    
        }
        catch(HibernateException e){
            System.out.println(e);
            
            
        }
        finally{
            if(session != null){
                session.close(); 
            }
        }

        
        return lstMarca;

    }

    @Override
    public List<Integer> ConsultarMarcaID() {
        Session session = null;
        List<Integer> lstMarca = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("Select idMarca From Marca order by idMarca"); 
            lstMarca = query.list();    
        }
        catch(HibernateException e){
            System.out.println(e);
            
            
        }
        finally{
            if(session != null){
                session.close(); 
            }
        }

        
        return lstMarca;
    }
    
    @Override
    public List<String> ConsultarMarcaDescripc() {
        Session session = null;
        List<String> lstMarca = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("Select descripcion From Marca order by idMarca"); 
            lstMarca = query.list();    
        }
        catch(HibernateException e){
            System.out.println(e);
            
            
        }
        finally{
            if(session != null){
                session.close(); 
            }
        }

        
        return lstMarca;
    }    
    
}
