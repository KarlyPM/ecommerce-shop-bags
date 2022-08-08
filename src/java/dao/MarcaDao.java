/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Marca;

/**
 *
 * @author pazan mera
 */
public interface MarcaDao {
    public List<Marca> ConsultarMarca();
    public List<Integer> ConsultarMarcaID();
    public List<String> ConsultarMarcaDescripc();
    

}
