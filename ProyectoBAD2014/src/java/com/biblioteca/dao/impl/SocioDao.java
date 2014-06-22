

package com.biblioteca.dao.impl;

import com.biblioteca.entidades.Docente;
import com.biblioteca.entidades.Estudiante;
import com.biblioteca.entidades.Externo;
import com.biblioteca.entidades.SocioBiblioteca;
import java.util.Date;
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
public class SocioDao {

   @PersistenceContext(unitName = "ProyectoBAD2014PU")
   EntityManager em;
   
   public void ingresarSocio(SocioBiblioteca socio){
       
       StoredProcedureQuery spq = em.createStoredProcedureQuery("insertSocio");
       spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(9, Date.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
       
       spq.setParameter(1, socio.getCarnetsocio());
       spq.setParameter(2, socio.getPrimernombre());
       spq.setParameter(3, socio.getSegundonombre());
       spq.setParameter(4, socio.getPrimerapellido());
       spq.setParameter(5, socio.getSegundoapellido());
       spq.setParameter(6, socio.getDireccion());
       spq.setParameter(7, socio.getTelefono());
       spq.setParameter(8, socio.getDui());
       spq.setParameter(9, socio.getFecingreso());
       spq.setParameter(10, socio.getEmail());
       
       spq.execute();
   }
   
   public void ingresarDocente(Docente docente){
       
       StoredProcedureQuery spq = em.createStoredProcedureQuery("insertDocente");
       spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(9, Date.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
       
       spq.setParameter(1, docente.getDocentePK().getCarnetsocio());
       spq.setParameter(2, docente.getDocentePK().getCarnetdocente());
       spq.setParameter(3, docente.getPrimernombre());
       spq.setParameter(4, docente.getSegundonombre());
       spq.setParameter(5, docente.getPrimerapellido());
       spq.setParameter(6, docente.getSegundoapellido());
       spq.setParameter(7, docente.getDireccion());
       spq.setParameter(8, docente.getTelefono());
       spq.setParameter(9, docente.getDui());
       spq.setParameter(10, docente.getFecingreso());
       spq.setParameter(11, docente.getEmail());
       spq.setParameter(12, docente.getInstitucion());
       spq.setParameter(13, docente.getEscuela());
       
       spq.execute();
   }
   
   public void ingresarEstudiante(Estudiante estudiante){
       
       StoredProcedureQuery spq = em.createStoredProcedureQuery("insertEstudiante");
       spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(9, Date.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
       
       spq.setParameter(1, estudiante.getEstudiantePK().getCarnetsocio());
       spq.setParameter(2, estudiante.getEstudiantePK().getCarnetestudiante());
       spq.setParameter(3, estudiante.getPrimernombre());
       spq.setParameter(4, estudiante.getSegundonombre());
       spq.setParameter(5, estudiante.getPrimerapellido());
       spq.setParameter(6, estudiante.getSegundoapellido());
       spq.setParameter(7, estudiante.getDireccion());
       spq.setParameter(8, estudiante.getTelefono());
       spq.setParameter(9, estudiante.getDui());
       spq.setParameter(10, estudiante.getFecingreso());
       spq.setParameter(11, estudiante.getEmail());
       spq.setParameter(12, estudiante.getFacultad());
       spq.setParameter(13, estudiante.getCarrera());
       
       spq.execute();
   }
   
    public void ingresarExterno(Externo externo){
       
       StoredProcedureQuery spq = em.createStoredProcedureQuery("insertExterno");
       spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(9, Date.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(11, String.class, ParameterMode.IN);
       spq.registerStoredProcedureParameter(12, String.class, ParameterMode.IN);
       
       spq.setParameter(1, externo.getCarnetsocio());
       spq.setParameter(2, externo.getPrimernombre());
       spq.setParameter(3, externo.getSegundonombre());
       spq.setParameter(4, externo.getPrimerapellido());
       spq.setParameter(5, externo.getSegundoapellido());
       spq.setParameter(6, externo.getDireccion());
       spq.setParameter(7, externo.getTelefono());
       spq.setParameter(8, externo.getDui());
       spq.setParameter(9, externo.getFecingreso());
       spq.setParameter(10, externo.getEmail());
       spq.setParameter(11, externo.getNit());
       spq.setParameter(12, externo.getCarnetminoridad());
       
       spq.execute();
   }
    
   public List<SocioBiblioteca> buscarTodos() {
        return em.createNamedQuery("SocioBiblioteca.findAll").getResultList();
    } 
}
