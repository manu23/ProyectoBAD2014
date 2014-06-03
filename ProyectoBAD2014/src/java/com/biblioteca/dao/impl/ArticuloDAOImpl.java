
package com.biblioteca.dao.impl;

import com.biblioteca.dao.ArticuloDAO;
import com.biblioteca.entidades.Articulo;
import com.biblioteca.entidades.Cd;
import com.biblioteca.entidades.Dvd;
import com.biblioteca.entidades.Libro;
import com.biblioteca.entidades.Memorias;
import com.biblioteca.entidades.Obras;
import com.biblioteca.entidades.Periodicos;
import com.biblioteca.entidades.Revista;
import com.biblioteca.entidades.Tesis;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ArticuloDAOImpl implements ArticuloDAO{

    @PersistenceContext(unitName = "ProyectoBAD2014PU")
    EntityManager em;
    
    
    /*
    *Funciones de insercion de articulos y elemntos segun su categoria
    *
    */
    @Override
    public void ingresarArt(Articulo articulo) {
        em.persist(articulo);        
    }
    
    @Override
    public void ingresarLib(Libro libro) {
       em.persist(libro);
    }

    @Override
    public void ingresarRev(Revista revista) {
        em.persist(revista);
    }

    @Override
    public void ingresarCd(Cd cd) {
        em.persist(cd);
    }

    @Override
    public void ingresarDvd(Dvd dvd) {
        em.persist(dvd);
    }

    @Override
    public void ingresarTesis(Tesis tesis) {
        em.persist(tesis);
    }

    @Override
    public void ingresarPeriodicos(Periodicos periodicos) {
        em.persist(periodicos);
    }

    @Override
    public void ingresarObras(Obras obras) {
        em.persist(obras);
    }

    @Override
    public void ingresarMemorias(Memorias memorias) {
        em.persist(memorias);
    }


    /*
    *Funcion que muestra todos los elementos de la tabla articulos
    *
    */
    @Override
    public List<Articulo> buscarTodos() {
        return em.createNamedQuery("Articulo.findAll").getResultList();
    }

    
    
}
