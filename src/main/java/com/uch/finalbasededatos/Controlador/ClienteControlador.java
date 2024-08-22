package com.uch.finalbasededatos.Controlador;

import com.uch.finalbasededatos.Modelo.Cliente;
import com.uch.finalbasededatos.Repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteRepositorio.findAll();
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
        Cliente existingCliente = clienteRepositorio.findByNombre(cliente.getNombre());
        if(existingCliente != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        Cliente savedCliente = clienteRepositorio.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id){
        Cliente cliente = clienteRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Cliente no encontrado con id " + id));
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente clienteDetalles){
        Cliente cliente = clienteRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Cliente no encontrado con id" + id));

        cliente.setNombre(clienteDetalles.getNombre());
        cliente.setEmail(clienteDetalles.getEmail());
        cliente.setDireccion(clienteDetalles.getDireccion());
        cliente.setPedidos(clienteDetalles.getPedidos());

        Cliente updatedCliente = clienteRepositorio.save(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCliente(@PathVariable Long id){
        Cliente cliente = clienteRepositorio.findById(id)
        .orElseThrow(()-> new RuntimeException("Cliente no encontrado con id" + id));

        clienteRepositorio.delete(cliente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
