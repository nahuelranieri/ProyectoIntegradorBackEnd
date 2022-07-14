package com.example.clinicaOdontologica.DTO;

import com.example.clinicaOdontologica.model.Domicilio;
import com.example.clinicaOdontologica.model.Turno;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

//Nos sirve para indicarle a jackson que ignore el
// resto de atributos que tiene la entidad.
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Long DNI;
    private Domicilio domicilio;
    private Set<Turno> turnos;

    public PacienteDTO() {
    }

    public PacienteDTO(Long id, String nombre, String apellido, Long DNI, Domicilio domicilio, Set<Turno> turnos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.domicilio = domicilio;
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

    public Long getDNI() {
        return DNI;
    }

    public void setDNI(Long DNI) {
        this.DNI = DNI;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }
}



