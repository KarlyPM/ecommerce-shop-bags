/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.MarcaDao;
import dao.MarcaDaoImple;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.Marca;

/**
 *
 * @author pazan mera
 */
@Named(value = "mbMarca")
@ViewScoped
public class mbMarca implements Serializable{

    /**
     * Creates a new instance of mbMarca
     */
     Marca obj_marca;
         
    public mbMarca() {
       obj_marca = new Marca();

    }

    public Marca getObj_marca() {
        return obj_marca;
    }

    public void setObj_marca(Marca obj_marca) {
        this.obj_marca = obj_marca;
    }
    
    public List<Marca> getLstMarca(){
        MarcaDao daoMarca = new MarcaDaoImple();

        return daoMarca.ConsultarMarca();
    }
    
    public List<Integer> getLstMarcaID(){
        MarcaDao daoMarca = new MarcaDaoImple();

        return daoMarca.ConsultarMarcaID();
    }
    
    public List<String> getLstMarcaDescripc(){
        MarcaDao daoMarca = new MarcaDaoImple();

        return daoMarca.ConsultarMarcaDescripc();
    }
    

}
