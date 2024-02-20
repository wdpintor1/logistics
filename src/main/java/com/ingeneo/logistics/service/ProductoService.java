package com.ingeneo.logistics.service;

import com.ingeneo.logistics.repository.ProductoRepository;
import com.ingeneo.logistics.entity.Producto;
import com.ingeneo.logistics.interfaces.ProductoServiceInterface;
import java.util.List;
import java.util.Optional;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements ProductoServiceInterface {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    
    public List<Producto> buscarTodosLosProductos() {
        return productoRepository.findAll();
    }
    
    public Producto buscarProductoPorId(Long id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        return productoOptional.orElse(null);
    }

   public void guardarProducto(Producto producto) {
        if (producto.getIdProducto() != null) {
            // Si el ID del producto está asignado, es una operación de actualización
            Producto productoExistente = productoRepository.findById(producto.getIdProducto())
                    .orElseThrow(() -> new RuntimeException("No se encontró el producto con ID: " + producto.getIdProducto()));
            // Actualizar los campos del producto existente con los valores del producto pasado
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setTipoId(producto.getTipoId());
            productoExistente.setCantidadStock(producto.getCantidadStock());

            // Guardar el producto actualizado en la base de datos
            productoRepository.saveAndFlush(productoExistente);
        } else {
            // Si el ID del producto no está asignado, es una operación de guardar
            // No es necesario asignar el ID ya que Spring Data JPA se encargará de eso al guardar
            productoRepository.save(producto);
        }
    }
    
    public void eliminarProducto(Long id) throws NotFoundException {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            productoRepository.deleteById(id);
        } else {
            throw new NotFoundException("Producto no encontrado con ID: " + id);
        }
    }
}
