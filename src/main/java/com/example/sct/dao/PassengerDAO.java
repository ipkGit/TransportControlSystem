package com.example.sct.dao;


import com.example.sct.entity.Passenger;

import java.util.List;

public interface PassengerDAO {
    Passenger savePassenger (Passenger passenger);

    List<Passenger> getAllPassengers ();

    Passenger getPassengerById (int id);
}
