package com.example.clinicaOdontologica.model;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Domicilios")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //???
    private Long id;
    private String calle;
    private int altura;
    private String localidad;
    private String provincia;
    //@OneToMany(mappedBy = "pacientes", fetch = FetchType.LAZY);
    @OneToOne(mappedBy = "domicilio")
    private Paciente pacientes;

    public Domicilio() {} //Hibernate me pide un constructor por default

    public Domicilio(String calle, int altura, String localidad, String provincia, Long id) {
        this.calle = calle;
        this.altura = altura;
        this.localidad = localidad;
        this.provincia = provincia;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Paciente getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente pacientes) {
        this.pacientes = pacientes;
    }
}
