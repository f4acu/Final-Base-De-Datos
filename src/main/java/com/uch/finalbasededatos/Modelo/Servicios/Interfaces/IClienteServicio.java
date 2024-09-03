package com.uch.finalbasededatos.Modelo.Servicios.Interfaces;

import com.uch.finalbasededatos.Modelo.Entidades.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteServicio {
    List<Cliente> getAllClientes();
    Optional<Cliente>getClienteById(Long id);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Long id, Cliente clienteDetalles);
    void deleteCliente(Long id);
    Boolean existClienteById(Long id);
}
