package com.uch.finalbasededatos.Modelo.Servicios;

import com.uch.finalbasededatos.Modelo.Entidades.Pedido;
import com.uch.finalbasededatos.Modelo.Servicios.Interfaces.IPedidoServicio;
import com.uch.finalbasededatos.Repositorio.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio implements IPedidoServicio{

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Override
    public List<Pedido> getAllPedidos(){
        return pedidoRepositorio.findAll();
    }

    @Override
    public Optional<Pedido> getPedidoById(Long id){
        return pedidoRepositorio.findById(id);
    }

    @Override
    public Pedido createPedido(Pedido pedido){
        return pedidoRepositorio.save(pedido);
    }

    @Override
    public Pedido updatePedido(Long id, Pedido pedidoDetalles){
        Optional<Pedido> optionalPedido = pedidoRepositorio.findById(id);
        if(optionalPedido.isPresent()){
            Pedido pedido = optionalPedido.get();
            pedido.setCliente(pedidoDetalles.getCliente());
            pedido.setFecha(pedidoDetalles.getFecha());
            return pedidoRepositorio.save(pedido);
        } else {
            throw new RuntimeException("Pedido no encontrado con id " + id);
        }
    }

    @Override
    public void deletePedido(Long id){
        pedidoRepositorio.deleteById(id);
    }

    @Override
    public Boolean existPedidoById(Long id){
        return pedidoRepositorio.existsById(id);
    }
}
