package com.uch.finalbasededatos.Modelo.Servicios;

import com.uch.finalbasededatos.Modelo.Entidades.Producto;
import com.uch.finalbasededatos.Modelo.Servicios.Interfaces.IProductoServicio;
import com.uch.finalbasededatos.Repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio implements IProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> getAllProductos(){
        return productoRepositorio.findAll();
    }

    @Override
    public Optional<Producto> getProductoById(Long id){
        return productoRepositorio.findById(id);
    }

    @Override
    public Producto createProducto(Producto producto){
        return productoRepositorio.save(producto);
    }

    @Override
    public Producto updateProducto(Long id, Producto productoDetalles){
        Optional<Producto> optionalProducto = productoRepositorio.findById(id);
        if(optionalProducto.isPresent()){
            Producto producto = optionalProducto.get();
            producto.setNombreP(productoDetalles.getNombreP());
            producto.setPrecio(productoDetalles.getPrecio());
            return productoRepositorio.save(producto);
        } else {
            throw new RuntimeException("No se encontro el producto con id: " + id);
        }
    }

    @Override
    public void deleteProducto(Long id){
        productoRepositorio.deleteById(id);
    }

    @Override
    public Boolean existsProducto(Long id){
        return productoRepositorio.existsById(id);
    }
}
