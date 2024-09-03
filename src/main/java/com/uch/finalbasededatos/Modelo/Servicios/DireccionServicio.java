package com.uch.finalbasededatos.Modelo.Servicios;

import com.uch.finalbasededatos.Modelo.Entidades.Direccion;
import com.uch.finalbasededatos.Modelo.Servicios.Interfaces.IDireccionServicio;
import com.uch.finalbasededatos.Repositorio.DireccionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DireccionServicio implements IDireccionServicio {

    @Autowired
    private DireccionRepositorio direccionRepositorio;

    @Override
    public List<Direccion> getAllDirecciones(){
        return direccionRepositorio.findAll();
    }

    @Override
    public Optional<Direccion> getDireccionById(Long id){
        return direccionRepositorio.findById(id);
    }

    @Override
    public Direccion createDireccion(Direccion direccion){
        return direccionRepositorio.save(direccion);
    }

    @Override
    public Direccion updateDireccion(Long id, Direccion direccionDetalles){
        Optional<Direccion> optionalDireccion = direccionRepositorio.findById(id);
        if(optionalDireccion.isPresent()){
            Direccion direccion = optionalDireccion.get();
            direccion.setCalle(direccionDetalles.getCalle());
            direccion.setLocalidad(direccionDetalles.getLocalidad());
            direccion.setProvincia(direccionDetalles.getProvincia());
            direccion.setCodigoPostal(direccionDetalles.getCodigoPostal());
            return direccionRepositorio.save(direccion);
        } else {
            throw new RuntimeException("Direccion no encontrada con el id: " + id);
        }
    }

    @Override
    public void deleteDireccion(Long id) {
        direccionRepositorio.deleteById(id);
    }

    @Override
    public Boolean existDireccionById(Long id){
        return direccionRepositorio.existsById(id);
    }
}
