package com.example.sct.controller;

import com.example.sct.entity.*;
import com.example.sct.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransportController {
    @Autowired
    TransportService transportService;

    //transport
    @GetMapping("/transports")
    public List<Transport> showAllTransport() {
        return transportService.getAllTransport();
    }

    @GetMapping("/transport/{id}")
    public Transport showTransportInfo(@PathVariable int id) {
        return transportService.getTransportByID(id);
    }

    @GetMapping("/transport/passenger")
    public List<Transport> showPassengerTransport() {
        return transportService.getOnlyPassengerTransport();
    }

    @PostMapping("/transport/passenger")
    public Transport addNewPassengerTransport(@RequestBody PassengerTransport passengerTransport) {
        return transportService.savePassengerTransport(passengerTransport);
    }

    @GetMapping("/transport/cargo")
    public List<Transport> showCargoTransport() {
        return transportService.getOnlyCargoTransport();
    }

    @PostMapping("/transport/cargo")
    public Transport addNewCargoTransport(@RequestBody CargoTransport cargoTransport) {
        return transportService.saveCargoTransport(cargoTransport);
    }

    @GetMapping("/transports/cargo-passengers")
    public List<Transport> showCargoPassTransport() {
        return transportService.getOnlyCargoPassTransport();
    }

    @PostMapping("/transports/cargo-passengers")
    public Transport addNewCargoPassTransport(@RequestBody CargoPassengerTransport cargoPassengerTransport) {
        return transportService.saveCargoPassTransport(cargoPassengerTransport);
    }

    @PutMapping("/transport/{id}/disinfecting/")
    public String disinfectPassengerTransport(@PathVariable int id) {
        return transportService.disinfectedSalon(id);
    }

    @PutMapping("/transport/{id}/sealing/")
    public String sealingCargoTransport(@PathVariable int id) {
        return transportService.sealUp(id);
    }

    @PutMapping("/transport/{id}/refueling")
    public String refuelingTransport(@PathVariable int id) {
        return transportService.refuelTank(id);
    }

    @PutMapping("/transport/{id}/repairing")
    public String repairTransport(@PathVariable int id) {
        return transportService.repair(id);
    }

    @PutMapping("/transport/{transportID}/add/orders/{orderID}")
    public String addOrderToTransport(@PathVariable int orderID, @PathVariable int transportID) {
        return transportService.addOrderToTransport(transportID, orderID);
    }

    @PutMapping("/transport/{transportID}/remove/orders/{orderID}")
    public String removeOrder(@PathVariable int orderID, @PathVariable int transportID) {
        return transportService.removeOrder(transportID, orderID);
    }
}
