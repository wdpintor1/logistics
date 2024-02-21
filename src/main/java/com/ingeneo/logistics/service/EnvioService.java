package com.ingeneo.logistics.service;

import com.ingeneo.logistics.entity.Envio;
import com.ingeneo.logistics.interfaces.EnvioServiceInterface;
import com.ingeneo.logistics.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnvioService implements EnvioServiceInterface {

    private final EnvioRepository envioRepository;

    @Autowired
    public EnvioService(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    @Override
    public List<Envio> buscarTodosLosEnvios() {
        return envioRepository.findAll();
    }
    
    @Override
    public List<Envio> buscarTodosLosEnviosConInformacionRelacionada() {
        return envioRepository.findAllWithRelatedInfo();
    }

    @Override
    public Envio buscarEnvioPorId(Long id) {
        System.out.println("buscando envio...");
        Optional<Envio> envioOptional = envioRepository.findById(id);
        return envioOptional.orElse(null);
    }

    @Override
    public void guardarEnvio(Envio envio) {
        envioRepository.save(envio);
    }

    @Override
    public void eliminarEnvio(Long id) {
        envioRepository.deleteById(id);
    }
    
    public void setPrecioConDescuento(Envio envio) {
        // Verificar si se aplica descuento
        if (envio.getCantidadProducto() > 10) {
            // Calcular descuento según el tipo de envío
            double descuento = 0;            
            if (envio.getTipoEnvio()==1) {
                descuento = envio.getPrecio() * 0.05; // Descuento del 5% para logística terrestre
            } else if (envio.getTipoEnvio()==2) {
                descuento = envio.getPrecio() * 0.03; // Descuento del 3% para logística marítima
            }

            // Aplicar descuento al precio de envío
            double precioConDescuento = envio.getPrecio() - descuento;
            envio.setPrecio(precioConDescuento);
        }
    }
}
