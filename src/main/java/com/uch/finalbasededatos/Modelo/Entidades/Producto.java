package com.uch.finalbasededatos.Modelo.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreP;

    @Column(nullable = false)
    private Double precio;

    @ManyToMany(mappedBy = "productos")
    @JsonIgnore
    private Set<Pedido> pedidos;

    public Producto(String nombreP, Double precio) {
        this.nombreP = nombreP;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombreP=" + nombreP + '\'' +
                ", precio=" + precio + '\'' +
                '}';

    }
}
