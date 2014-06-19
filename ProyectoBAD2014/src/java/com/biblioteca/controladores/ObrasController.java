/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.controladores;

import com.biblioteca.dao.impl.ObrasDao;
import com.biblioteca.entidades.Obras;
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
public class ObrasController {

    @EJB
    private ObrasDao obrasDao;
    
    private List<Obras> obrass;
    private Obras obras;
    
    public ObrasController() {
    }
    
    
    public List<Obras> getObrass() {
        obrass = obrasDao.buscarTodosObras();
        return obrass;
    }

    public Obras getObras() {
        return obras;
    }

    public void setObras(Obras obras) {
        this.obras = obras;
    }
    
    /*
    * Funcion de Eliminar
    */
    public void eliminarObras(String cod){
        obrasDao.eliminarObras(cod);
        FacesContext context = FacesContext.getCurrentInstance();           
        context.addMessage(null, new FacesMessage("¡Obra eliminado con exito!")); 
    }
}
