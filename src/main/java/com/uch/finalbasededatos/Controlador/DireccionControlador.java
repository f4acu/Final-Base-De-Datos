package com.uch.finalbasededatos.Controlador;

import com.uch.finalbasededatos.Conversor.EntityAndDTOConvertor;
import com.uch.finalbasededatos.Modelo.DTOS.DireccionDTO;
import com.uch.finalbasededatos.Modelo.Entidades.Direccion;
import com.uch.finalbasededatos.Modelo.Servicios.DireccionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.uch.finalbasededatos.Conversor.EntityAndDTOConvertor.direccionToDTO;
import static com.uch.finalbasededatos.Conversor.EntityAndDTOConvertor.dtoToDireccion;

@RestController
@RequestMapping("/direcciones")
public class DireccionControlador {

    @Autowired
    private DireccionServicio direccionServicio;

    @GetMapping
    public List<DireccionDTO> getAllDirecciones(){
        return direccionServicio.getAllDirecciones().stream()
                .map(EntityAndDTOConvertor::direccionToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DireccionDTO> getDireccionById(@PathVariable Long id){
        Optional<Direccion> direccionOptional = direccionServicio.getDireccionById(id);
        if(!direccionOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        DireccionDTO direccionDTO = direccionToDTO(direccionOptional.get());
        return ResponseEntity.ok(direccionDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DireccionDTO> updateDireccion(@PathVariable Long id, @RequestBody DireccionDTO direccionDTO){
        Direccion direccion = dtoToDireccion(direccionDTO);
        Direccion updatedDireccion = direccionServicio.updateDireccion(id, direccion);

        return ResponseEntity.ok(direccionToDTO(updatedDireccion));
    }
}
