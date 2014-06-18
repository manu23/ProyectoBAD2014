/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.controladores;

import com.biblioteca.dao.impl.BusquedaEliminacion;
import com.biblioteca.entidades.Libro;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mejia
 */
@ManagedBean
@SessionScoped
public class ElimacionController {

    @EJB
    private BusquedaEliminacion busquedaEliminacion;
    
    private Libro libro;
    
    public ElimacionController() {
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    /*
    * Funciones de Busqueda
    */       
    //No utilizadas por el momento
   /* public void buscarLib(String cod){
        libro = busquedaEliminacion.buscarLib(cod);
    }*/
    
    
    /*
    * Funciones de Eliminacion
    */
    
    public void eliminarLib(String cod){
        busquedaEliminacion.eliminarLib(cod);
        FacesContext context = FacesContext.getCurrentInstance();           
        context.addMessage(null, new FacesMessage("¡Libro eliminado con exito!")); 
    }
    
}
