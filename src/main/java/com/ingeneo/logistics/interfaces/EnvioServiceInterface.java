package com.ingeneo.logistics.interfaces;

import com.ingeneo.logistics.entity.Envio;

import java.util.List;

public interface EnvioServiceInterface {
    List<Envio> buscarTodosLosEnvios();
    Envio buscarEnvioPorId(Long id);
    void guardarEnvio(Envio envio);
    void eliminarEnvio(Long id);
    void setPrecioConDescuento(Envio envio);
}
