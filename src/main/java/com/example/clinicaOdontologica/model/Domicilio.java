package com.example.clinicaOdontologica.model;
import javax.persistence.*;

@Entity
@Table(name = "Domicilio")
public class Domicilio {
    private String calle;
    private int altura;
    private String localidad;
    private String provincia;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //???
    private Long id;
    @OneToOne(mappedBy = "domicilio")
    private Paciente paciente;

    //@OneToOne(mappedBy = "domicilio"); me tiran error
    //private Paciente paciente;



    public Domicilio(String calle, int altura, String localidad, String provincia, Long id) {
        this.calle = calle;
        this.altura = altura;
        this.localidad = localidad;
        this.provincia = provincia;
        this.id = id;
    }






    public Domicilio() {} //???

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

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/ //no lo usamos al setter id
}
