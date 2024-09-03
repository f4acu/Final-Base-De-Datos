package com.uch.finalbasededatos.Repositorio;

import com.uch.finalbasededatos.Modelo.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}