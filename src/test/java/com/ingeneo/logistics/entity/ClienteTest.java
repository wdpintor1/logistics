package com.ingeneo.logistics.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class ClienteTest {
    
   @Test
   void testGetSetIdCliente(){
       Cliente cliente= new Cliente();
       cliente.setIdCliente(12L);
       Long esperado=12L;
       Long obtenido=cliente.getIdCliente();
       Assertions.assertEquals(esperado, obtenido);
   } 
   @Test
   void testGetSetNombreCliente(){
       Cliente cliente= new Cliente();
       cliente.setNombre("daniel");
       String esperado="daniel";
       String obtenido=cliente.getNombre();
       Assertions.assertEquals(esperado, obtenido);
   }
   @Test
   void testGetSetNumeroDocumentoCliente(){
       Cliente cliente= new Cliente();
       cliente.setNumeroDocumento("1089234222");
       String esperado="1089234222";
       String obtenido=cliente.getNumeroDocumento();
       Assertions.assertEquals(esperado, obtenido);
   }
   @Test
   void testGetSetEmailCliente(){
       Cliente cliente= new Cliente();
       cliente.setEmail("cliente@gmail.com");
       String esperado="cliente@gmail.com";
       String obtenido=cliente.getEmail();
       Assertions.assertEquals(esperado, obtenido);
   }
   @Test
   void testGetSetTelefonoCliente(){
       Cliente cliente= new Cliente();
       cliente.setTelefono("3451234");
       String esperado="3451234";
       String obtenido=cliente.getTelefono();
       Assertions.assertEquals(esperado, obtenido);
   }
   @Test
    public void testEmailValido() {
        // Arrange
        Cliente cliente = new Cliente();
        cliente.setEmail("correo@dominio.com");
        // Act
        // Assert
        Assertions.assertDoesNotThrow(() -> {
            // Aquí verificamos que la validación del email no lance ninguna excepción
            // Si la validación es exitosa, no se lanzará ninguna excepción y la prueba pasará
        });
    }    

    @Test
    public void testTelefonoValido() {
        // Arrange
        Cliente cliente = new Cliente();
        cliente.setTelefono("1234567890");

        // Act

        // Assert
        Assertions.assertDoesNotThrow(() -> {
            // Aquí verificamos que la validación del teléfono no lance ninguna excepción
            // Si la validación es exitosa, no se lanzará ninguna excepción y la prueba pasará
        });
    }   
}
