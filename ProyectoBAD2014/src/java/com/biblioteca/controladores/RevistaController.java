
package com.biblioteca.controladores;

import com.biblioteca.dao.impl.RevistaDao;
import com.biblioteca.entidades.Revista;
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
public class RevistaController {

    @EJB
    private RevistaDao revistaDao;
    
    private List<Revista> revistas;
    private Revista revista;
    
    public RevistaController() {
    }

    public List<Revista> getRevistas() {
        revistas = revistaDao.buscarTodosRev();
        return revistas;
    }

    public Revista getRevista() {
        return revista;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
    }
  
    /*
    * Funcion de Eliminar
    */
    public void eliminarRev(String cod){
        revistaDao.eliminarRev(cod);
        FacesContext context = FacesContext.getCurrentInstance();           
        context.addMessage(null, new FacesMessage("¡Revista eliminada con exito!")); 
    }
    
}
