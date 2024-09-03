package com.uch.finalbasededatos.Modelo.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class PedidoDTO {
    private Long id;
    private Date fecha;
    private ClienteDTO cliente;
    private Set<ProductoDTO> productos;
}
