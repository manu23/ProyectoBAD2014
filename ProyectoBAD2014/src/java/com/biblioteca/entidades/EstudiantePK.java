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
public class EstudiantePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "CARNETSOCIO")
    private String carnetsocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "CARNETESTUDIANTE")
    private String carnetestudiante;

    public EstudiantePK() {
    }

    public EstudiantePK(String carnetsocio, String carnetestudiante) {
        this.carnetsocio = carnetsocio;
        this.carnetestudiante = carnetestudiante;
    }

    public String getCarnetsocio() {
        return carnetsocio;
    }

    public void setCarnetsocio(String carnetsocio) {
        this.carnetsocio = carnetsocio;
    }

    public String getCarnetestudiante() {
        return carnetestudiante;
    }

    public void setCarnetestudiante(String carnetestudiante) {
        this.carnetestudiante = carnetestudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carnetsocio != null ? carnetsocio.hashCode() : 0);
        hash += (carnetestudiante != null ? carnetestudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudiantePK)) {
            return false;
        }
        EstudiantePK other = (EstudiantePK) object;
        if ((this.carnetsocio == null && other.carnetsocio != null) || (this.carnetsocio != null && !this.carnetsocio.equals(other.carnetsocio))) {
            return false;
        }
        if ((this.carnetestudiante == null && other.carnetestudiante != null) || (this.carnetestudiante != null && !this.carnetestudiante.equals(other.carnetestudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.EstudiantePK[ carnetsocio=" + carnetsocio + ", carnetestudiante=" + carnetestudiante + " ]";
    }
    
}
