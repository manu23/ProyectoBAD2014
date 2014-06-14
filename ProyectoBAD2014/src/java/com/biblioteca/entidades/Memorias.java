/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "MEMORIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Memorias.findAll", query = "SELECT m FROM Memorias m"),
    @NamedQuery(name = "Memorias.findByCodigo", query = "SELECT m FROM Memorias m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Memorias.findByAutor", query = "SELECT m FROM Memorias m WHERE m.autor = :autor"),
    @NamedQuery(name = "Memorias.findByTitulo", query = "SELECT m FROM Memorias m WHERE m.titulo = :titulo"),
    @NamedQuery(name = "Memorias.findByDescripcionart", query = "SELECT m FROM Memorias m WHERE m.descripcionart = :descripcionart"),
    @NamedQuery(name = "Memorias.findByPrecio", query = "SELECT m FROM Memorias m WHERE m.precio = :precio"),
    @NamedQuery(name = "Memorias.findByDonado", query = "SELECT m FROM Memorias m WHERE m.donado = :donado"),
    @NamedQuery(name = "Memorias.findByEstado", query = "SELECT m FROM Memorias m WHERE m.estado = :estado"),
    @NamedQuery(name = "Memorias.findByIdioma", query = "SELECT m FROM Memorias m WHERE m.idioma = :idioma"),
    @NamedQuery(name = "Memorias.findByPersonaje", query = "SELECT m FROM Memorias m WHERE m.personaje = :personaje"),
    @NamedQuery(name = "Memorias.findByFechaadquisicion", query = "SELECT m FROM Memorias m WHERE m.fechaadquisicion = :fechaadquisicion"),
    @NamedQuery(name = "Memorias.findByFecreacion", query = "SELECT m FROM Memorias m WHERE m.fecreacion = :fecreacion")})
public class Memorias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CODIGO")
    private String codigo;
    @Size(max = 25)
    @Column(name = "AUTOR")
    private String autor;
    @Size(max = 30)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 50)
    @Column(name = "DESCRIPCIONART")
    private String descripcionart;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private Double precio;
    @Column(name = "DONADO")
    private BigInteger donado;
    @Column(name = "ESTADO")
    private BigInteger estado;
    @Size(max = 10)
    @Column(name = "IDIOMA")
    private String idioma;
    @Size(max = 30)
    @Column(name = "PERSONAJE")
    private String personaje;
    @Column(name = "FECHAADQUISICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaadquisicion;
    @Column(name = "FECREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecreacion;
    @JoinColumn(name = "CODIGO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Articulo articulo;

    public Memorias() {
    }

    public Memorias(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcionart() {
        return descripcionart;
    }

    public void setDescripcionart(String descripcionart) {
        this.descripcionart = descripcionart;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public BigInteger getDonado() {
        return donado;
    }

    public void setDonado(BigInteger donado) {
        this.donado = donado;
    }

    public BigInteger getEstado() {
        return estado;
    }

    public void setEstado(BigInteger estado) {
        this.estado = estado;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public Date getFechaadquisicion() {
        return fechaadquisicion;
    }

    public void setFechaadquisicion(Date fechaadquisicion) {
        this.fechaadquisicion = fechaadquisicion;
    }

    public Date getFecreacion() {
        return fecreacion;
    }

    public void setFecreacion(Date fecreacion) {
        this.fecreacion = fecreacion;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Memorias)) {
            return false;
        }
        Memorias other = (Memorias) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.Memorias[ codigo=" + codigo + " ]";
    }
    
}
