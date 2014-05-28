
package com.biblioteca.controladores;

import com.biblioteca.dao.ArticuloDAO;
import com.biblioteca.entidades.Articulo;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ArticuloController {

    @EJB
    private ArticuloDAO articuloDAO;
    private Articulo articulo;
    
    public ArticuloController() {
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
    public void insertarArt(Articulo articulo){
        articuloDAO.ingresarArt(articulo);
    }
    
}
