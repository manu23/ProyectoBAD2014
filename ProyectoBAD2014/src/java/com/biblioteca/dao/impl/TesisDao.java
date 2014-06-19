/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.dao.impl;

import com.biblioteca.entidades.Tesis;
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
public class TesisDao {

    @PersistenceContext(unitName = "ProyectoBAD2014PU")
    EntityManager em;
    
    /*
    * Funciones de eliminacion de Tesis
    *
    */  
    
     public void eliminarTesis(String cod){
        StoredProcedureQuery spq = em.createStoredProcedureQuery("DELETEARTICULO");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.setParameter(1, cod);
        spq.execute();
    }
    
    /*
    * Lista de Tesis
    *
    */
     public List<Tesis> buscarTodosTesis() {
        return em.createNamedQuery("Tesis.findAll").getResultList();
    }
}
