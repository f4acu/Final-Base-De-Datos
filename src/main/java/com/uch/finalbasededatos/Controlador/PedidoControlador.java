package com.uch.finalbasededatos.Controlador;

import com.uch.finalbasededatos.Modelo.Pedido;
import com.uch.finalbasededatos.Repositorio.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoControlador {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoRepositorio.findAll();
    }

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoRepositorio.save(pedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
        Pedido pedido = pedidoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id" + id));
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido pedidoDetalles) {
        Pedido pedido = pedidoRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Pedido no encontrado con id" + id));

        pedido.setFecha(pedidoDetalles.getFecha());
        pedido.setCliente(pedidoDetalles.getCliente());
        pedido.setProductos(pedidoDetalles.getProductos());

        Pedido updatedPedido = pedidoRepositorio.save(pedido);
        return ResponseEntity.ok(updatedPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePedido(@PathVariable Long id) {
        Pedido pedido = pedidoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id" + id));

        pedidoRepositorio.delete(pedido);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
