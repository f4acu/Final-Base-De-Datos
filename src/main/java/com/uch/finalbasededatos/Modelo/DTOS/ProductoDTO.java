package com.uch.finalbasededatos.Modelo.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductoDTO {
    private Long id;
    private String nombreP;
    private Double precio;
    private Set<PedidoDTO> pedidos;
}