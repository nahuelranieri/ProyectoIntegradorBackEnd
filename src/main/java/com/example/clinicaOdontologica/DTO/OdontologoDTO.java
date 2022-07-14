package com.example.clinicaOdontologica.DTO;

import com.example.clinicaOdontologica.model.Domicilio;
import com.example.clinicaOdontologica.model.Turno;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

//Nos sirve para indicarle a jackson que ignore el
// resto de atributos que tiene la entidad.
@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Set<Turno> turnos;

    public OdontologoDTO() {}

    public OdontologoDTO(Long id, String nombre, String apellido, Set<Turno> turnos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.turnos = turnos;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }
}
