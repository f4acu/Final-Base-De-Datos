package com.uch.finalbasededatos.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreP;

    @Column(nullable = false)
    private Double precio;

    @ManyToMany(mappedBy = "productos")
    private Set<Pedido> pedidos;
}
