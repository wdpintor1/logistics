package com.ingeneo.logistics.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "TB_LOGISTICS_BODEGA")
public class Bodega implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBodega;
    @NotBlank(message = "El nombre de la bodega es obligatorio")
    private String nombre;  
    
    @NotBlank(message = "La direccion de la bodega es obligatoria")
    private String direccion;
    
    @NotBlank(message = "El telefono de la bodega es obligatorio")
    @Pattern(regexp = "\\d{7,10}", message = "El número de telefono debe contener de 7 a 10 dígitos")
    private String telefono;    
    
    private Long capacidad;
    
    private String pais;

    public Long getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Long idBodega) {
        this.idBodega = idBodega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Long capacidad) {
        this.capacidad = capacidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
}