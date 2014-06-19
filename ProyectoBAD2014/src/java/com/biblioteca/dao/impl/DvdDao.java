/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.dao.impl;

import com.biblioteca.entidades.Dvd;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Mejia
 */
@Stateless
public class DvdDao {

    @PersistenceContext(unitName = "ProyectoBAD2014PU")
    EntityManager em;
    
    /*
    * Funciones de eliminacion de Dvd
    *
    */  
    
     public void eliminarDvd(String cod){
        StoredProcedureQuery spq = em.createStoredProcedureQuery("DELETEARTICULO");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.setParameter(1, cod);
        spq.execute();
    }
    
    /*
    * Lista de Libros
    *
    */
     public List<Dvd> buscarTodosDvd() {
        return em.createNamedQuery("Dvd.findAll").getResultList();
    }
}
