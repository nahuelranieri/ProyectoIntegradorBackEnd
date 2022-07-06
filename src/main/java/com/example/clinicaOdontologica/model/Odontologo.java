package com.example.clinicaOdontologica.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Odontologos")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//???
    private Long id;
    private String nombre;
    private String apellido;
    private Long matricula;
    @OneToMany(mappedBy = "odontologo")
    private Set<Turno> turnos;

    public Odontologo(){}

    public Odontologo(String nombre, String apellido, Long id, Long matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.matricula = matricula;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }
}
