/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mejia
 */
@Entity
@Table(name = "EXTERNO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Externo.findAll", query = "SELECT e FROM Externo e"),
    @NamedQuery(name = "Externo.findByCarnetsocio", query = "SELECT e FROM Externo e WHERE e.carnetsocio = :carnetsocio"),
    @NamedQuery(name = "Externo.findByPrimernombre", query = "SELECT e FROM Externo e WHERE e.primernombre = :primernombre"),
    @NamedQuery(name = "Externo.findBySegundonombre", query = "SELECT e FROM Externo e WHERE e.segundonombre = :segundonombre"),
    @NamedQuery(name = "Externo.findByPrimerapellido", query = "SELECT e FROM Externo e WHERE e.primerapellido = :primerapellido"),
    @NamedQuery(name = "Externo.findBySegundoapellido", query = "SELECT e FROM Externo e WHERE e.segundoapellido = :segundoapellido"),
    @NamedQuery(name = "Externo.findByDireccion", query = "SELECT e FROM Externo e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Externo.findByTelefono", query = "SELECT e FROM Externo e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Externo.findByDui", query = "SELECT e FROM Externo e WHERE e.dui = :dui"),
    @NamedQuery(name = "Externo.findByFecingreso", query = "SELECT e FROM Externo e WHERE e.fecingreso = :fecingreso"),
    @NamedQuery(name = "Externo.findByEmail", query = "SELECT e FROM Externo e WHERE e.email = :email"),
    @NamedQuery(name = "Externo.findByNit", query = "SELECT e FROM Externo e WHERE e.nit = :nit"),
    @NamedQuery(name = "Externo.findByCarnetminoridad", query = "SELECT e FROM Externo e WHERE e.carnetminoridad = :carnetminoridad")})
public class Externo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "CARNETSOCIO")
    private String carnetsocio;
    @Size(max = 30)
    @Column(name = "PRIMERNOMBRE")
    private String primernombre;
    @Size(max = 30)
    @Column(name = "SEGUNDONOMBRE")
    private String segundonombre;
    @Size(max = 30)
    @Column(name = "PRIMERAPELLIDO")
    private String primerapellido;
    @Size(max = 30)
    @Column(name = "SEGUNDOAPELLIDO")
    private String segundoapellido;
    @Size(max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 9)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 10)
    @Column(name = "DUI")
    private String dui;
    @Column(name = "FECINGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecingreso;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 17)
    @Column(name = "NIT")
    private String nit;
    @Size(max = 5)
    @Column(name = "CARNETMINORIDAD")
    private String carnetminoridad;
    @JoinColumn(name = "CARNETSOCIO", referencedColumnName = "CARNETSOCIO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SocioBiblioteca socioBiblioteca;

    public Externo() {
    }

    public Externo(String carnetsocio) {
        this.carnetsocio = carnetsocio;
    }

    public String getCarnetsocio() {
        return carnetsocio;
    }

    public void setCarnetsocio(String carnetsocio) {
        this.carnetsocio = carnetsocio;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public Date getFecingreso() {
        return fecingreso;
    }

    public void setFecingreso(Date fecingreso) {
        this.fecingreso = fecingreso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCarnetminoridad() {
        return carnetminoridad;
    }

    public void setCarnetminoridad(String carnetminoridad) {
        this.carnetminoridad = carnetminoridad;
    }

    public SocioBiblioteca getSocioBiblioteca() {
        return socioBiblioteca;
    }

    public void setSocioBiblioteca(SocioBiblioteca socioBiblioteca) {
        this.socioBiblioteca = socioBiblioteca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carnetsocio != null ? carnetsocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Externo)) {
            return false;
        }
        Externo other = (Externo) object;
        if ((this.carnetsocio == null && other.carnetsocio != null) || (this.carnetsocio != null && !this.carnetsocio.equals(other.carnetsocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.Externo[ carnetsocio=" + carnetsocio + " ]";
    }
    
}
