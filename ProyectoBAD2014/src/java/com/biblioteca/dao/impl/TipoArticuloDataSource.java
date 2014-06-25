/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.dao.impl;

import com.biblioteca.entidades.TipoArticulo;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Manuel
 */
public class TipoArticuloDataSource implements JRDataSource{

    private List<TipoArticulo> listaTipoArticulo = new ArrayList<TipoArticulo>();
    private int indiceParticipanteActual = -1;
    
//    @Override
    public boolean next() throws JRException {
        return ++indiceParticipanteActual<listaTipoArticulo.size();
    }

//    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        
        if("codigo".equals(jrf.getName())){
            valor = listaTipoArticulo.get(indiceParticipanteActual).getCodigo();
        } else if("autor".equals(jrf.getName())){
            valor = listaTipoArticulo.get(indiceParticipanteActual).getAutor();
        } else if("titulo".equals(jrf.getName())){
            valor = listaTipoArticulo.get(indiceParticipanteActual).getTitulo();
        } else if("descripcion".equals(jrf.getName())){
            valor = listaTipoArticulo.get(indiceParticipanteActual).getDescripcion();
        } else if("precio".equals(jrf.getName())){
            valor = listaTipoArticulo.get(indiceParticipanteActual).getPrecio();
        } else if("donado".equals(jrf.getName())){
            valor = listaTipoArticulo.get(indiceParticipanteActual).getDonado();
        } else if("idioma".equals(jrf.getName())){
            valor = listaTipoArticulo.get(indiceParticipanteActual).getIdioma();
        } else if("fecha".equals(jrf.getName())){
            valor = listaTipoArticulo.get(indiceParticipanteActual).getFecha();
        }
        return valor;
    }
    
    public void addTipoArticulo(TipoArticulo articulo){
        this.listaTipoArticulo.add(articulo);
    }
    
}
