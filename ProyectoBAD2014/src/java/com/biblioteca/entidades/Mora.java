/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "MORA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mora.findAll", query = "SELECT m FROM Mora m"),
    @NamedQuery(name = "Mora.findByIdprestamo", query = "SELECT m FROM Mora m WHERE m.moraPK.idprestamo = :idprestamo"),
    @NamedQuery(name = "Mora.findByIdmora", query = "SELECT m FROM Mora m WHERE m.moraPK.idmora = :idmora"),
    @NamedQuery(name = "Mora.findByTipomora", query = "SELECT m FROM Mora m WHERE m.tipomora = :tipomora"),
    @NamedQuery(name = "Mora.findByDescripcion", query = "SELECT m FROM Mora m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Mora.findByEstadomora", query = "SELECT m FROM Mora m WHERE m.estadomora = :estadomora"),
    @NamedQuery(name = "Mora.findByPenalizacion", query = "SELECT m FROM Mora m WHERE m.penalizacion = :penalizacion"),
    @NamedQuery(name = "Mora.findByIniciopenalizacion", query = "SELECT m FROM Mora m WHERE m.iniciopenalizacion = :iniciopenalizacion"),
    @NamedQuery(name = "Mora.findByFinpenalizacion", query = "SELECT m FROM Mora m WHERE m.finpenalizacion = :finpenalizacion")})
public class Mora implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MoraPK moraPK;
    @Size(max = 15)
    @Column(name = "TIPOMORA")
    private String tipomora;
    @Size(max = 15)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ESTADOMORA")
    private BigInteger estadomora;
    @Size(max = 10)
    @Column(name = "PENALIZACION")
    private String penalizacion;
    @Column(name = "INICIOPENALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date iniciopenalizacion;
    @Column(name = "FINPENALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finpenalizacion;
    @JoinColumn(name = "CARNETSOCIO", referencedColumnName = "CARNETSOCIO")
    @ManyToOne(optional = false)
    private SocioBiblioteca carnetsocio;
    @JoinColumn(name = "IDPRESTAMO", referencedColumnName = "IDPRESTAMO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prestamo prestamo;

    public Mora() {
    }

    public Mora(MoraPK moraPK) {
        this.moraPK = moraPK;
    }

    public Mora(BigInteger idprestamo, BigInteger idmora) {
        this.moraPK = new MoraPK(idprestamo, idmora);
    }

    public MoraPK getMoraPK() {
        return moraPK;
    }

    public void setMoraPK(MoraPK moraPK) {
        this.moraPK = moraPK;
    }

    public String getTipomora() {
        return tipomora;
    }

    public void setTipomora(String tipomora) {
        this.tipomora = tipomora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getEstadomora() {
        return estadomora;
    }

    public void setEstadomora(BigInteger estadomora) {
        this.estadomora = estadomora;
    }

    public String getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(String penalizacion) {
        this.penalizacion = penalizacion;
    }

    public Date getIniciopenalizacion() {
        return iniciopenalizacion;
    }

    public void setIniciopenalizacion(Date iniciopenalizacion) {
        this.iniciopenalizacion = iniciopenalizacion;
    }

    public Date getFinpenalizacion() {
        return finpenalizacion;
    }

    public void setFinpenalizacion(Date finpenalizacion) {
        this.finpenalizacion = finpenalizacion;
    }

    public SocioBiblioteca getCarnetsocio() {
        return carnetsocio;
    }

    public void setCarnetsocio(SocioBiblioteca carnetsocio) {
        this.carnetsocio = carnetsocio;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moraPK != null ? moraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mora)) {
            return false;
        }
        Mora other = (Mora) object;
        if ((this.moraPK == null && other.moraPK != null) || (this.moraPK != null && !this.moraPK.equals(other.moraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.Mora[ moraPK=" + moraPK + " ]";
    }
    
}
