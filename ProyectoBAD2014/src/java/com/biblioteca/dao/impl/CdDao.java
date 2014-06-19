

package com.biblioteca.dao.impl;

import com.biblioteca.entidades.Cd;
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
public class CdDao {

    @PersistenceContext(unitName = "ProyectoBAD2014PU")
    EntityManager em;
    
    /*
    * Funciones de eliminacion de Cd
    *
    */        
    public void eliminarCd(String cod){
        StoredProcedureQuery spq = em.createStoredProcedureQuery("DELETEARTICULO");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.setParameter(1, cod);
        spq.execute();
    }
    
    /*
    * Lista de Libros
    *
    */
     public List<Cd> buscarTodosCd() {
        return em.createNamedQuery("Cd.findAll").getResultList();
    }
}
