package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.DTO.OdontologoDTO;
import com.example.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService  {

    @Autowired
    private IOdontologoRepository iOdontologoRepository;

    //Utilizo la inyeccion por constructor en vez del @Autowired
    /*public OdontologoService(IOdontologoRepository iOdontologoRepository) {
        this.iOdontologoRepository = iOdontologoRepository;
    }*/

    @Autowired
    ObjectMapper mapper;


    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        //el metodo save de OdontologoRepository sirve tanto para crear desde 0, como para modificar.
        // Si id = 0 lo agrega como nuevo, si es diferente de 0 va a modificar el valor.
        //De esta manera reutilizo codigo
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);//Nos convierte odontologo dto a un objeto del tipo odontologo
        iOdontologoRepository.save(odontologo);
    }

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);

    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public OdontologoDTO leerOdontologo(Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologo = iOdontologoRepository.findById(id);//con Optional<> podemos consultar si el objeto que nos devuelvo es o no null
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent())
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        else
            throw new ResourceNotFoundException("no existe un paciente con el id: " +id);
        return odontologoDTO;
    }


    @Override
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        if(leerOdontologo(id)==null)
            throw new ResourceNotFoundException("no existe un paciente con el id: " +id);
        iOdontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> getTodos() {
        //El List me devuelve una lista de odontologos donde cada objeto es del tipo Odontologo pero yo
        //tengo que devolver un Set PERO con objetos OdontologoDTO.
        List<Odontologo> odontologos = iOdontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTO = new HashSet<>();
        //Recorro la lista de odontologos de la coleccion de odontologos y lleno otro set donde a cada uno de los
        //objetos odontologo lo transformo en un OdontologodDTO.
        for (Odontologo odontologo : odontologos){
            odontologoDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologoDTO;
    }
}
