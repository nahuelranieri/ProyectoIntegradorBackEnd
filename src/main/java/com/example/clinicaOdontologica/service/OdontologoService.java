package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {

    @Autowired
    private IOdontologoRepository iOdontologoRepository;

    public void crearOdontologo (Odontologo odontologo){
        iOdontologoRepository.save(odontologo);
    }

    public Odontologo buscarOdontologo (Long id){
         iOdontologoRepository.findById(id);
    }

    public List<Odontologo> listarOdontologos(){
        iOdontologoRepository.findAll();
    }

    public void eliminarOdontologo (Long id){
        iOdontologoRepository.deleteById(id);
    }


}
