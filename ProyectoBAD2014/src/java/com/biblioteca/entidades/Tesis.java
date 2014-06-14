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
@Table(name = "TESIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tesis.findAll", query = "SELECT t FROM Tesis t"),
    @NamedQuery(name = "Tesis.findByCodigo", query = "SELECT t FROM Tesis t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "Tesis.findByAutor", query = "SELECT t FROM Tesis t WHERE t.autor = :autor"),
    @NamedQuery(name = "Tesis.findByTitulo", query = "SELECT t FROM Tesis t WHERE t.titulo = :titulo"),
    @NamedQuery(name = "Tesis.findByDescripcionart", query = "SELECT t FROM Tesis t WHERE t.descripcionart = :descripcionart"),
    @NamedQuery(name = "Tesis.findByPrecio", query = "SELECT t FROM Tesis t WHERE t.precio = :precio"),
    @NamedQuery(name = "Tesis.findByDonado", query = "SELECT t FROM Tesis t WHERE t.donado = :donado"),
    @NamedQuery(name = "Tesis.findByEstado", query = "SELECT t FROM Tesis t WHERE t.estado = :estado"),
    @NamedQuery(name = "Tesis.findByIdioma", query = "SELECT t FROM Tesis t WHERE t.idioma = :idioma"),
    @NamedQuery(name = "Tesis.findByFechaelaboracion", query = "SELECT t FROM Tesis t WHERE t.fechaelaboracion = :fechaelaboracion"),
    @NamedQuery(name = "Tesis.findByCarrera", query = "SELECT t FROM Tesis t WHERE t.carrera = :carrera"),
    @NamedQuery(name = "Tesis.findByFechaadquisicion", query = "SELECT t FROM Tesis t WHERE t.fechaadquisicion = :fechaadquisicion"),
    @NamedQuery(name = "Tesis.findByUniversidad", query = "SELECT t FROM Tesis t WHERE t.universidad = :universidad"),
    @NamedQuery(name = "Tesis.findByNumpaginas", query = "SELECT t FROM Tesis t WHERE t.numpaginas = :numpaginas")})
public class Tesis implements Serializable {
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
    @Column(name = "FECHAELABORACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaelaboracion;
    @Size(max = 30)
    @Column(name = "CARRERA")
    private String carrera;
    @Column(name = "FECHAADQUISICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaadquisicion;
    @Size(max = 40)
    @Column(name = "UNIVERSIDAD")
    private String universidad;
    @Column(name = "NUMPAGINAS")
    private BigInteger numpaginas;
    @JoinColumn(name = "CODIGO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Articulo articulo;

    public Tesis() {
    }

    public Tesis(String codigo) {
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

    public Date getFechaelaboracion() {
        return fechaelaboracion;
    }

    public void setFechaelaboracion(Date fechaelaboracion) {
        this.fechaelaboracion = fechaelaboracion;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Date getFechaadquisicion() {
        return fechaadquisicion;
    }

    public void setFechaadquisicion(Date fechaadquisicion) {
        this.fechaadquisicion = fechaadquisicion;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public BigInteger getNumpaginas() {
        return numpaginas;
    }

    public void setNumpaginas(BigInteger numpaginas) {
        this.numpaginas = numpaginas;
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
        if (!(object instanceof Tesis)) {
            return false;
        }
        Tesis other = (Tesis) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.Tesis[ codigo=" + codigo + " ]";
    }
    
}
