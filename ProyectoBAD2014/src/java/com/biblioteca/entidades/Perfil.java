/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mejia
 */
@Entity
@Table(name = "PERFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByIdperfil", query = "SELECT p FROM Perfil p WHERE p.idperfil = :idperfil"),
    @NamedQuery(name = "Perfil.findByTipoperfil", query = "SELECT p FROM Perfil p WHERE p.tipoperfil = :tipoperfil")})
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPERFIL")
    private BigDecimal idperfil;
    @Size(max = 15)
    @Column(name = "TIPOPERFIL")
    private String tipoperfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperfil")
    private List<UsuarioSistema> usuarioSistemaList;

    public Perfil() {
    }

    public Perfil(BigDecimal idperfil) {
        this.idperfil = idperfil;
    }

    public BigDecimal getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(BigDecimal idperfil) {
        this.idperfil = idperfil;
    }

    public String getTipoperfil() {
        return tipoperfil;
    }

    public void setTipoperfil(String tipoperfil) {
        this.tipoperfil = tipoperfil;
    }

    @XmlTransient
    public List<UsuarioSistema> getUsuarioSistemaList() {
        return usuarioSistemaList;
    }

    public void setUsuarioSistemaList(List<UsuarioSistema> usuarioSistemaList) {
        this.usuarioSistemaList = usuarioSistemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperfil != null ? idperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.idperfil == null && other.idperfil != null) || (this.idperfil != null && !this.idperfil.equals(other.idperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.Perfil[ idperfil=" + idperfil + " ]";
    }
    
}
