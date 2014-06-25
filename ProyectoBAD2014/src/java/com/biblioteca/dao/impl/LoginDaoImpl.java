/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.dao.impl;

import com.biblioteca.entidades.UsuarioSistema;
import java.util.List;
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
public class LoginDaoImpl {

    @PersistenceContext(unitName = "ProyectoBAD2014PU")
    EntityManager em;
    
    public boolean login(UsuarioSistema usuario){
        long total;
        Query q = em.createNamedQuery("UsuarioSistema.findByLogin");
        q.setParameter("idusuario", usuario.getIdusuario());
        q.setParameter("pass", usuario.getPass());
        total =  (long) q.getSingleResult();
        if(total == 1)
            return true;
        else
            return false;
        }        
    
    public  List<UsuarioSistema> ListarUsuarios(){
        return em.createNamedQuery("UsuarioSistema.findAll").getResultList();
    }
    
    /*
   * Elimina un socio de la Base de datos
   */
   public void eliminarUsuario(String cod){
        StoredProcedureQuery spq = em.createStoredProcedureQuery("DELETEUSSIST");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.setParameter(1, cod);
        spq.execute();
    }
}

