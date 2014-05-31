
package com.biblioteca.dao.impl;

import com.biblioteca.dao.ArticuloDAO;
import com.biblioteca.entidades.Articulo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ArticuloDAOImpl implements ArticuloDAO{

    @PersistenceContext(unitName = "ProyectoBAD2014PU")
    EntityManager em;
    
    @Override
    public void ingresarArt(Articulo articulo) {
        em.persist(articulo);
    }

    @Override
    public List<Articulo> buscarTodos() {
        return em.createNamedQuery("Articulo.findAll").getResultList();
    }

    
}
