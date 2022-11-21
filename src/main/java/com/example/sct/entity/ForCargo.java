package com.example.sct.entity;

public interface ForCargo {
    void sealUP(boolean seal);

    boolean isSealed();

    default boolean checkCargoType(TransportOrder transportOrder, TruckType truckType) {
        CargoType cargoType = transportOrder.getCargoType();
        if (cargoType.equals(CargoType.LIQUID) && truckType.equals(TruckType.TANK)) {
            return true;
        } else if (cargoType.equals(CargoType.INDUSTRIAL_GOOD) && !truckType.equals(TruckType.TANK)) {
            return true;
        } else return cargoType.equals(CargoType.PERISHABLE) && truckType.equals(TruckType.REFRIGERATOR);
    }
}
