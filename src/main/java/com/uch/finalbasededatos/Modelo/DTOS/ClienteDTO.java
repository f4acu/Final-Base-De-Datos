package com.uch.finalbasededatos.Modelo.DTOS;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String email;
    private DireccionDTO direccion;
    private Set<PedidoDTO> pedidos;

}