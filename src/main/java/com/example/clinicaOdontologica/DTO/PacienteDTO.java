package com.example.clinicaOdontologica.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //Nos sirve para indicarle a jackson que ignore el resto de atributos que tiene la entidad.
public class PacienteDTO {
    private Long id;
    private String nombreCompleto;

    public PacienteDTO(Long id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
    }
}



