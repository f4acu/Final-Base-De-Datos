package com.uch.finalbasededatos.Repositorio;

import com.uch.finalbasededatos.Modelo.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepositorio extends JpaRepository<Direccion, Long> {
}
