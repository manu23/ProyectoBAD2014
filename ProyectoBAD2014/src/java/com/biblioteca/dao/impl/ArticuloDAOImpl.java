
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
        //em.persist(revista);
        
        StoredProcedureQuery spq = em.createStoredProcedureQuery("INSERTREV");
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
        spq.registerStoredProcedureParameter(12, Date.class, ParameterMode.IN);      
        spq.registerStoredProcedureParameter(13, Date.class, ParameterMode.IN);
        
        spq.setParameter(1, revista.getCodigo());
        spq.setParameter(2, revista.getAutor());
        spq.setParameter(3, revista.getTitulo());
        spq.setParameter(4, revista.getDescripcionart());
        spq.setParameter(5, revista.getPrecio());
        spq.setParameter(6, revista.getDonado());
        spq.setParameter(7, revista.getEstado());
        spq.setParameter(8, revista.getIdioma());
        spq.setParameter(9, revista.getCodigoissn());
        spq.setParameter(10, revista.getEdicionrev());
        spq.setParameter(11, revista.getTiporev());
        spq.setParameter(12, revista.getFechaadquisicion());
        spq.setParameter(13, revista.getFecpublicacion());
        
        spq.execute();
        
    }

    @Override
    public void ingresarCd(Cd cd) {
        //em.persist(cd);
        StoredProcedureQuery spq = em.createStoredProcedureQuery("INSERTCD");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(5, Double.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(6, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(7, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(9, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);     
        spq.registerStoredProcedureParameter(11, Date.class, ParameterMode.IN);
        
        spq.setParameter(1, cd.getCodigo());
        spq.setParameter(2, cd.getAutor());
        spq.setParameter(3, cd.getTitulo());
        spq.setParameter(4, cd.getDescripcionart());
        spq.setParameter(5, cd.getPrecio());
        spq.setParameter(6, cd.getDonado());
        spq.setParameter(7, cd.getEstado());
        spq.setParameter(8, cd.getIdioma());
        spq.setParameter(9, cd.getNumpista());
        spq.setParameter(10, cd.getGenero());
        spq.setParameter(11, cd.getFechaadquisicion());
        
        spq.execute();
        
    }

    @Override
    public void ingresarDvd(Dvd dvd) {
        //em.persist(dvd);
        StoredProcedureQuery spq = em.createStoredProcedureQuery("INSERTDVD");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(5, Double.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(6, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(7, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(10, Date.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);    
        
        spq.setParameter(1, dvd.getCodigo());
        spq.setParameter(2, dvd.getAutor());
        spq.setParameter(3, dvd.getTitulo());
        spq.setParameter(4, dvd.getDescripcionart());
        spq.setParameter(5, dvd.getPrecio());
        spq.setParameter(6, dvd.getDonado());
        spq.setParameter(7, dvd.getEstado());
        spq.setParameter(8, dvd.getIdioma());
        spq.setParameter(9, dvd.getDuracion());
        spq.setParameter(10, dvd.getFechaadquisicion());
        spq.setParameter(11, dvd.getTipoinfo());
        
        spq.execute();
        
    }

    @Override
    public void ingresarTesis(Tesis tesis) {
        //em.persist(tesis);
        StoredProcedureQuery spq = em.createStoredProcedureQuery("INSERTTESIS");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(5, Double.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(6, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(7, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(9, Date.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(11, Date.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(13, BigInteger.class, ParameterMode.IN);
        
        spq.setParameter(1, tesis.getCodigo());
        spq.setParameter(2, tesis.getAutor());
        spq.setParameter(3, tesis.getTitulo());
        spq.setParameter(4, tesis.getDescripcionart());
        spq.setParameter(5, tesis.getPrecio());
        spq.setParameter(6, tesis.getDonado());
        spq.setParameter(7, tesis.getEstado());
        spq.setParameter(8, tesis.getIdioma());
        spq.setParameter(9, tesis.getFechaelaboracion());
        spq.setParameter(10, tesis.getCarrera());
        spq.setParameter(11, tesis.getFechaadquisicion());
        spq.setParameter(12, tesis.getUniversidad());
        spq.setParameter(13, tesis.getNumpaginas());
        
        spq.execute();
    }

    @Override
    public void ingresarPeriodicos(Periodicos periodicos) {
        //em.persist(periodicos);
        StoredProcedureQuery spq = em.createStoredProcedureQuery("INSERTPERIODICOS");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(5, Double.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(6, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(7, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(9, Date.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(10, Date.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
        
        spq.setParameter(1, periodicos.getCodigo());
        spq.setParameter(2, periodicos.getAutor());
        spq.setParameter(3, periodicos.getTitulo());
        spq.setParameter(4, periodicos.getDescripcionart());
        spq.setParameter(5, periodicos.getPrecio());
        spq.setParameter(6, periodicos.getDonado());
        spq.setParameter(7, periodicos.getEstado());
        spq.setParameter(8, periodicos.getIdioma());
        spq.setParameter(9, periodicos.getFechapublicacion());
        spq.setParameter(10, periodicos.getFechaadquisicion());
        spq.setParameter(11, periodicos.getPaispublicacion());
        
        spq.execute();

    }

    @Override
    public void ingresarObras(Obras obras) {
        //em.persist(obras);
        StoredProcedureQuery spq = em.createStoredProcedureQuery("INSERTOBRAS");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(5, Double.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(6, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(7, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(9, Date.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(10, Date.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
        
        spq.setParameter(1, obras.getCodigo());
        spq.setParameter(2, obras.getAutor());
        spq.setParameter(3, obras.getTitulo());
        spq.setParameter(4, obras.getDescripcionart());
        spq.setParameter(5, obras.getPrecio());
        spq.setParameter(6, obras.getDonado());
        spq.setParameter(7, obras.getEstado());
        spq.setParameter(8, obras.getIdioma());
        spq.setParameter(9, obras.getFechacreacion());
        spq.setParameter(10, obras.getFechaadquisicion());
        spq.setParameter(11, obras.getTipoobra());
        
        spq.execute();
        
    }

    @Override
    public void ingresarMemorias(Memorias memorias) {
        //em.persist(memorias);
        StoredProcedureQuery spq = em.createStoredProcedureQuery("INSERTMEMORIAS");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(5, Double.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(6, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(7, BigInteger.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(10, Date.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(11, Date.class, ParameterMode.IN);
        
        spq.setParameter(1, memorias.getCodigo());
        spq.setParameter(2, memorias.getAutor());
        spq.setParameter(3, memorias.getTitulo());
        spq.setParameter(4, memorias.getDescripcionart());
        spq.setParameter(5, memorias.getPrecio());
        spq.setParameter(6, memorias.getDonado());
        spq.setParameter(7, memorias.getEstado());
        spq.setParameter(8, memorias.getIdioma());
        spq.setParameter(9, memorias.getPersonaje());
        spq.setParameter(10, memorias.getFechaadquisicion());
        spq.setParameter(11, memorias.getFecreacion());
        
        spq.execute();
    }
    
    @Override
    public void eliminarArt(String cod){
        StoredProcedureQuery spq = em.createStoredProcedureQuery("DELETEARTICULO");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.setParameter(1, cod);
        spq.execute();
    }
    


    /*
    *Funcion que muestra todos los elementos de la tabla articulos
    *
    */
    @Override
    public List<Articulo> buscarTodos() {
        return em.createNamedQuery("Articulo.findAll").getResultList();
    }
    
    @Override
    public List<Libro> buscarTodosLib() {
        return em.createNamedQuery("Libro.findAll").getResultList();
    }
    
    @Override
    public List<Revista> buscarTodosRev() {
        return em.createNamedQuery("Revista.findAll").getResultList();
    }
    
    @Override
    public List<Cd> buscarTodosCd() {
        return em.createNamedQuery("Cd.findAll").getResultList();
    }
    
    @Override
    public List<Dvd> buscarTodosDvd() {
        return em.createNamedQuery("Dvd.findAll").getResultList();
    }
    
    @Override
    public List<Tesis> buscarTodostesis() {
        return em.createNamedQuery("Tesis.findAll").getResultList();
    }
    
    @Override
    public List<Periodicos> buscarTodosPer() {
        return em.createNamedQuery("Periodicos.findAll").getResultList();
    }
    
    @Override
    public List<Obras> buscarTodosObras() {
        return em.createNamedQuery("Obras.findAll").getResultList();
    }

    @Override
    public List<Memorias> buscarTodosMem() {
        return em.createNamedQuery("Memorias.findAll").getResultList();
    }
    
}
