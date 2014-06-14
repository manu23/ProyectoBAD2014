
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
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;


@Stateless
public class ArticuloDAOImpl implements ArticuloDAO{

    @PersistenceContext(unitName = "ProyectoBAD2014PU")
    EntityManager em;
    
    
    /*
    *Funciones de insercion de articulos y elementos segun su categoria
    *
    */
    @Override
    public void ingresarArt(Articulo articulo) {
        //em.persist(articulo);
       
        StoredProcedureQuery spq = em.createStoredProcedureQuery("insertArt");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(5, Double.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(6, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(7, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(9, Date.class, ParameterMode.IN);
        
        spq.setParameter(1, articulo.getCodigo());
        spq.setParameter(2, articulo.getAutor());
        spq.setParameter(3, articulo.getTitulo());
        spq.setParameter(4, articulo.getDescripcionart());
        spq.setParameter(5, articulo.getPrecio());
        spq.setParameter(6, articulo.getDonado());
        spq.setParameter(7, articulo.getEstado());
        spq.setParameter(8, articulo.getIdioma());
        spq.setParameter(9, articulo.getFechaadquisicion());
        
        spq.execute();
       
    }
    
    @Override
    public void ingresarLib(Libro libro) {
       //em.persist(libro);
        
        StoredProcedureQuery spq = em.createStoredProcedureQuery("insertlib");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(5, Double.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(6, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(7, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(13, Date.class, ParameterMode.IN);
        
        spq.setParameter(1, libro.getCodigo());
        spq.setParameter(2, libro.getAutor());
        spq.setParameter(3, libro.getTitulo());
        spq.setParameter(4, libro.getDescripcionart());
        spq.setParameter(5, libro.getPrecio());
        spq.setParameter(6, libro.getDonado());
        spq.setParameter(7, libro.getEstado());
        spq.setParameter(8, libro.getIdioma());
        spq.setParameter(9, libro.getCodigoisbn());
        spq.setParameter(10, libro.getEditorial());
        spq.setParameter(11, libro.getAno());
        spq.setParameter(12, libro.getEdicion());
        spq.setParameter(13, libro.getFechaadquisicion());
        
        spq.execute();
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
