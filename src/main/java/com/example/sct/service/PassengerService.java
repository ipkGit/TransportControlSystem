package com.example.sct.service;

import com.example.sct.entity.Passenger;

import java.util.List;

public interface PassengerService {
    Passenger savePassenger (Passenger passenger);

    List<Passenger> getAllPassengers ();

    Passenger getPassengerById (int id);
}
