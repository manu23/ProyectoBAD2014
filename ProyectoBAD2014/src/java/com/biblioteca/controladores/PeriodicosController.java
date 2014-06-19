/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.controladores;

import com.biblioteca.dao.impl.PeriodicosDao;
import com.biblioteca.entidades.Periodicos;
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
public class PeriodicosController {

    @EJB
    private PeriodicosDao periodicosDao;
    
    private List<Periodicos> periodicoss;
    private Periodicos periodicos;
    
    public PeriodicosController() {
    }
    
    public List<Periodicos> getPeriodicoss() {
        periodicoss = periodicosDao.buscarTodosPeriodicos();
        return periodicoss;
    }

    public Periodicos getPeriodicos() {
        return periodicos;
    }

    public void setPeriodicos(Periodicos periodicos) {
        this.periodicos = periodicos;
    }
    
    /*
    * Funcion de Eliminar
    */
    public void eliminarPeriodicos(String cod){
        periodicosDao.eliminarPeriodicos(cod);
        FacesContext context = FacesContext.getCurrentInstance();           
        context.addMessage(null, new FacesMessage("¡Periodico eliminado con exito!")); 
    }
    
}
