/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Proveedor;


/**
 *
 * @author User
 */
public interface ProveedoresDao {
    public List<Proveedor> ConsultarProveedor();
    public void agregarProveedor(Proveedor proveedor);
    public void modificarProveedor(Proveedor proveedor);
    public void eliminarProveedor(Proveedor proveedor);
    
}
