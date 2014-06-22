

package com.biblioteca.dao;

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


public interface ArticuloDAO {
    
    public void ingresarArt(Articulo articulo);
    public void ingresarLib(Libro libro);
    public void ingresarRev(Revista revista);
    public void ingresarCd(Cd cd);
    public void ingresarDvd(Dvd dvd);
    public void ingresarTesis(Tesis tesis);
    public void ingresarPeriodicos(Periodicos periodicos);
    public void ingresarObras(Obras obras);
    public void ingresarMemorias(Memorias memorias);
    public List<Articulo> buscarTodos();
    public List<Libro> buscarTodosLib();
    public List<Revista> buscarTodosRev();
    public List<Cd> buscarTodosCd();
    public List<Dvd> buscarTodosDvd();
    public List<Tesis> buscarTodostesis();
    public List<Periodicos> buscarTodosPer();
    public List<Obras> buscarTodosObras();
    public List<Memorias> buscarTodosMem();
    public void eliminarArt(String cod);
}
