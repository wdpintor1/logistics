package com.ingeneo.logistics.repository;

import com.ingeneo.logistics.entity.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Long> {
    // Aquí puedes agregar métodos adicionales de consulta si es necesario
}
