/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.entidades;

import java.util.Date;

/**
 *
 * @author Manuel
 */
public class TipoArticulo {
    
    String codigo;
    String autor;
    String titulo;
    String descripcion;
    Float precio;
    String donado;
    String idioma;
    String fecha;

    public TipoArticulo() {
    }

    public TipoArticulo(String codigo, String autor, String titulo, String descripcion, Float precio, String donado, String idioma, String fecha) {
        this.codigo = codigo;
        this.autor = autor;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.donado = donado;
        this.idioma = idioma;
        this.fecha = fecha;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getDonado() {
        return donado;
    }

    public void setDonado(String donado) {
        this.donado = donado;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
  
}
