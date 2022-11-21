package com.example.sct.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cargo_transports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CargoTransport extends Transport implements ForCargo {
    @Column(name = "cargo_capacity")
    private double cargoCapacity;
    @Column(name = "load_capacity")
    private double loadCapacity;
    @Column(name = "truck_type")
    @Enumerated(EnumType.STRING)
    private TruckType truckType;
    @Column(name = "sealed")
    private boolean sealed;

    private double cargoVolume;
    private double cargoWeight;

    @Override
    public void sealUP(boolean seal) {
        this.setSealed(seal);
    }

    @Override
    public boolean addOrderToTransport(TransportOrder transportOrder) {
        if(checkOrder(transportOrder)) {
                    transportOrder.setTransport(this);
                    cargoWeight += transportOrder.getLoadCargos();
                    cargoVolume += transportOrder.getVolCargos();
                    return true;
        }
        return false;
    }

    private boolean checkOrder (TransportOrder transportOrder) { //проверка заказа
        return  transportOrder.getTransport() == null //что он еще не определен к перевозке
                && !sealed //не опломбирован
                && transportOrder.getCountPassenger() == 0 //не содержит пассажиров
                && transportOrder.getCargoType() !=  null // тип груза определен
                && checkCargoType(transportOrder, truckType) //подходит для перевозки данным транспортом
                && transportOrder.getVolCargos() <= cargoCapacity - cargoVolume // помещается по обьему и весу
                && transportOrder.getLoadCargos() <= loadCapacity - cargoWeight;
    }

}
