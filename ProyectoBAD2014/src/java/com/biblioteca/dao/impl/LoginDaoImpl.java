/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.dao.impl;

import com.biblioteca.entidades.UsuarioSistema;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
}

