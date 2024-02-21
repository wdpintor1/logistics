package com.ingeneo.logistics.repository;

import com.ingeneo.logistics.entity.Envio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {
    String query="SELECT e.idEnvio AS id_envio, e.numeroGuia, p.nombre AS producto " +
       "FROM Envio e JOIN e.producto p";
    @Query(query)
    List<Envio> findAllWithRelatedInfo();
    
}
