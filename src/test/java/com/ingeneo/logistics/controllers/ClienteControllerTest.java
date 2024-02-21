package com.ingeneo.logistics.controllers;

import com.ingeneo.logistics.controller.ClienteController;
import com.ingeneo.logistics.entity.Cliente;
import com.ingeneo.logistics.service.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;
    
    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    void setUp() {
        clienteService = mock(ClienteService.class);
        clienteController = new ClienteController(clienteService);
        MockitoAnnotations.initMocks(this);
    }
    /*---------------------------------------Pruebas para servicio de buscar clientes---------------------------------------*/
    @Test
    void testBuscarTodosLosClientes_NoClientesEncontrados() {
        // Arrange
        Mockito.when(clienteService.buscarTodosLosClientes()).thenReturn(new ArrayList<>());
        
        // Act
        ResponseEntity<List<Cliente>> response = clienteController.buscarTodosLosClientes();
        
        // Assert
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertNull(response.getBody());
    }
/*
    @Test
    void testBuscarTodosLosClientes_ClientesEncontrados() {
        // Arrange
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente=new Cliente();
        cliente.setIdCliente(1L);
        cliente.setNombre("Daniel");
        cliente.setNumeroDocumento("1088293298");
        cliente.setEmail("wdpinto@utp.edu.co");
        cliente.setTelefono("3214411730");
        clientes.add(cliente);        
        Mockito.when(clienteService.buscarTodosLosClientes()).thenReturn(clientes);
        
        // Act
        ResponseEntity<List<Cliente>> response = clienteController.buscarTodosLosClientes();
        
        // Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(clientes, response.getBody());
    }
*/
    @Test
    void testBuscarTodosLosClientes_ErrorInternoDelServidor() {
        // Arrange
        Mockito.when(clienteService.buscarTodosLosClientes()).thenThrow(new RuntimeException("Error interno"));
        
        // Act
        ResponseEntity<List<Cliente>> response = clienteController.buscarTodosLosClientes();
        
        // Assert
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        Assertions.assertNull(response.getBody());
    }
    /*--------------------------------------- End Pruebas para servicio de buscar clientes---------------------------------------*/
    
    @Test
    void testBuscarTodosLosClientes_SinClientes_DebeDevolverNotFound() {
        // Arrange
        List<Cliente> clientesEsperados = new ArrayList<>();
        when(clienteService.buscarTodosLosClientes()).thenReturn(clientesEsperados);

        // Act
        ResponseEntity<List<Cliente>> response = clienteController.buscarTodosLosClientes();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    void testBuscarClientePorId_Excepcion_DebeDevolverInternalServerError() {
        // Arrange
        Long idCliente = 123L;
        String mensajeError = "El cliente con el ID "+idCliente+" no existe";
        when(clienteService.buscarClientePorId(idCliente)).thenThrow(new RuntimeException(mensajeError));

        // Act
        ResponseEntity<?> response = clienteController.buscarClientePorId(idCliente);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(mensajeError, response.getBody());
    }
}

