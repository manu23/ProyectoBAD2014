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
import javax.persistence.Lob;
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
@Table(name = "LIBRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByCodigo", query = "SELECT l FROM Libro l WHERE l.codigo = :codigo"),
    @NamedQuery(name = "Libro.findByAutor", query = "SELECT l FROM Libro l WHERE l.autor = :autor"),
    @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libro.findByDescripcionart", query = "SELECT l FROM Libro l WHERE l.descripcionart = :descripcionart"),
    @NamedQuery(name = "Libro.findByPrecio", query = "SELECT l FROM Libro l WHERE l.precio = :precio"),
    @NamedQuery(name = "Libro.findByDonado", query = "SELECT l FROM Libro l WHERE l.donado = :donado"),
    @NamedQuery(name = "Libro.findByEstado", query = "SELECT l FROM Libro l WHERE l.estado = :estado"),
    @NamedQuery(name = "Libro.findByIdioma", query = "SELECT l FROM Libro l WHERE l.idioma = :idioma"),
    @NamedQuery(name = "Libro.findByCodigoisbn", query = "SELECT l FROM Libro l WHERE l.codigoisbn = :codigoisbn"),
    @NamedQuery(name = "Libro.findByEditorial", query = "SELECT l FROM Libro l WHERE l.editorial = :editorial"),
    @NamedQuery(name = "Libro.findByAno", query = "SELECT l FROM Libro l WHERE l.ano = :ano"),
    @NamedQuery(name = "Libro.findByEdicion", query = "SELECT l FROM Libro l WHERE l.edicion = :edicion")})
public class Libro implements Serializable {
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
    @Lob
    @Column(name = "LOGO")
    private Serializable logo;
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
    @Size(max = 10)
    @Column(name = "CODIGOISBN")
    private String codigoisbn;
    @Size(max = 30)
    @Column(name = "EDITORIAL")
    private String editorial;
    @Column(name = "ANO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ano;
    @Size(max = 10)
    @Column(name = "EDICION")
    private String edicion;
    @JoinColumn(name = "CODIGO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Articulo articulo;

    public Libro() {
    }

    public Libro(String codigo) {
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

    public Serializable getLogo() {
        return logo;
    }

    public void setLogo(Serializable logo) {
        this.logo = logo;
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

    public String getCodigoisbn() {
        return codigoisbn;
    }

    public void setCodigoisbn(String codigoisbn) {
        this.codigoisbn = codigoisbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
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
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.Libro[ codigo=" + codigo + " ]";
    }
    
}
