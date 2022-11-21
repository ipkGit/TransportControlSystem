package com.example.sct.entity;

import lombok.*;


import javax.persistence.*;

@Entity
@Table(name = "PASSENGER_TRANS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PassengerTransport extends Transport implements ForPassenger {
    @Column(name = "seats")
    private int seats;
    @Column(name = "disinfected")
    private boolean disinfected;
    private int busySeats;

    @Override
    public void disinfectedSalon(boolean disinfected) {
        this.setDisinfected(disinfected);
    }

    @Override
    public boolean addOrderToTransport(TransportOrder transportOrder) {
        if (!transportOrder.getPassengers().isEmpty() && transportOrder.getCargos().isEmpty()) {
            if (transportOrder.getPassengers().size() <= seats - busySeats) {
                orderList.add(transportOrder);
                transportOrder.setTransport(this);
                busySeats += transportOrder.getPassengers().size();
                return true;
            }
        }
        return false;
    }
}
