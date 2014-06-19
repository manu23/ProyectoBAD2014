/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.controladores;

import com.biblioteca.dao.impl.MemoriasDao;
import com.biblioteca.entidades.Memorias;
import java.util.List;
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
public class MemoriasController {

    @EJB
    private MemoriasDao memoriasDao;
    
    private List<Memorias> memoriass;
    private Memorias memorias;
    
    public MemoriasController() {
    }
    
    public List<Memorias> getMemoriass() {
        memoriass = memoriasDao.buscarTodosMemorias();
        return memoriass;
    }

    public Memorias getMemorias() {
        return memorias;
    }

    public void setMemorias(Memorias memorias) {
        this.memorias = memorias;
    }
    
    /*
    * Funcion de Eliminar
    */
    public void eliminarMemorias(String cod){
        memoriasDao.eliminarMemorias(cod);
        FacesContext context = FacesContext.getCurrentInstance();           
        context.addMessage(null, new FacesMessage("¡Memoria eliminado con exito!")); 
    }
    
    
}
