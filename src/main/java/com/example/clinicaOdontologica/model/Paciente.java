package com.example.clinicaOdontologica.model;

import javax.persistence.*;

@Entity
@Table(name = "Pacientes")
public class Paciente {
    private String nombre;
    private String apellido;
    @OneToOne
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public Paciente(){}

    public Paciente(String nombre, String apellido, Domicilio domicilio, Long id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
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

    public Long getId() {
        return id;
    }
}
