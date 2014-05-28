
package com.biblioteca.controladores;

import com.biblioteca.dao.ArticuloDAO;
import com.biblioteca.entidades.Articulo;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class ArticuloController {

    @EJB
    private ArticuloDAO articuloDAO;
    private Articulo articulo;
    
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
    
    public void insertarArt(ActionEvent actionEvent){
        articuloDAO.ingresarArt(articulo);
    }
    
}
