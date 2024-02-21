package com.ingeneo.logistics.repository;

import com.ingeneo.logistics.entity.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {
    // Aquí puedes agregar métodos adicionales de consulta si es necesario
}
