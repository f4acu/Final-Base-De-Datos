package com.uch.finalbasededatos.Controlador;

import com.uch.finalbasededatos.Conversor.EntityAndDTOConvertor;
import com.uch.finalbasededatos.Modelo.DTOS.ClienteDTO;
import com.uch.finalbasededatos.Modelo.Entidades.Cliente;
import com.uch.finalbasededatos.Modelo.Servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.uch.finalbasededatos.Conversor.EntityAndDTOConvertor.clienteToDTO;
import static com.uch.finalbasededatos.Conversor.EntityAndDTOConvertor.dtoToCliente;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping
    public List<ClienteDTO> getAllClientes() {
        return clienteServicio.getAllClientes().stream()
                .map(EntityAndDTOConvertor::clienteToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = clienteServicio.getClienteById(id);
        if (!clienteOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        ClienteDTO clienteDTO = clienteToDTO(clienteOptional.get());
        return ResponseEntity.ok(clienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = dtoToCliente(clienteDTO);
        Cliente updatedCliente = clienteServicio.updateCliente(id, cliente);

        return ResponseEntity.ok(clienteToDTO(updatedCliente));
    }
}
