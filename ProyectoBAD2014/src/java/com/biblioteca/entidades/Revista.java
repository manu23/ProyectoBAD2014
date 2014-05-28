/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mejia
 */
@Entity
@Table(name = "REVISTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revista.findAll", query = "SELECT r FROM Revista r"),
    @NamedQuery(name = "Revista.findByCodigo", query = "SELECT r FROM Revista r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "Revista.findByAutor", query = "SELECT r FROM Revista r WHERE r.autor = :autor"),
    @NamedQuery(name = "Revista.findByTitulo", query = "SELECT r FROM Revista r WHERE r.titulo = :titulo"),
    @NamedQuery(name = "Revista.findByDescripcionart", query = "SELECT r FROM Revista r WHERE r.descripcionart = :descripcionart"),
    @NamedQuery(name = "Revista.findByPrecio", query = "SELECT r FROM Revista r WHERE r.precio = :precio"),
    @NamedQuery(name = "Revista.findByDonado", query = "SELECT r FROM Revista r WHERE r.donado = :donado"),
    @NamedQuery(name = "Revista.findByEstado", query = "SELECT r FROM Revista r WHERE r.estado = :estado"),
    @NamedQuery(name = "Revista.findByIdioma", query = "SELECT r FROM Revista r WHERE r.idioma = :idioma"),
    @NamedQuery(name = "Revista.findByCodigoissn", query = "SELECT r FROM Revista r WHERE r.codigoissn = :codigoissn"),
    @NamedQuery(name = "Revista.findByEdicionrev", query = "SELECT r FROM Revista r WHERE r.edicionrev = :edicionrev"),
    @NamedQuery(name = "Revista.findByTiporev", query = "SELECT r FROM Revista r WHERE r.tiporev = :tiporev")})
public class Revista implements Serializable {
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
    @Column(name = "CODIGOISSN")
    private String codigoissn;
    @Size(max = 10)
    @Column(name = "EDICIONREV")
    private String edicionrev;
    @Size(max = 10)
    @Column(name = "TIPOREV")
    private String tiporev;
    @JoinColumn(name = "CODIGO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Articulo articulo;

    public Revista() {
    }

    public Revista(String codigo) {
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

    public String getCodigoissn() {
        return codigoissn;
    }

    public void setCodigoissn(String codigoissn) {
        this.codigoissn = codigoissn;
    }

    public String getEdicionrev() {
        return edicionrev;
    }

    public void setEdicionrev(String edicionrev) {
        this.edicionrev = edicionrev;
    }

    public String getTiporev() {
        return tiporev;
    }

    public void setTiporev(String tiporev) {
        this.tiporev = tiporev;
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
        if (!(object instanceof Revista)) {
            return false;
        }
        Revista other = (Revista) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.biblioteca.entidades.Revista[ codigo=" + codigo + " ]";
    }
    
}
