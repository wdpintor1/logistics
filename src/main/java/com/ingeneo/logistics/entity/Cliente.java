package com.ingeneo.logistics.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "TB_LOGISTICS_CLIENTE")
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String nombre;
    
    @NotBlank(message = "El numero de documento es obligatorio")
    @Pattern(regexp = "\\d{8,10}", message = "El número de documento debe contener entre 8 y 10 dígitos")
    @Column(name = "numero_documento",unique = true)
    private String numeroDocumento;
    
    @NotBlank(message = "El email del cliente es obligatorio")
    @Email(message = "El correo electrónico del cliente no es válido")
    private String email;
    
    @NotBlank(message = "El telefono del cliente es obligatorio")
    @Pattern(regexp = "\\d{7,10}", message = "El número de telefono debe contener de 7 a 10 dígitos")
    private String telefono;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}