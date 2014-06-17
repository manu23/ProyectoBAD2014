/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mejia
 */
@Entity
@Table(name = "USUARIO_SISTEMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioSistema.findAll", query = "SELECT u FROM UsuarioSistema u"),
    @NamedQuery(name = "UsuarioSistema.findByIdusuario", query = "SELECT u FROM UsuarioSistema u WHERE u.idusuario = :idusuario"),
    @NamedQuery(name = "UsuarioSistema.findByLogin", query = "SELECT COUNT(u) FROM UsuarioSistema u WHERE u.idusuario = :idusuario AND u.pass = :pass"),
    @NamedQuery(name = "UsuarioSistema.findByPass", query = "SELECT u FROM UsuarioSistema u WHERE u.pass = :pass")})
public class UsuarioSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "IDUSUARIO")
    private String idusuario;
    @Size(max = 8)
    @Column(name = "PASS")
    private String pass;
    @JoinColumn(name = "CARNETSOCIO", referencedColumnName = "CARNETSOCIO")
    @ManyToOne(optional = false)
    private SocioBiblioteca carnetsocio;
    @JoinColumn(name = "IDPERFIL", referencedColumnName = "IDPERFIL")
    @ManyToOne(optional = false)
    private Perfil idperfil;

    public UsuarioSistema() {
    }

    public UsuarioSistema(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public SocioBiblioteca getCarnetsocio() {
        return carnetsocio;
    }

    public void setCarnetsocio(SocioBiblioteca carnetsocio) {
        this.carnetsocio = carnetsocio;
    }

    public Perfil getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Perfil idperfil) {
        this.idperfil = idperfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioSistema)) {
            return false;
        }
        UsuarioSistema other = (UsuarioSistema) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.UsuarioSistema[ idusuario=" + idusuario + " ]";
    }
    
}
