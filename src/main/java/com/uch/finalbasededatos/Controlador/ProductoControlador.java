package com.uch.finalbasededatos.Controlador;

import com.uch.finalbasededatos.Conversor.EntityAndDTOConvertor;
import com.uch.finalbasededatos.Modelo.DTOS.ProductoDTO;
import com.uch.finalbasededatos.Modelo.Entidades.Producto;
import com.uch.finalbasededatos.Modelo.Servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.uch.finalbasededatos.Conversor.EntityAndDTOConvertor.dtoToProducto;
import static com.uch.finalbasededatos.Conversor.EntityAndDTOConvertor.productoToDTO;

@RestController
@RequestMapping("/productos")
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping
    public List<ProductoDTO> getAllProductos() {
        return productoServicio.getAllProductos().stream()
                .map(EntityAndDTOConvertor::productoToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProductoById(@PathVariable Long id) {
        Optional<Producto> productoOptional = productoServicio.getProductoById(id);
        if (productoOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        ProductoDTO productoDTO = productoToDTO(productoOptional.get());
        return ResponseEntity.ok(productoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        Producto producto = dtoToProducto(productoDTO);
        Producto updatedProducto = productoServicio.updateProducto(id, producto);

        return ResponseEntity.ok(productoToDTO(updatedProducto));
    }
}
