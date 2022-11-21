package com.example.sct.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "transport_order_id")
    private TransportOrder transportOrder;

    @Column(name = "cargoType", nullable = false)
    @Enumerated(EnumType.STRING)
    private CargoType cargoType;

    @Column(name = "volume", scale = 2)
    private double volume;

    @Column(name = "weight", scale = 2)
    private double weight;
}