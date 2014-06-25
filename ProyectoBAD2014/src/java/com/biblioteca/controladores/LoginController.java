/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.controladores;

import com.biblioteca.dao.impl.LoginDaoImpl;
import com.biblioteca.entidades.UsuarioSistema;
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
public class LoginController {

    @EJB
    private LoginDaoImpl loginDaoImpl;
    private UsuarioSistema usuario;
    private List<UsuarioSistema> usuarios;
    
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    public UsuarioSistema getUsuario() {
        if(usuario == null){
            usuario = new UsuarioSistema();
        }
        return usuario;
    }

    public void setUsuario(UsuarioSistema usuario) {
        this.usuario = usuario;
    }

    public List<UsuarioSistema> getUsuarios() {
        usuarios = loginDaoImpl.ListarUsuarios();
        return usuarios;
    }

   
    
    
    public String loginAcceso(){
        if(loginDaoImpl.login(usuario)){           
            return "/UI/GestionArt/IngresarArt";
        }
        else{
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Datos Erroneos", "Datos Erroneos");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            usuario = new UsuarioSistema();
            return null; 
        }   
    }
    
    /*
    * Funcion de Eliminar
    */
    public void eliminarUsuario(String cod){
        loginDaoImpl.eliminarUsuario(cod);
        FacesContext context = FacesContext.getCurrentInstance();           
        context.addMessage(null, new FacesMessage("¡Usuario eliminado con exito!")); 
    }
    
}
