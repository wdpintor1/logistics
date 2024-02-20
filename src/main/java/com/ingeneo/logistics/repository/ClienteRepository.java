
package com.ingeneo.logistics.repository;

import com.ingeneo.logistics.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    // Método para buscar un cliente por su nombre
    Cliente findByNombre(String nombre);    
}
