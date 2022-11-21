package com.example.sct.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transport_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransportOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "transport_id")
    private Transport transport;

    @Column(name = "address_from")
    private String addressFrom;

    @Column(name = "address_to")
    private String addressTo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transportOrder", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<Passenger> passengers;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transportOrder", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<Cargo> cargos;

    private int countPassenger;

    private double volCargos;

    private double loadCargos;

    @Enumerated(EnumType.STRING)
    private CargoType cargoType;


    public boolean addPassengerToOrder(Passenger passenger) {
        if (passengers == null) {
            passengers = new ArrayList<>();
        }
        if (passenger.getTransportOrder() == null && transport == null) {
            passengers.add(passenger);
            passenger.setTransportOrder(this);
            countPassenger++;
            return true;
        }
        return false;
    }

    public boolean addCargoToOrder(Cargo cargo) {
        if (cargos == null) {
            cargos = new ArrayList<>();
        }
        if (checkType(cargo.getCargoType()) && cargo.getTransportOrder() == null && transport == null) {
            cargos.add(cargo);
            cargo.setTransportOrder(this);

            volCargos += cargo.getVolume();
            loadCargos += cargo.getWeight();
            return true;
        }
        return false;
    }

    private boolean checkType(CargoType cargoType) {
        if (this.cargoType == null) {
            this.cargoType = cargoType;
            return true;
        } else if (this.cargoType.equals(cargoType)) {
            return true;
        } else if (this.cargoType == CargoType.INDUSTRIAL_GOOD && cargoType == CargoType.PERISHABLE) {
            this.cargoType = CargoType.PERISHABLE;
            return true;
        } else return this.cargoType == CargoType.PERISHABLE && cargoType == CargoType.INDUSTRIAL_GOOD;
    }

    public boolean removeCargo(Cargo cargo) {
        if (cargos.contains(cargo)) {
            cargos.remove(cargo);
            cargo.setTransportOrder(null);
            return true;
        }
        return false;
    }

    public boolean removePassenger(Passenger passenger) {
        if (passengers.contains(passenger)) {
            passengers.remove(passenger);
            passenger.setTransportOrder(null);
            return true;
        }
        return false;
    }
}