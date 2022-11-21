package com.example.sct.dao;

import com.example.sct.entity.TransportOrder;

import java.util.List;

public interface TransportOrderDAO {
    TransportOrder saveTransportOrder (TransportOrder transportOrder);

    List<TransportOrder> getAllTransportOrders ();

    TransportOrder getTransportOrderById (int id);

    String addCargoToOrder(int cargoID, int orderID);

    String addPassengerToOrder (int passengerID, int orderID);

    String removePassenger(int passengerID, int orderID);

    String removeCargo(int cargoID, int orderID);
}
