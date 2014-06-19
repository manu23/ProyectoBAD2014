

package com.biblioteca.controladores;

import com.biblioteca.dao.impl.LibroDao;
import com.biblioteca.entidades.Libro;
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
public class LibroController {

    @EJB
    private LibroDao libroDao;
    
    private List<Libro> libros;
    private Libro libro;
    
    public LibroController() {
    }

    /*
    * Lista todos los libros
    */
    public List<Libro> getLibros() {
        libros = libroDao.buscarTodosLib();
        return libros;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    
    /*
    * Funcion de Eliminar
    */
    public void eliminarLib(String cod){
        libroDao.eliminarLib(cod);
        FacesContext context = FacesContext.getCurrentInstance();           
        context.addMessage(null, new FacesMessage("¡Libro eliminado con exito!")); 
    }
    
}
