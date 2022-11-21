package com.example.sct.service;

import com.example.sct.dao.TransportOrderDAO;
import com.example.sct.entity.TransportOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransportOrderServiceImpl implements TransportOrderService {

    @Autowired
    TransportOrderDAO transportOrderDAO;

    @Override
    @Transactional
    public TransportOrder saveTransportOrder(TransportOrder transportOrder) {
        return transportOrderDAO.saveTransportOrder(transportOrder);
    }

    @Override
    @Transactional
    public List<TransportOrder> getAllTransportOrders() {
        return transportOrderDAO.getAllTransportOrders();
    }

    @Override
    @Transactional
    public TransportOrder getTransportOrderById(int id) {
        return transportOrderDAO.getTransportOrderById(id);
    }

    @Override
    @Transactional
    public String addCargoToOrder(int cargoID, int orderID) {
        return transportOrderDAO.addCargoToOrder(cargoID,orderID);
    }

    @Override
    @Transactional
    public String addPassengerToOrder(int passengerID, int orderID) {
        return transportOrderDAO.addPassengerToOrder(passengerID, orderID);
    }

    @Override
    @Transactional
    public String removePassenger(int passengerID, int orderID) {
        return transportOrderDAO.removePassenger(passengerID, orderID);
    }

    @Override
    @Transactional
    public String removeCargo (int cargoID, int orderID) {
        return transportOrderDAO.removeCargo(cargoID,orderID);
    }




}
