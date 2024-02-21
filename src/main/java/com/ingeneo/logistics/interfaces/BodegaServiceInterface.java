package com.ingeneo.logistics.interfaces;

import com.ingeneo.logistics.entity.Bodega;
import java.util.List;

public interface BodegaServiceInterface {
    
    List<Bodega> buscarTodasLasBodegas();
    Bodega buscarBodegaPorId(Long id);
    void guardarBodega(Bodega bodega);
    void eliminarBodega(Long id);
    
}
