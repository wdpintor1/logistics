
package com.ingeneo.logistics.interfaces;

import com.ingeneo.logistics.entity.Cliente;
import java.util.List;

public interface ClienteServiceInterface {
    
     void crearCliente(Cliente cliente);
    
    Cliente buscarClientePorId(Long id);
    
    List<Cliente> buscarTodosLosClientes();
    
    void actualizarCliente(Long id, Cliente cliente);
    
    void eliminarCliente(Long id);
}
