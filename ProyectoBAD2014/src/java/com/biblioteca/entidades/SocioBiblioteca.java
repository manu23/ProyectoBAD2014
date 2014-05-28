/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mejia
 */
@Entity
@Table(name = "SOCIO_BIBLIOTECA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SocioBiblioteca.findAll", query = "SELECT s FROM SocioBiblioteca s"),
    @NamedQuery(name = "SocioBiblioteca.findByCarnetsocio", query = "SELECT s FROM SocioBiblioteca s WHERE s.carnetsocio = :carnetsocio"),
    @NamedQuery(name = "SocioBiblioteca.findByPrimernombre", query = "SELECT s FROM SocioBiblioteca s WHERE s.primernombre = :primernombre"),
    @NamedQuery(name = "SocioBiblioteca.findBySegundonombre", query = "SELECT s FROM SocioBiblioteca s WHERE s.segundonombre = :segundonombre"),
    @NamedQuery(name = "SocioBiblioteca.findByPrimerapellido", query = "SELECT s FROM SocioBiblioteca s WHERE s.primerapellido = :primerapellido"),
    @NamedQuery(name = "SocioBiblioteca.findBySegundoapellido", query = "SELECT s FROM SocioBiblioteca s WHERE s.segundoapellido = :segundoapellido"),
    @NamedQuery(name = "SocioBiblioteca.findByDireccion", query = "SELECT s FROM SocioBiblioteca s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "SocioBiblioteca.findByTelefono", query = "SELECT s FROM SocioBiblioteca s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "SocioBiblioteca.findByDui", query = "SELECT s FROM SocioBiblioteca s WHERE s.dui = :dui"),
    @NamedQuery(name = "SocioBiblioteca.findByFecingreso", query = "SELECT s FROM SocioBiblioteca s WHERE s.fecingreso = :fecingreso"),
    @NamedQuery(name = "SocioBiblioteca.findByEmail", query = "SELECT s FROM SocioBiblioteca s WHERE s.email = :email")})
public class SocioBiblioteca implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carnetsocio")
    private List<Mora> moraList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "socioBiblioteca")
    private Externo externo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socioBiblioteca")
    private List<Docente> docenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "socioBiblioteca")
    private List<Estudiante> estudianteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carnetsocio")
    private List<UsuarioSistema> usuarioSistemaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carnetsocio")
    private List<Prestamo> prestamoList;

    public SocioBiblioteca() {
    }

    public SocioBiblioteca(String carnetsocio) {
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

    @XmlTransient
    public List<Mora> getMoraList() {
        return moraList;
    }

    public void setMoraList(List<Mora> moraList) {
        this.moraList = moraList;
    }

    public Externo getExterno() {
        return externo;
    }

    public void setExterno(Externo externo) {
        this.externo = externo;
    }

    @XmlTransient
    public List<Docente> getDocenteList() {
        return docenteList;
    }

    public void setDocenteList(List<Docente> docenteList) {
        this.docenteList = docenteList;
    }

    @XmlTransient
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @XmlTransient
    public List<UsuarioSistema> getUsuarioSistemaList() {
        return usuarioSistemaList;
    }

    public void setUsuarioSistemaList(List<UsuarioSistema> usuarioSistemaList) {
        this.usuarioSistemaList = usuarioSistemaList;
    }

    @XmlTransient
    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
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
        if (!(object instanceof SocioBiblioteca)) {
            return false;
        }
        SocioBiblioteca other = (SocioBiblioteca) object;
        if ((this.carnetsocio == null && other.carnetsocio != null) || (this.carnetsocio != null && !this.carnetsocio.equals(other.carnetsocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.SocioBiblioteca[ carnetsocio=" + carnetsocio + " ]";
    }
    
}
