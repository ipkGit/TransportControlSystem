package com.example.sct.service;

import com.example.sct.entity.TransportOrder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TransportOrderService {
    TransportOrder saveTransportOrder (TransportOrder transportOrder);

    List<TransportOrder> getAllTransportOrders ();

    TransportOrder getTransportOrderById (int id);

    String addCargoToOrder(int cargoID, int orderID);

    String addPassengerToOrder (int passengerID, int orderID);

    @Transactional
    String removePassenger(int passengerID, int orderID);

    @Transactional
    String removeCargo(int cargoID, int orderID);
}
