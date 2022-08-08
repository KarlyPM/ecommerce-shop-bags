/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Categoria;


public interface CategoriaDao {
    public List<Categoria> ConsultarCategoria();
    public void agregarCategoria(Categoria categoria);
    public void modificarCategoria(Categoria categoria);
    public void eliminarCategoria(Categoria categoria);
    public List<String> consultarCategoriaDescrip();   
}
