/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.controladores;

import com.biblioteca.dao.impl.DvdDao;
import com.biblioteca.entidades.Dvd;
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
public class DvdController {

    @EJB
    private DvdDao dvdDao;
    
    private List<Dvd> dvds;
    private Dvd dvd;
    
    public DvdController() {
    }
    
     public List<Dvd> getDvds() {
        dvds = dvdDao.buscarTodosDvd();
        return dvds;
    }

    public Dvd getDvd() {
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }
    
    /*
    * Funcion de Eliminar
    */
    public void eliminarDvd(String cod){
        dvdDao.eliminarDvd(cod);
        FacesContext context = FacesContext.getCurrentInstance();           
        context.addMessage(null, new FacesMessage("¡Dvd eliminado con exito!")); 
    }
}
