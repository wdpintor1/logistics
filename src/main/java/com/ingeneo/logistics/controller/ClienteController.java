package com.ingeneo.logistics.controller;

import com.ingeneo.logistics.entity.Cliente;
import com.ingeneo.logistics.service.ClienteService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodosLosClientes() {
        try {
            List<Cliente> clientes = clienteService.buscarTodosLosClientes();
            if (!clientes.isEmpty()) {
                return ResponseEntity.ok(clientes);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.buscarClientePorId(id);
            if (cliente != null) {
                return ResponseEntity.ok(cliente);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente con el ID " + id + " no existe");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar el cliente: " + e.getMessage());
        }
    }
    
    @PostMapping("/crear")
    public ResponseEntity<String> crearCliente(@Valid @RequestBody Cliente cliente) {
        try {
            clienteService.crearCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el cliente: " + e.getMessage());
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        try {
            clienteService.actualizarCliente(id, cliente);
            return ResponseEntity.ok("Cliente actualizado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el cliente: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Long id) {
        try {
            clienteService.eliminarCliente(id);
            return ResponseEntity.ok("Cliente eliminado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el cliente: " + e.getMessage());
        }
    }
}
