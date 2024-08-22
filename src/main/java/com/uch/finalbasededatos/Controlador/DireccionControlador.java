package com.uch.finalbasededatos.Controlador;

import com.uch.finalbasededatos.Modelo.Direccion;
import com.uch.finalbasededatos.Repositorio.DireccionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionControlador {

    @Autowired
    private DireccionRepositorio direccionRepositorio;

    @GetMapping
    public List<Direccion> getAllDirecciones(){
        return direccionRepositorio.findAll();
    }

    @PostMapping
    public Direccion createDireccion(@RequestBody Direccion direccion){
        return direccionRepositorio.save(direccion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Direccion> getDireccionByID(@PathVariable Long id){
        Direccion direccion = direccionRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Direccion no encontrada con id" + id));
        return ResponseEntity.ok(direccion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Direccion> updateDireccion(@PathVariable Long id, @RequestBody Direccion direccionDetalles){
        Direccion direccion = direccionRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Direccion no encontrada con id" + id));

        direccion.setCalle(direccionDetalles.getCalle());
        direccion.setProvincia(direccionDetalles.getProvincia());
        direccion.setLocalidad(direccionDetalles.getLocalidad());
        direccion.setCodigoPostal(direccionDetalles.getCodigoPostal());

        Direccion updatedDireccion = direccionRepositorio.save(direccion);
        return ResponseEntity.ok(updatedDireccion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteDireccion(@PathVariable Long id){
        Direccion direccion = direccionRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Direccion no encontrada con id" + id));

        direccionRepositorio.delete(direccion);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
