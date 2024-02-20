package com.ingeneo.logistics.interfaces;

import com.ingeneo.logistics.entity.Producto;
import java.util.List;
import javassist.NotFoundException;

public interface ProductoServiceInterface {
    
    List<Producto> buscarTodosLosProductos();

    Producto buscarProductoPorId(Long id);

    void guardarProducto(Producto producto);

    void eliminarProducto(Long id) throws NotFoundException;
    
}
