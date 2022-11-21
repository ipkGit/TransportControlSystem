package com.example.sct.controller;

import com.example.sct.entity.Passenger;
import com.example.sct.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PassengerController {
    @Autowired
    PassengerService passengerService;

    @GetMapping("/passengers")
    public List<Passenger> showPassengers() {
        return passengerService.getAllPassengers();
    }

    @PostMapping("/passengers")
    public Passenger createNewPassenger(@RequestBody Passenger passenger) {
        return passengerService.savePassenger(passenger);
    }

    @GetMapping("/passengers/{id}")
    public Passenger showPassengerById(@PathVariable int id) {
        return passengerService.getPassengerById(id);
    }
}
