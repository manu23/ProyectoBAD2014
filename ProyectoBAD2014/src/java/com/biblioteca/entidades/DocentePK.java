/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mejia
 */
@Embeddable
public class DocentePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "CARNETSOCIO")
    private String carnetsocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "CARNETDOCENTE")
    private String carnetdocente;

    public DocentePK() {
    }

    public DocentePK(String carnetsocio, String carnetdocente) {
        this.carnetsocio = carnetsocio;
        this.carnetdocente = carnetdocente;
    }

    public String getCarnetsocio() {
        return carnetsocio;
    }

    public void setCarnetsocio(String carnetsocio) {
        this.carnetsocio = carnetsocio;
    }

    public String getCarnetdocente() {
        return carnetdocente;
    }

    public void setCarnetdocente(String carnetdocente) {
        this.carnetdocente = carnetdocente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carnetsocio != null ? carnetsocio.hashCode() : 0);
        hash += (carnetdocente != null ? carnetdocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocentePK)) {
            return false;
        }
        DocentePK other = (DocentePK) object;
        if ((this.carnetsocio == null && other.carnetsocio != null) || (this.carnetsocio != null && !this.carnetsocio.equals(other.carnetsocio))) {
            return false;
        }
        if ((this.carnetdocente == null && other.carnetdocente != null) || (this.carnetdocente != null && !this.carnetdocente.equals(other.carnetdocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.DocentePK[ carnetsocio=" + carnetsocio + ", carnetdocente=" + carnetdocente + " ]";
    }
    
}
