/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.controladores;

import com.biblioteca.dao.impl.SocioDao;
import com.biblioteca.entidades.Docente;
import com.biblioteca.entidades.Estudiante;
import com.biblioteca.entidades.Externo;
import com.biblioteca.entidades.SocioBiblioteca;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
    private Docente docente;
    private Estudiante estudiante;
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

    public Estudiante getEstudiante() {
        if(estudiante == null){
            estudiante = new Estudiante();
        }
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
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
    
    
    
    
}
