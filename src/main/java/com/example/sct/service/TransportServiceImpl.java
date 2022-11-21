package com.example.sct.service;

import com.example.sct.dao.TransportDAO;
import com.example.sct.entity.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransportServiceImpl implements TransportService {

    @Autowired
    TransportDAO transportDAO;

    @Override
    @Transactional
    public Transport saveCargoTransport(Transport cargoTransport) {
        return transportDAO.saveCargoTransport(cargoTransport);
    }

    @Override
    @Transactional
    public Transport savePassengerTransport(Transport passengerTransport) {
        return transportDAO.savePassengerTransport(passengerTransport);
    }

    @Override
    @Transactional
    public Transport saveCargoPassTransport(Transport cargoPassengerTransport) {
        return transportDAO.saveCargoPassTransport(cargoPassengerTransport);
    }

    @Override
    @Transactional
    public List<Transport> getAllTransport() {
        return transportDAO.getAllTransport();
    }

    @Override
    @Transactional
    public List<Transport> getOnlyCargoTransport() {
        return transportDAO.getOnlyCargoTransport();
    }

    @Override
    @Transactional
    public List<Transport> getOnlyPassengerTransport() {
        return transportDAO.getOnlyPassengerTransport();
    }

    @Override
    @Transactional
    public List<Transport> getOnlyCargoPassTransport() {
        return transportDAO.getOnlyCargoPassTransport();
    }

    @Override
    @Transactional
    public Transport getTransportByID(int id) {
        return transportDAO.getTransportByID(id);
    }

    @Override
    @Transactional
    public String refuelTank(int id) {
        return transportDAO.refuelTank(id);
    }

    @Override
    @Transactional
    public String disinfectedSalon(int id) {
        return transportDAO.disinfectedSalon(id);
    }

    @Override
    @Transactional
    public String sealUp(int id) {
        return transportDAO.sealUp(id);
    }

    @Override
    @Transactional
    public String addOrderToTransport(int transportID, int orderID) {
        return transportDAO.addOrderToTransport(transportID, orderID);
    }

    @Override
    @Transactional
    public String removeOrder (int transportID, int orderID) {
        return transportDAO.removeOrder(transportID, orderID);
    }


    @Override
    @Transactional
    public String repair(int id) {
        return transportDAO.repair(id);
    }
}
