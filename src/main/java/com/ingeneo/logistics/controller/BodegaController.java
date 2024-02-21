package com.ingeneo.logistics.controller;

import com.ingeneo.logistics.entity.Bodega;
import com.ingeneo.logistics.interfaces.BodegaServiceInterface;
import com.ingeneo.logistics.service.BodegaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bodegas")
public class BodegaController {

    private final BodegaServiceInterface bodegaService;

    public BodegaController(BodegaService bodegaService) {
        this.bodegaService = bodegaService;
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Bodega>> buscarTodasLasBodegas() {
        List<Bodega> bodegas = bodegaService.buscarTodasLasBodegas();
        return ResponseEntity.ok(bodegas);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Bodega> buscarBodegaPorId(@PathVariable Long id) {
        Bodega bodega = bodegaService.buscarBodegaPorId(id);
        return ResponseEntity.ok(bodega);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearBodega(@Valid @RequestBody Bodega bodega, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        
        bodegaService.guardarBodega(bodega);
        return ResponseEntity.status(HttpStatus.CREATED).body("Bodega guardada exitosamente.");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarBodega(@PathVariable Long id) {
        try {
            bodegaService.eliminarBodega(id);
            return ResponseEntity.ok("Bodega eliminada exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la bodega: " + e.getMessage());
        }
    }

    // Manejo de excepciones de validación
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleValidationExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
