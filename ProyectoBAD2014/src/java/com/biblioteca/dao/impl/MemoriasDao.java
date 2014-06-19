/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.dao.impl;

import com.biblioteca.entidades.Memorias;
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
public class MemoriasDao {

    @PersistenceContext(unitName = "ProyectoBAD2014PU")
    EntityManager em;
    
    /*
    * Funciones de eliminacion de Memorias
    *
    */        
    public void eliminarMemorias(String cod){
        StoredProcedureQuery spq = em.createStoredProcedureQuery("DELETEARTICULO");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.setParameter(1, cod);
        spq.execute();
    }
    
    /*
    * Lista de Memorias
    *
    */
     public List<Memorias> buscarTodosMemorias() {
        return em.createNamedQuery("Memorias.findAll").getResultList();
    }
    
}
