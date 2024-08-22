package com.uch.finalbasededatos.Repositorio;

import com.uch.finalbasededatos.Modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
}
