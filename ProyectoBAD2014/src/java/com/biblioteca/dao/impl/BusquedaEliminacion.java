/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.dao.impl;

import com.biblioteca.entidades.Libro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Mejia
 */
@Stateless
public class BusquedaEliminacion {
   
    @PersistenceContext(unitName = "ProyectoBAD2014PU")
    EntityManager em;
    
    /*
    * Funciones de busqueda en cada categoria
    *
    */
    
    public Libro buscarLib(String cod){
        Query q = em.createNamedQuery("Libro.findByCodigo");
        q.setParameter("codigo", cod);
        return (Libro) q.getSingleResult();       
    }
    
    
    /*
    * Funciones de eliminacion
    *
    */
    
    public void eliminarLib(String cod){
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("DELETEARTICULO");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.setParameter(1, cod);
        spq.execute();
    }
}
