/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Pago;
import modelo.Pedido;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;
import persistencia.NewHibernateUtil;

/**
 *
 * @author pazan mera
 */
public class PedidoDaoImple implements PedidoDao{

    @Override
    public List<Pedido> consultarDetalle() {
        Session session = null;
        List<Pedido> lstPedido = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("From Pedido p  inner join fetch p.producto inner join fetch p.usuario inner join fetch p.pago"); 
            lstPedido = query.list();    
        }
        catch(HibernateException e){
            System.out.println(e);
            
            
        }
        finally{
            if(session != null){
                session.close(); 
            }
        }
        return lstPedido;
    }

    @Override
    public void agregarDetalle(Pedido detallePedido, int id_user) {
        Session session = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createSQLQuery("insert into pedido (descri_direccion, codigo_postal, ciudad, total, id_usuario) values (?, ?, ?, ?,?)"); 
            query.setParameter(0,detallePedido.getDescriDireccion());
            query.setParameter(1,detallePedido.getCodigoPostal());
            query.setParameter(2,detallePedido.getCiudad());
            query.setParameter(3,detallePedido.getTotal());
            
            //query.setInteger(4,id_prod);
            query.setInteger(4, id_user);            

            query.executeUpdate();
            
            session.getTransaction().commit();
               
        }
        catch(HibernateException e){
            System.out.println(e);
            
            
        }
       

    }

    @Override
    public void agregarPago(Pago pago) {
        Session session = null;
        try{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String sql ="insert into Pago(metodo_pago, nombre_titular, fecha_expedicion, numero_tarjeta) values (?, ?, ?, ?)";
            Query query = session.createSQLQuery(sql); 
            query.setParameter(0,pago.getMetodoPago());
            query.setParameter(1,pago.getNombreTitular());
            query.setParameter(2,pago.getFechaExpedicion());
            query.setParameter(3,pago.getNumeroTarjeta());
            
            query.executeUpdate();
            
            session.getTransaction().commit();
               
        }
        catch(HibernateException e){
            System.out.println(e);
            
            
        }
    }
    
}
