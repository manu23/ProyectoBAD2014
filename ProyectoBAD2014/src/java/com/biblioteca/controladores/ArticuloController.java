
package com.biblioteca.controladores;

import com.biblioteca.dao.ArticuloDAO;
import com.biblioteca.entidades.Articulo;
import com.biblioteca.entidades.Cd;
import com.biblioteca.entidades.Dvd;
import com.biblioteca.entidades.Libro;
import com.biblioteca.entidades.Memorias;
import com.biblioteca.entidades.Obras;
import com.biblioteca.entidades.Periodicos;
import com.biblioteca.entidades.Revista;
import com.biblioteca.entidades.Tesis;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class ArticuloController {

    @EJB
    private ArticuloDAO articuloDAO;
    
    //Catehorias articulos
    private Articulo articulo;
    private Libro libro;
    private Revista revista;
    private Cd cd;
    private Dvd dvd;
    private Tesis tesis;
    private Periodicos periodicos;
    private Obras obras;
    private Memorias memorias;
    
    private List<Articulo> articulos;
    private Integer tipo = 0;
    
    public ArticuloController() {
    }
     
    /*
    *Setter y Getters de cada categoria de articulo
    *
    */
    
    public Articulo getArticulo() {
        if(articulo == null){
            articulo = new Articulo();
        }
        return articulo;
    }
 
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Libro getLibro() {
        if(libro == null){
            libro = new Libro();
        }
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Revista getRevista() {
        if(revista == null){
            revista = new Revista();
        }
        return revista;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
    }

    public Cd getCd() {
        if(cd == null){
            cd = new Cd();
        }
        return cd;
    }

    public void setCd(Cd cd) {
        this.cd = cd;
    }

    public Dvd getDvd() {
        if(dvd == null){
            dvd = new Dvd();
        }
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }

    public Tesis getTesis() {
        if(tesis == null){
            tesis = new Tesis();
        }
        return tesis;
    }

    public void setTesis(Tesis tesis) {
        this.tesis = tesis;
    }

    public Periodicos getPeriodicos() {
        if(periodicos == null){
            periodicos = new Periodicos();
        }
        return periodicos;
    }

    public void setPeriodicos(Periodicos periodicos) {
        this.periodicos = periodicos;
    }

    public Obras getObras() {
       if(obras == null){
            obras = new Obras();
        }
        return obras;
    }

    public void setObras(Obras obras) {
        this.obras = obras;
    }

    public Memorias getMemorias() {
        if(memorias == null){
            memorias = new Memorias();
        }
        return memorias;
    }

    public void setMemorias(Memorias memorias) {
        this.memorias = memorias;
    }
    
    

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    
    
    
    /*
    * Metodo encargado de buscar 
    * todos los articulos en la base de datos.
    *
    */
    public List<Articulo> getArticulos() {
        articulos = articuloDAO.buscarTodos();
        return articulos;
    }
    
    /*
    * Metodo encargado de Ingresar un nuevo articulo 
    * a la base de datos.
    *
    */
    public void insertarArt(ActionEvent actionEvent){
        articuloDAO.ingresarArt(articulo);                
        /*switch(tipo){
            case 1 : 
                libro.setCodigo(articulo.getCodigo());
                libro.setAutor(articulo.getAutor());
                libro.setTitulo(articulo.getTitulo());
                libro.setDescripcionart(articulo.getDescripcionart());
                libro.setPrecio(articulo.getPrecio());
                libro.setDonado(articulo.getDonado());
                libro.setEstado(articulo.getEstado());
                libro.setIdioma(articulo.getIdioma());
                articuloDAO.ingresarLib(libro);
                libro = new Libro();
                break;
            case 2 :
                revista.setCodigo(articulo.getCodigo());
                revista.setAutor(articulo.getAutor());
                revista.setTitulo(articulo.getTitulo());
                revista.setDescripcionart(articulo.getDescripcionart());
                revista.setPrecio(articulo.getPrecio());
                revista.setDonado(articulo.getDonado());
                revista.setEstado(articulo.getEstado());
                revista.setIdioma(articulo.getIdioma());
                articuloDAO.ingresarRev(revista);
                revista = new Revista();
                break;
            case 3 : 
                cd.setCodigo(articulo.getCodigo());
                cd.setAutor(articulo.getAutor());
                cd.setTitulo(articulo.getTitulo());
                cd.setDescripcionart(articulo.getDescripcionart());
                cd.setPrecio(articulo.getPrecio());
                cd.setDonado(articulo.getDonado());
                cd.setEstado(articulo.getEstado());
                cd.setIdioma(articulo.getIdioma());
                articuloDAO.ingresarCd(cd);
                cd = new Cd();
                break;
            case 4 : 
                dvd.setCodigo(articulo.getCodigo());
                dvd.setAutor(articulo.getAutor());
                dvd.setTitulo(articulo.getTitulo());
                dvd.setDescripcionart(articulo.getDescripcionart());
                dvd.setPrecio(articulo.getPrecio());
                dvd.setDonado(articulo.getDonado());
                dvd.setEstado(articulo.getEstado());
                dvd.setIdioma(articulo.getIdioma());
                articuloDAO.ingresarDvd(dvd);
                dvd = new Dvd();
                break;
            case 5 :
                tesis.setCodigo(articulo.getCodigo());
                tesis.setAutor(articulo.getAutor());
                tesis.setTitulo(articulo.getTitulo());
                tesis.setDescripcionart(articulo.getDescripcionart());
                tesis.setPrecio(articulo.getPrecio());
                tesis.setDonado(articulo.getDonado());
                tesis.setEstado(articulo.getEstado());
                tesis.setIdioma(articulo.getIdioma());
                articuloDAO.ingresarTesis(tesis);
                tesis = new Tesis();
                break;
            case 6 :
                periodicos.setCodigo(articulo.getCodigo());
                periodicos.setAutor(articulo.getAutor());
                periodicos.setTitulo(articulo.getTitulo());
                periodicos.setDescripcionart(articulo.getDescripcionart());
                periodicos.setPrecio(articulo.getPrecio());
                periodicos.setDonado(articulo.getDonado());
                periodicos.setEstado(articulo.getEstado());
                periodicos.setIdioma(articulo.getIdioma());
                articuloDAO.ingresarPeriodicos(periodicos);
                periodicos = new Periodicos();
                break;
            case 7 : 
                obras.setCodigo(articulo.getCodigo());
                obras.setAutor(articulo.getAutor());
                obras.setTitulo(articulo.getTitulo());
                obras.setDescripcionart(articulo.getDescripcionart());
                obras.setPrecio(articulo.getPrecio());
                obras.setDonado(articulo.getDonado());
                obras.setEstado(articulo.getEstado());
                obras.setIdioma(articulo.getIdioma());
                articuloDAO.ingresarObras(obras);
                obras = new Obras();
                break;
            case 8 : 
                memorias.setCodigo(articulo.getCodigo());
                memorias.setAutor(articulo.getAutor());
                memorias.setTitulo(articulo.getTitulo());
                memorias.setDescripcionart(articulo.getDescripcionart());
                memorias.setPrecio(articulo.getPrecio());
                memorias.setDonado(articulo.getDonado());
                memorias.setEstado(articulo.getEstado());
                memorias.setIdioma(articulo.getIdioma());
                articuloDAO.ingresarMemorias(memorias);
                memorias = new Memorias();
                break;              
        }*/
        FacesContext context = FacesContext.getCurrentInstance();       
        context.addMessage(null, new FacesMessage("Operacion Correcta",  "Articulo Ingresado con Exito") );
        articulo = new Articulo();
        
    }
    
}
