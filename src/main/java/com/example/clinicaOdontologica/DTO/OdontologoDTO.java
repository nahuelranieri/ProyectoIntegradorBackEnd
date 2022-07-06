package com.example.clinicaOdontologica.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class OdontologoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    @JsonIgnoreProperties(ignoreUnknown = true) //Nos sirve para indicarle a jackson que ignore el resto de atributos que tiene la entidad.
    public OdontologoDTO(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public OdontologoDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido(String apellido) {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
