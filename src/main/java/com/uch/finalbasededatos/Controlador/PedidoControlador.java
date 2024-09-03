package com.uch.finalbasededatos.Controlador;

import com.uch.finalbasededatos.Conversor.EntityAndDTOConvertor;
import com.uch.finalbasededatos.Modelo.DTOS.PedidoDTO;
import com.uch.finalbasededatos.Modelo.Entidades.Pedido;
import com.uch.finalbasededatos.Modelo.Servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.uch.finalbasededatos.Conversor.EntityAndDTOConvertor.dtoToPedido;
import static com.uch.finalbasededatos.Conversor.EntityAndDTOConvertor.pedidoToDTO;

@RestController
@RequestMapping("/pedidos")
public class PedidoControlador {

    @Autowired
    private PedidoServicio pedidoServicio;

    @GetMapping
    public List<PedidoDTO> getAllPedidos(){
        return pedidoServicio.getAllPedidos().stream()
                .map(EntityAndDTOConvertor::pedidoToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> getPedidoById(@PathVariable Long id){
        Optional<Pedido> pedidoOptional = pedidoServicio.getPedidoById(id);
        if(pedidoOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }

        PedidoDTO pedidoDTO = new PedidoDTO();
        return ResponseEntity.ok(pedidoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> updatePedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO){
        Pedido pedido = dtoToPedido(pedidoDTO);
        Pedido updatedPedido = pedidoServicio.updatePedido(id, pedido);

        return ResponseEntity.ok(pedidoToDTO(updatedPedido));
    }
}
