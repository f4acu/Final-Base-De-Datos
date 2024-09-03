package com.uch.finalbasededatos.Conversor;

import com.uch.finalbasededatos.Modelo.DTOS.ClienteDTO;
import com.uch.finalbasededatos.Modelo.DTOS.DireccionDTO;
import com.uch.finalbasededatos.Modelo.DTOS.PedidoDTO;
import com.uch.finalbasededatos.Modelo.DTOS.ProductoDTO;
import com.uch.finalbasededatos.Modelo.Entidades.Cliente;
import com.uch.finalbasededatos.Modelo.Entidades.Direccion;
import com.uch.finalbasededatos.Modelo.Entidades.Pedido;
import com.uch.finalbasededatos.Modelo.Entidades.Producto;

public class EntityAndDTOConvertor {
    public static ClienteDTO clienteToDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setEmail(cliente.getEmail());

        return clienteDTO;
    }

    public static Cliente dtoToCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setEmail(clienteDTO.getEmail());

        return cliente;
    }

    public static DireccionDTO direccionToDTO(Direccion direccion) {
        DireccionDTO direccionDTO = new DireccionDTO();
        direccionDTO.setId(direccion.getId());
        direccionDTO.setCalle(direccion.getCalle());
        direccionDTO.setLocalidad(direccion.getLocalidad());
        direccionDTO.setProvincia(direccion.getProvincia());
        direccionDTO.setCodigoPostal(direccion.getCodigoPostal());

        return direccionDTO;
    }

    public static Direccion dtoToDireccion(DireccionDTO direccionDTO) {
        Direccion direccion = new Direccion();
        direccion.setId(direccionDTO.getId());
        direccion.setCalle(direccionDTO.getCalle());
        direccion.setLocalidad(direccionDTO.getLocalidad());
        direccion.setProvincia(direccionDTO.getProvincia());
        direccion.setCodigoPostal(direccionDTO.getCodigoPostal());

        return direccion;
    }

    public static PedidoDTO pedidoToDTO(Pedido pedido) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setId(pedido.getId());
        pedidoDTO.setFecha(pedido.getFecha());

        if (pedido.getCliente() != null){
            ClienteDTO clienteDTO = clienteToDTO(pedido.getCliente());
            pedidoDTO.setCliente((clienteDTO));
        }

        return pedidoDTO;
    }

    public static Pedido dtoToPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setId(pedidoDTO.getId());
        pedido.setFecha(pedidoDTO.getFecha());

        if (pedidoDTO.getCliente() != null){
            Cliente cliente = dtoToCliente(pedidoDTO.getCliente());
            pedido.setCliente(cliente);
        }

        return pedido;
    }

    public static ProductoDTO productoToDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombreP(producto.getNombreP());
        productoDTO.setPrecio(producto.getPrecio());

        return productoDTO;
    }

    public static Producto dtoToProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setId(productoDTO.getId());
        producto.setNombreP(productoDTO.getNombreP());
        producto.setPrecio(productoDTO.getPrecio());

        return producto;
    }
}
