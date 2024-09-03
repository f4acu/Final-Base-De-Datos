package com.uch.finalbasededatos.Modelo.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DireccionDTO {
    private Long id;
    private String calle;
    private String localidad;
    private String provincia;
    private String codigoPostal;
    private ClienteDTO cliente;
}