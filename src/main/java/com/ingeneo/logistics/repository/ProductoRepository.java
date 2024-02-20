
package com.ingeneo.logistics.repository;

import com.ingeneo.logistics.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Aquí puedes agregar métodos adicionales de consulta si es necesario
}
