package com.uch.finalbasededatos.Modelo.Servicios;

import com.uch.finalbasededatos.Modelo.Entidades.Cliente;
import com.uch.finalbasededatos.Modelo.Servicios.Interfaces.IClienteServicio;
import com.uch.finalbasededatos.Repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio implements IClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepositorio.findById(id);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente clienteDetalles) {
        Optional<Cliente> optionalCliente = clienteRepositorio.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.setNombre(clienteDetalles.getNombre());
            cliente.setEmail(clienteDetalles.getEmail());
            cliente.setDireccion(clienteDetalles.getDireccion());
            return clienteRepositorio.save(cliente);
        }else {
                throw new RuntimeException("Cliente no encontrado con el id: " + id);
        }
    }

    @Override
    public void deleteCliente(Long id){
        clienteRepositorio.deleteById(id);
    }

    @Override
    public Boolean existClienteById(Long id){
        return clienteRepositorio.existsById(id);
    }
}
