package com.ingeneo.logistics.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "TB_LOGISTICS_BODEGA")
public class Bodega implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBodega;   

    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String nombre;
    
    @NotBlank(message = "El direccion del cliente es obligatorio")
    private String direccion;
    
    @Pattern(regexp = "\\d{7,10}", message = "El número de telefono debe contener de 7 a 10 dígitos")
    private String telefono;
    
    private String capacidad;
    
    @NotBlank(message = "El pais del cliente es obligatorio")
    private String pais;
}