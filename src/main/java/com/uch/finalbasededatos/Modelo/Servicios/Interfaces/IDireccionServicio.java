package com.uch.finalbasededatos.Modelo.Servicios.Interfaces;

import com.uch.finalbasededatos.Modelo.Entidades.Direccion;

import java.util.List;
import java.util.Optional;

public interface IDireccionServicio {
    List <Direccion> getAllDirecciones();
    Optional <Direccion> getDireccionById(Long id);
    Direccion createDireccion(Direccion direccion);
    Direccion updateDireccion(Long id, Direccion direccion);
    void deleteDireccion(Long id);
    Boolean existDireccionById(Long id);
}
