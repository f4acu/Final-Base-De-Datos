package com.uch.finalbasededatos.Modelo.Servicios.Interfaces;

import com.uch.finalbasededatos.Modelo.Entidades.Pedido;

import java.util.List;
import java.util.Optional;

public interface IPedidoServicio {
    List<Pedido> getAllPedidos();
    Optional<Pedido> getPedidoById(Long id);
    Pedido createPedido(Pedido pedido);
    Pedido updatePedido(Long id, Pedido pedido);
    void deletePedido(Long id);
    Boolean existPedidoById(Long id);
}
