/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mejia
 */
@Embeddable
public class MoraPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRESTAMO")
    private BigInteger idprestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMORA")
    private BigInteger idmora;

    public MoraPK() {
    }

    public MoraPK(BigInteger idprestamo, BigInteger idmora) {
        this.idprestamo = idprestamo;
        this.idmora = idmora;
    }

    public BigInteger getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(BigInteger idprestamo) {
        this.idprestamo = idprestamo;
    }

    public BigInteger getIdmora() {
        return idmora;
    }

    public void setIdmora(BigInteger idmora) {
        this.idmora = idmora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprestamo != null ? idprestamo.hashCode() : 0);
        hash += (idmora != null ? idmora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MoraPK)) {
            return false;
        }
        MoraPK other = (MoraPK) object;
        if ((this.idprestamo == null && other.idprestamo != null) || (this.idprestamo != null && !this.idprestamo.equals(other.idprestamo))) {
            return false;
        }
        if ((this.idmora == null && other.idmora != null) || (this.idmora != null && !this.idmora.equals(other.idmora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.MoraPK[ idprestamo=" + idprestamo + ", idmora=" + idmora + " ]";
    }
    
}
