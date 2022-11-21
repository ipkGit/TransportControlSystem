package com.example.sct.dao;

import com.example.sct.entity.Transport;

import java.util.List;

public interface TransportDAO {

    Transport saveCargoTransport(Transport cargoTransport);

    Transport savePassengerTransport(Transport passengerTransport);

    Transport saveCargoPassTransport(Transport cargoPassengerTransport);

    List<Transport> getAllTransport();

    List<Transport> getOnlyCargoTransport();

    List<Transport> getOnlyPassengerTransport();

    List<Transport> getOnlyCargoPassTransport();

    Transport getTransportByID(int id);

    String refuelTank(int id);

    String disinfectedSalon(int id);

    String sealUp(int id);

    String addOrderToTransport (int transportID, int orderID);

    String removeOrder(int transportID, int orderID);

    String repair(int id);
}
