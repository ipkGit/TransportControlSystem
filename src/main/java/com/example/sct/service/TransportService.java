package com.example.sct.service;

import com.example.sct.entity.Transport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TransportService {
    Transport saveCargoTransport(Transport cargoTransport);
    Transport savePassengerTransport (Transport passengerTransport);
    Transport saveCargoPassTransport(Transport cargoPassengerTransport);
    List<Transport> getAllTransport ();
    List<Transport> getOnlyCargoTransport();
    List<Transport> getOnlyPassengerTransport();
    List<Transport> getOnlyCargoPassTransport();
    Transport getTransportByID (int id);
    String refuelTank (int id);
    String disinfectedSalon (int id);
    String sealUp (int id);
    String addOrderToTransport (int transportID, int orderID);

    @Transactional
    String removeOrder(int transportID, int orderID);

    @Transactional
    String repair(int id);
}
