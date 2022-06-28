package com.example.clinicaOdontologica.model;

public class Paciente {
    private String calle;
    private int altura;
    private String localidad;
    private int id;

    public Paciente(String calle, int altura, String localidad, int id) {
        this.calle = calle;
        this.altura = altura;
        this.localidad = localidad;
        this.id = id;
    }
}
