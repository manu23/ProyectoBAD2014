

package com.biblioteca.controladores;

import com.biblioteca.dao.impl.CdDao;
import com.biblioteca.entidades.Cd;
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
public class CdController {

    @EJB
    private CdDao cdDao;
    
    private List<Cd> cds;
    private Cd cd;
    
    public CdController() {
    }

    public List<Cd> getCds() {
        cds = cdDao.buscarTodosCd();
        return cds;
    }

    public Cd getCd() {
        return cd;
    }

    public void setCd(Cd cd) {
        this.cd = cd;
    }
    
    /*
    * Funcion de Eliminar
    */
    public void eliminarCd(String cod){
        cdDao.eliminarCd(cod);
        FacesContext context = FacesContext.getCurrentInstance();           
        context.addMessage(null, new FacesMessage("¡Cd eliminado con exito!")); 
    }
    
    
    
}
