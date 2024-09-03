package com.uch.finalbasededatos.Modelo.Servicios.Interfaces;

import com.uch.finalbasededatos.Modelo.Entidades.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoServicio {
    List<Producto> getAllProductos();
    Optional<Producto> getProductoById(Long id);
    Producto createProducto(Producto producto);
    Producto updateProducto(Long id, Producto producto);
    void deleteProducto(Long id);
    Boolean existsProducto(Long id);
}
