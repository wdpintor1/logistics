package com.ingeneo.logistics.controller;

import com.ingeneo.logistics.entity.Envio;
import com.ingeneo.logistics.interfaces.EnvioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javassist.NotFoundException;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    private final EnvioServiceInterface envioService;

    @Autowired
    public EnvioController(EnvioServiceInterface envioService) {
        this.envioService = envioService;
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Envio>> buscarTodosLosEnvios() {
        List<Envio> envios = envioService.buscarTodosLosEnvios();
        return ResponseEntity.ok(envios);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Envio> buscarEnvioPorId(@PathVariable Long id) {
        try {
            Envio envio = envioService.buscarEnvioPorId(id);
            return ResponseEntity.ok(envio);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearEnvio(@RequestBody Envio envio) {
        try {
            // Guardar el envío en la base de datos
            envioService.guardarEnvio(envio);

            // Calcular y establecer el precio con descuento
            envioService.setPrecioConDescuento(envio);

            // Devolver respuesta exitosa
            return ResponseEntity.status(HttpStatus.CREATED).body("Envío creado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el envío: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarEnvio(@PathVariable Long id) {
        try {
            envioService.eliminarEnvio(id);
            return ResponseEntity.ok("Envío eliminado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el envío: " + e.getMessage());
        }
    }
}
