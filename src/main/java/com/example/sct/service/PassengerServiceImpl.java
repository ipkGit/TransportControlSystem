package com.example.sct.service;

import com.example.sct.dao.PassengerDAO;
import com.example.sct.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    PassengerDAO passengerDAO;

    @Override
    @Transactional
    public Passenger savePassenger(Passenger passenger) {
        return passengerDAO.savePassenger(passenger);
    }

    @Override
    @Transactional
    public List<Passenger> getAllPassengers() {
        return passengerDAO.getAllPassengers();
    }

    @Override
    @Transactional
    public Passenger getPassengerById(int id) {
        return passengerDAO.getPassengerById(id);
    }
}
