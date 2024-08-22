package com.uch.finalbasededatos.Controlador;

import com.uch.finalbasededatos.Modelo.Producto;
import com.uch.finalbasededatos.Repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/productos")
public class ProductoControlador {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepositorio.findAll();
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepositorio.save(producto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id){
        Producto producto =productoRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado con id" + id));
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto productoDetalles){
        Producto producto = productoRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado con id" + id));

        producto.setNombreP(productoDetalles.getNombreP());
        producto.setPrecio(productoDetalles.getPrecio());

        Producto updatedProducto = productoRepositorio.save(producto);
        return ResponseEntity.ok(updatedProducto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProducto(@PathVariable Long id){
        Producto producto = productoRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado con id" + id));

        productoRepositorio.delete(producto);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
