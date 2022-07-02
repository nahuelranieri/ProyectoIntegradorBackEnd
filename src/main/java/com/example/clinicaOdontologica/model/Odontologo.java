package com.example.clinicaOdontologica.model;

import javax.persistence.*;

@Entity
@Table(name = "Odontologos")
public class Odontologo {
    private String nombre;
    private String apellido;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//???
    private Long id;
    private Long matricula;

    public Odontologo(){}

    public Odontologo(String nombre, String apellido, Long id, Long matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.matricula = matricula;
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

    public Long getId() {
        return id;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
}
