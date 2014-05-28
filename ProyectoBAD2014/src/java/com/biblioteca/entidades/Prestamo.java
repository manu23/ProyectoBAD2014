/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mejia
 */
@Entity
@Table(name = "PRESTAMO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p"),
    @NamedQuery(name = "Prestamo.findByIdprestamo", query = "SELECT p FROM Prestamo p WHERE p.idprestamo = :idprestamo"),
    @NamedQuery(name = "Prestamo.findByEstadoprestamo", query = "SELECT p FROM Prestamo p WHERE p.estadoprestamo = :estadoprestamo"),
    @NamedQuery(name = "Prestamo.findByFechaprestamo", query = "SELECT p FROM Prestamo p WHERE p.fechaprestamo = :fechaprestamo"),
    @NamedQuery(name = "Prestamo.findByFechadevolucion", query = "SELECT p FROM Prestamo p WHERE p.fechadevolucion = :fechadevolucion"),
    @NamedQuery(name = "Prestamo.findByFechatentativa", query = "SELECT p FROM Prestamo p WHERE p.fechatentativa = :fechatentativa")})
public class Prestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRESTAMO")
    private BigDecimal idprestamo;
    @Column(name = "ESTADOPRESTAMO")
    private BigInteger estadoprestamo;
    @Column(name = "FECHAPRESTAMO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaprestamo;
    @Column(name = "FECHADEVOLUCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadevolucion;
    @Column(name = "FECHATENTATIVA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechatentativa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestamo")
    private List<Mora> moraList;
    @JoinColumn(name = "CARNETSOCIO", referencedColumnName = "CARNETSOCIO")
    @ManyToOne(optional = false)
    private SocioBiblioteca carnetsocio;
    @JoinColumn(name = "CODIGO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Articulo codigo;

    public Prestamo() {
    }

    public Prestamo(BigDecimal idprestamo) {
        this.idprestamo = idprestamo;
    }

    public BigDecimal getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(BigDecimal idprestamo) {
        this.idprestamo = idprestamo;
    }

    public BigInteger getEstadoprestamo() {
        return estadoprestamo;
    }

    public void setEstadoprestamo(BigInteger estadoprestamo) {
        this.estadoprestamo = estadoprestamo;
    }

    public Date getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(Date fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public Date getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(Date fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public Date getFechatentativa() {
        return fechatentativa;
    }

    public void setFechatentativa(Date fechatentativa) {
        this.fechatentativa = fechatentativa;
    }

    @XmlTransient
    public List<Mora> getMoraList() {
        return moraList;
    }

    public void setMoraList(List<Mora> moraList) {
        this.moraList = moraList;
    }

    public SocioBiblioteca getCarnetsocio() {
        return carnetsocio;
    }

    public void setCarnetsocio(SocioBiblioteca carnetsocio) {
        this.carnetsocio = carnetsocio;
    }

    public Articulo getCodigo() {
        return codigo;
    }

    public void setCodigo(Articulo codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprestamo != null ? idprestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.idprestamo == null && other.idprestamo != null) || (this.idprestamo != null && !this.idprestamo.equals(other.idprestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.Prestamo[ idprestamo=" + idprestamo + " ]";
    }
    
}
