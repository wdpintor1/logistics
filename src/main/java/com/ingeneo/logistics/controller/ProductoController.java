package com.ingeneo.logistics.controller;

import com.ingeneo.logistics.entity.Producto;
import com.ingeneo.logistics.interfaces.ProductoServiceInterface;
import com.ingeneo.logistics.service.ProductoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    private final ProductoServiceInterface productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<List<Producto>> buscarTodosLosProductos() {
        try {
            List<Producto> productos = productoService.buscarTodosLosProductos();
            if (!productos.isEmpty()) {
                return ResponseEntity.ok(productos);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarProductoPorId(@PathVariable Long id) {
        try {
            Producto producto = productoService.buscarProductoPorId(id);
            if (producto != null) {
                return ResponseEntity.ok(producto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El producto con el ID " + id + " no existe.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al buscar el producto.");
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        try {
            productoService.guardarProducto(producto);
            // Devolver el token en la respuesta
            return ResponseEntity.status(HttpStatus.CREATED).body("Producto creado exitosamente.");
        } catch (Exception e) {
            // Manejo de la excepción: Puedes devolver un mensaje de error adecuado según el tipo de excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el producto: " + e.getMessage());
        }
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        try {
            producto.setIdProducto(id);
            productoService.guardarProducto(producto);
            return ResponseEntity.ok("Producto actualizado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el producto: " + e.getMessage());
        }
    }
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id) {
        try {
            productoService.eliminarProducto(id);
            return ResponseEntity.ok("Producto eliminado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el producto: " + e.getMessage());
        }
    }
}

