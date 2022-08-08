/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author User
 */
public interface UsuarioDao {
    public List<Usuario> ConsultarUsuario();
    public void agregarUsuario(Usuario usuario);
    public void agregarRegistro(Usuario usuario);
    public void modificarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
    public Usuario IniciarSesion(Usuario u) throws Exception;
    public Usuario getDatosUsuarios(Integer id);
    
}
