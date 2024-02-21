package com.ingeneo.logistics.service;

import com.ingeneo.logistics.entity.Bodega;
import com.ingeneo.logistics.interfaces.BodegaServiceInterface;
import com.ingeneo.logistics.repository.BodegaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BodegaService implements BodegaServiceInterface {

    private final BodegaRepository bodegaRepository;

    @Autowired
    public BodegaService(BodegaRepository bodegaRepository) {
        this.bodegaRepository = bodegaRepository;
    }

    public List<Bodega> buscarTodasLasBodegas() {
        return bodegaRepository.findAll();
    }

    public Bodega buscarBodegaPorId(Long id){
        return bodegaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("bodega no encontrado con ID: " + id));
    }

    public void guardarBodega(Bodega bodega) {
        bodegaRepository.save(bodega);
    }

    public void eliminarBodega(Long id) {
        bodegaRepository.deleteById(id);
    }
}
