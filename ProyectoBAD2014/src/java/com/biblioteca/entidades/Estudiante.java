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
@Table(name = "ESTUDIANTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByCarnetsocio", query = "SELECT e FROM Estudiante e WHERE e.estudiantePK.carnetsocio = :carnetsocio"),
    @NamedQuery(name = "Estudiante.findByCarnetestudiante", query = "SELECT e FROM Estudiante e WHERE e.estudiantePK.carnetestudiante = :carnetestudiante"),
    @NamedQuery(name = "Estudiante.findByPrimernombre", query = "SELECT e FROM Estudiante e WHERE e.primernombre = :primernombre"),
    @NamedQuery(name = "Estudiante.findBySegundonombre", query = "SELECT e FROM Estudiante e WHERE e.segundonombre = :segundonombre"),
    @NamedQuery(name = "Estudiante.findByPrimerapellido", query = "SELECT e FROM Estudiante e WHERE e.primerapellido = :primerapellido"),
    @NamedQuery(name = "Estudiante.findBySegundoapellido", query = "SELECT e FROM Estudiante e WHERE e.segundoapellido = :segundoapellido"),
    @NamedQuery(name = "Estudiante.findByDireccion", query = "SELECT e FROM Estudiante e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Estudiante.findByTelefono", query = "SELECT e FROM Estudiante e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Estudiante.findByDui", query = "SELECT e FROM Estudiante e WHERE e.dui = :dui"),
    @NamedQuery(name = "Estudiante.findByFecingreso", query = "SELECT e FROM Estudiante e WHERE e.fecingreso = :fecingreso"),
    @NamedQuery(name = "Estudiante.findByEmail", query = "SELECT e FROM Estudiante e WHERE e.email = :email"),
    @NamedQuery(name = "Estudiante.findByFacultad", query = "SELECT e FROM Estudiante e WHERE e.facultad = :facultad"),
    @NamedQuery(name = "Estudiante.findByCarrera", query = "SELECT e FROM Estudiante e WHERE e.carrera = :carrera")})
public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudiantePK estudiantePK;
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
    @Column(name = "FACULTAD")
    private String facultad;
    @Size(max = 50)
    @Column(name = "CARRERA")
    private String carrera;
    @JoinColumn(name = "CARNETSOCIO", referencedColumnName = "CARNETSOCIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SocioBiblioteca socioBiblioteca;

    public Estudiante() {
    }

    public Estudiante(EstudiantePK estudiantePK) {
        this.estudiantePK = estudiantePK;
    }

    public Estudiante(String carnetsocio, String carnetestudiante) {
        this.estudiantePK = new EstudiantePK(carnetsocio, carnetestudiante);
    }

    public EstudiantePK getEstudiantePK() {
        return estudiantePK;
    }

    public void setEstudiantePK(EstudiantePK estudiantePK) {
        this.estudiantePK = estudiantePK;
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

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
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
        hash += (estudiantePK != null ? estudiantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.estudiantePK == null && other.estudiantePK != null) || (this.estudiantePK != null && !this.estudiantePK.equals(other.estudiantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.Estudiante[ estudiantePK=" + estudiantePK + " ]";
    }
    
}
