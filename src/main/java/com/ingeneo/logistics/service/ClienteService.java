package com.ingeneo.logistics.service;

import com.ingeneo.logistics.repository.ClienteRepository;
import com.ingeneo.logistics.entity.Cliente;
import com.ingeneo.logistics.interfaces.ClienteServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements ClienteServiceInterface {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
     public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
    }

    public List<Cliente> buscarTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public void crearCliente(Cliente cliente) {
        // Crear una instancia de Cliente con los datos proporcionados       
        cliente.setNombre(cliente.getNombre());
        cliente.setNumeroDocumento(cliente.getNumeroDocumento());
        cliente.setEmail(cliente.getEmail());
        cliente.setTelefono(cliente.getTelefono());

        // Guardar el cliente en la base de datos
        clienteRepository.save(cliente);
    }    

    public void actualizarCliente(Long id, Cliente cliente) {
        cliente.setIdCliente(id);
        clienteRepository.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
