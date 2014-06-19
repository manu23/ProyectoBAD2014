/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.controladores;

import com.biblioteca.dao.impl.TesisDao;
import com.biblioteca.entidades.Tesis;
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
public class TesisController {

    @EJB
    private TesisDao tesisDao;
    
    private List<Tesis> tesiss;
    private Tesis tesis;
    
    public TesisController() {
    }
    
    public List<Tesis> getTesiss() {
        tesiss = tesisDao.buscarTodosTesis();
        return tesiss;
    }

    public Tesis getTesis() {
        return tesis;
    }

    public void setTesis(Tesis tesis) {
        this.tesis = tesis;
    }
    
    /*
    * Funcion de Eliminar
    */
    public void eliminarTesis(String cod){
        tesisDao.eliminarTesis(cod);
        FacesContext context = FacesContext.getCurrentInstance();           
        context.addMessage(null, new FacesMessage("¡Tesis eliminado con exito!")); 
    }
    
}
