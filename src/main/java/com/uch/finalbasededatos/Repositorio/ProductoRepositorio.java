package com.uch.finalbasededatos.Repositorio;

import com.uch.finalbasededatos.Modelo.Entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}