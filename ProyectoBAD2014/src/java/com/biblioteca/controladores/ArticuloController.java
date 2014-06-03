
package com.biblioteca.controladores;

import com.biblioteca.dao.ArticuloDAO;
import com.biblioteca.entidades.Articulo;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class ArticuloController {

    @EJB
    private ArticuloDAO articuloDAO;
    private Articulo articulo;
    private List<Articulo> articulos;
    private Integer tipo = 0;
    
    public ArticuloController() {
    }
     
    public Articulo getArticulo() {
        if(articulo == null){
            articulo = new Articulo();
        }
        return articulo;
    }
 
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    
    
    
    /*
    * Metodo encargado de Ingresar de buscar 
    * todos los articulos en la base de datos.
    *
    */
    public List<Articulo> getArticulos() {
        articulos = articuloDAO.buscarTodos();
        return articulos;
    }
    
    /*
    * Metodo encargado de Ingresar un nuevo articulo 
    * a la base de datos.
    *
    */
    public void insertarArt(ActionEvent actionEvent){
        articuloDAO.ingresarArt(articulo);
        FacesContext context = FacesContext.getCurrentInstance();       
        context.addMessage(null, new FacesMessage("Operacion Correcta",  "Articulo Ingresado con Exito") );
        articulo = new Articulo();
    }
    
}
