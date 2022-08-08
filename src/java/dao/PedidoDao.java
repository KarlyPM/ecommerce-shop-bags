/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Pago;
import modelo.Pedido;

/**
 *
 * @author pazan mera
 */
public interface PedidoDao {
    public List<Pedido> consultarDetalle();
    public void agregarDetalle(Pedido detalleFactura,int id_user) ;
    public void agregarPago(Pago pago);
    
}
