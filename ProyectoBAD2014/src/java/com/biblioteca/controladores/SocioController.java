/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.controladores;

import com.biblioteca.dao.impl.SocioDao;
import com.biblioteca.entidades.Docente;
import com.biblioteca.entidades.DocentePK;
import com.biblioteca.entidades.Estudiante;
import com.biblioteca.entidades.EstudiantePK;
import com.biblioteca.entidades.Externo;
import com.biblioteca.entidades.SocioBiblioteca;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Mejia
 */
@ManagedBean
@SessionScoped
public class SocioController {

    @EJB
    private SocioDao socioDao;
    
    private SocioBiblioteca socioBiblioteca;
    
    private List<SocioBiblioteca> socios;
       
    private Docente docente;
    private DocentePK docentePK;
    private String carnetDocente;
    
    private Estudiante estudiante;
    private EstudiantePK estudiantePK;
    private String carnetEstudiante;
    
    private Externo externo;
    
    private Integer tipo = 0;
    
    public SocioController() {
    }

    public SocioBiblioteca getSocioBiblioteca() {
        if(socioBiblioteca == null){
            socioBiblioteca = new SocioBiblioteca();
        }
        return socioBiblioteca;
    }

    public void setSocioBiblioteca(SocioBiblioteca socioBiblioteca) {
        this.socioBiblioteca = socioBiblioteca;
    }

    public Docente getDocente() {
        if(docente == null){
            docente = new Docente();
        }
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public DocentePK getDocentePK() {
        return docentePK;
    }

    public void setDocentePK(DocentePK docentePK) {
        this.docentePK = docentePK;
    }
       

    public Estudiante getEstudiante() {
        if(estudiante == null){
            estudiante = new Estudiante();
        }
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public EstudiantePK getEstudiantePK() {
        return estudiantePK;
    }

    public void setEstudiantePK(EstudiantePK estudiantePK) {
        this.estudiantePK = estudiantePK;
    }

    public String getCarnetEstudiante() {
        return carnetEstudiante;
    }

    public void setCarnetEstudiante(String carnetEstudiante) {
        this.carnetEstudiante = carnetEstudiante;
    }
      
    public Externo getExterno() {
        if(externo == null){
            externo = new Externo();
        }
        return externo;
    }

    public void setExterno(Externo externo) {
        this.externo = externo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getCarnetDocente() {
        return carnetDocente;
    }

    public void setCarnetDocente(String carnetDocente) {
        this.carnetDocente = carnetDocente;
    }
     
    
    /*
    * Metodo encargado de Ingresar un nuevo socio
    * a la base de datos.
    *
    */
    public void insertarSocio(ActionEvent actionEvent){
        socioDao.ingresarSocio(socioBiblioteca);                
        switch(tipo){
            case 1 : 
                
                docente.setPrimernombre(socioBiblioteca.getPrimernombre());
                docente.setSegundonombre(socioBiblioteca.getSegundonombre());
                docente.setPrimerapellido(socioBiblioteca.getPrimerapellido());
                docente.setSegundoapellido(socioBiblioteca.getSegundoapellido());
                docente.setDireccion(socioBiblioteca.getDireccion());
                docente.setTelefono(socioBiblioteca.getTelefono());
                docente.setDui(socioBiblioteca.getDui());
                docente.setFecingreso(socioBiblioteca.getFecingreso());
                docente.setEmail(socioBiblioteca.getEmail());
                socioDao.ingresarDocente(docente);
                docente = new Docente();
                break;
            case 2 :
                estudiantePK.setCarnetsocio(socioBiblioteca.getCarnetsocio());
                estudiantePK.setCarnetestudiante(getCarnetEstudiante());
                estudiante.setEstudiantePK(estudiantePK);
                estudiante.setPrimernombre(socioBiblioteca.getPrimernombre());
                estudiante.setSegundonombre(socioBiblioteca.getSegundonombre());
                estudiante.setPrimerapellido(socioBiblioteca.getPrimerapellido());
                estudiante.setSegundoapellido(socioBiblioteca.getSegundoapellido());
                estudiante.setDireccion(socioBiblioteca.getDireccion());
                estudiante.setTelefono(socioBiblioteca.getTelefono());
                estudiante.setDui(socioBiblioteca.getDui());
                estudiante.setFecingreso(socioBiblioteca.getFecingreso());
                estudiante.setEmail(socioBiblioteca.getEmail());
                socioDao.ingresarEstudiante(estudiante);
                estudiante = new Estudiante();
                break;
            case 3 : 
                externo.setCarnetsocio(socioBiblioteca.getCarnetsocio());
                externo.setPrimernombre(socioBiblioteca.getPrimernombre());
                externo.setSegundonombre(socioBiblioteca.getSegundonombre());
                externo.setPrimerapellido(socioBiblioteca.getPrimerapellido());
                externo.setSegundoapellido(socioBiblioteca.getSegundoapellido());
                externo.setDireccion(socioBiblioteca.getDireccion());
                externo.setTelefono(socioBiblioteca.getTelefono());
                externo.setDui(socioBiblioteca.getDui());
                externo.setFecingreso(socioBiblioteca.getFecingreso());
                externo.setEmail(socioBiblioteca.getEmail());
                socioDao.ingresarExterno(externo);
                externo = new Externo();
                break;                      
        }
        FacesContext context = FacesContext.getCurrentInstance();       
        context.addMessage(null, new FacesMessage("Operacion Correcta",  "Socio Ingresado con Exito") );
        socioBiblioteca = new SocioBiblioteca();       
    }

    public List<SocioBiblioteca> getSocios() {
        socios = socioDao.buscarTodos();
        return socios;
    }
    
    
    
    
}
