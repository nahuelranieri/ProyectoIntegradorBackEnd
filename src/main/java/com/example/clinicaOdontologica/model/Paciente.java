package com.example.clinicaOdontologica.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//se autogenera el id
    private Long id;
    private String nombre;
    private String apellido;
    @OneToOne(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)//si borro un paciente borro tambien su domicilio
    //@JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;
    @OneToMany(mappedBy = "paciente")
    private Set<Turno> turnos;

    public Paciente(){}

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
