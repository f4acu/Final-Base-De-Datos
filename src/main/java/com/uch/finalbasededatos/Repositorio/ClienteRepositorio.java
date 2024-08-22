package com.uch.finalbasededatos.Repositorio;

import com.uch.finalbasededatos.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    Cliente findByNombre(String nombre);
}
