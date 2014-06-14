/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "ARTICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a"),
    @NamedQuery(name = "Articulo.findByCodigo", query = "SELECT a FROM Articulo a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Articulo.findByAutor", query = "SELECT a FROM Articulo a WHERE a.autor = :autor"),
    @NamedQuery(name = "Articulo.findByTitulo", query = "SELECT a FROM Articulo a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Articulo.findByDescripcionart", query = "SELECT a FROM Articulo a WHERE a.descripcionart = :descripcionart"),
    @NamedQuery(name = "Articulo.findByPrecio", query = "SELECT a FROM Articulo a WHERE a.precio = :precio"),
    @NamedQuery(name = "Articulo.findByDonado", query = "SELECT a FROM Articulo a WHERE a.donado = :donado"),
    @NamedQuery(name = "Articulo.findByEstado", query = "SELECT a FROM Articulo a WHERE a.estado = :estado"),
    @NamedQuery(name = "Articulo.findByIdioma", query = "SELECT a FROM Articulo a WHERE a.idioma = :idioma"),
    @NamedQuery(name = "Articulo.findByFechaadquisicion", query = "SELECT a FROM Articulo a WHERE a.fechaadquisicion = :fechaadquisicion")})
public class Articulo implements Serializable {
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
    @Column(name = "FECHAADQUISICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaadquisicion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "articulo")
    private Memorias memorias;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "articulo")
    private Libro libro;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "articulo")
    private Obras obras;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "articulo")
    private Dvd dvd;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "articulo")
    private Cd cd;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "articulo")
    private Periodicos periodicos;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "articulo")
    private Tesis tesis;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "articulo")
    private Revista revista;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigo")
    private List<Prestamo> prestamoList;

    public Articulo() {
    }

    public Articulo(String codigo) {
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

    public Date getFechaadquisicion() {
        return fechaadquisicion;
    }

    public void setFechaadquisicion(Date fechaadquisicion) {
        this.fechaadquisicion = fechaadquisicion;
    }

    public Memorias getMemorias() {
        return memorias;
    }

    public void setMemorias(Memorias memorias) {
        this.memorias = memorias;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Obras getObras() {
        return obras;
    }

    public void setObras(Obras obras) {
        this.obras = obras;
    }

    public Dvd getDvd() {
        return dvd;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }

    public Cd getCd() {
        return cd;
    }

    public void setCd(Cd cd) {
        this.cd = cd;
    }

    public Periodicos getPeriodicos() {
        return periodicos;
    }

    public void setPeriodicos(Periodicos periodicos) {
        this.periodicos = periodicos;
    }

    public Tesis getTesis() {
        return tesis;
    }

    public void setTesis(Tesis tesis) {
        this.tesis = tesis;
    }

    public Revista getRevista() {
        return revista;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.Articulo[ codigo=" + codigo + " ]";
    }
    
}
