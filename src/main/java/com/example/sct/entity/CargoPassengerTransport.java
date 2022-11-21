package com.example.sct.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cargo_pass_transports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CargoPassengerTransport extends Transport implements ForCargo, ForPassenger {
    @Column(name = "cargo_capacity")
    private double cargoCapacity;
    @Column(name = "load_capacity")
    private double loadCapacity;
    @Column(name = "truck_type")
    @Enumerated(EnumType.STRING)
    private TruckType truckType;
    @Column(name = "sealed")
    private boolean sealed;
    @Column(name = "seats")
    private int seats;
    @Column(name = "disinfected")
    private boolean disinfected;

    private int busySeats;
    private double cargoWeight;
    private double cargoVolume;

    @Override
    public void sealUP(boolean seal) {
        this.setSealed(seal);
    }

    @Override
    public void disinfectedSalon(boolean disinfected) {
        this.setDisinfected(disinfected);
    }

    @Override // требуется переписать
    public boolean addOrderToTransport(TransportOrder transportOrder) {
        if (checkOrder(transportOrder)) {
            orderList.add(transportOrder);
            transportOrder.setTransport(this);
            busySeats += transportOrder.getCountPassenger();
            cargoWeight += transportOrder.getLoadCargos();
            cargoVolume += transportOrder.getVolCargos();
            return true;
        }
        return false;
    }

    private boolean checkOrder(TransportOrder transportOrder) {
        return      transportOrder.getTransport() == null
                && (transportOrder.getPassengers().isEmpty() || transportOrder.getCountPassenger() <= seats - busySeats)
                && (transportOrder.getCargoType() == null || (checkCargoType(transportOrder, truckType) && !sealed))
                && (transportOrder.getLoadCargos() <= loadCapacity - cargoWeight && transportOrder.getVolCargos() <= cargoCapacity - cargoVolume)
                && (transportOrder.getCountPassenger() != 0 || transportOrder.getCargoType() != null);
    }
}
