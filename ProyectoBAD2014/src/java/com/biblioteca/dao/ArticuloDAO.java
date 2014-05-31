

package com.biblioteca.dao;

import com.biblioteca.entidades.Articulo;
import java.util.List;


public interface ArticuloDAO {
    
    public void ingresarArt(Articulo articulo);
    public List<Articulo> buscarTodos();
}
