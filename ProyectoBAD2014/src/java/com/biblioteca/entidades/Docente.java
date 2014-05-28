/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mejia
 */
@Entity
@Table(name = "DOCENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d"),
    @NamedQuery(name = "Docente.findByCarnetsocio", query = "SELECT d FROM Docente d WHERE d.docentePK.carnetsocio = :carnetsocio"),
    @NamedQuery(name = "Docente.findByCarnetdocente", query = "SELECT d FROM Docente d WHERE d.docentePK.carnetdocente = :carnetdocente"),
    @NamedQuery(name = "Docente.findByPrimernombre", query = "SELECT d FROM Docente d WHERE d.primernombre = :primernombre"),
    @NamedQuery(name = "Docente.findBySegundonombre", query = "SELECT d FROM Docente d WHERE d.segundonombre = :segundonombre"),
    @NamedQuery(name = "Docente.findByPrimerapellido", query = "SELECT d FROM Docente d WHERE d.primerapellido = :primerapellido"),
    @NamedQuery(name = "Docente.findBySegundoapellido", query = "SELECT d FROM Docente d WHERE d.segundoapellido = :segundoapellido"),
    @NamedQuery(name = "Docente.findByDireccion", query = "SELECT d FROM Docente d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Docente.findByTelefono", query = "SELECT d FROM Docente d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Docente.findByDui", query = "SELECT d FROM Docente d WHERE d.dui = :dui"),
    @NamedQuery(name = "Docente.findByFecingreso", query = "SELECT d FROM Docente d WHERE d.fecingreso = :fecingreso"),
    @NamedQuery(name = "Docente.findByEmail", query = "SELECT d FROM Docente d WHERE d.email = :email"),
    @NamedQuery(name = "Docente.findByInstitucion", query = "SELECT d FROM Docente d WHERE d.institucion = :institucion"),
    @NamedQuery(name = "Docente.findByEscuela", query = "SELECT d FROM Docente d WHERE d.escuela = :escuela")})
public class Docente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocentePK docentePK;
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
    @Size(max = 50)
    @Column(name = "INSTITUCION")
    private String institucion;
    @Size(max = 50)
    @Column(name = "ESCUELA")
    private String escuela;
    @JoinColumn(name = "CARNETSOCIO", referencedColumnName = "CARNETSOCIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SocioBiblioteca socioBiblioteca;

    public Docente() {
    }

    public Docente(DocentePK docentePK) {
        this.docentePK = docentePK;
    }

    public Docente(String carnetsocio, String carnetdocente) {
        this.docentePK = new DocentePK(carnetsocio, carnetdocente);
    }

    public DocentePK getDocentePK() {
        return docentePK;
    }

    public void setDocentePK(DocentePK docentePK) {
        this.docentePK = docentePK;
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

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
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
        hash += (docentePK != null ? docentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.docentePK == null && other.docentePK != null) || (this.docentePK != null && !this.docentePK.equals(other.docentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.Docente[ docentePK=" + docentePK + " ]";
    }
    
}
