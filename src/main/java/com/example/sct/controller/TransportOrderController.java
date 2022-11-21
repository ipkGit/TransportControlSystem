package com.example.sct.controller;

import com.example.sct.entity.TransportOrder;
import com.example.sct.service.TransportOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransportOrderController {

    @Autowired
    TransportOrderService transportOrderService;

    @GetMapping("/transport-orders")
    public List<TransportOrder> showAllOrders() {
        return transportOrderService.getAllTransportOrders();
    }

    @PostMapping("/transport-orders")
    public TransportOrder createNewOrder(@RequestBody TransportOrder transportOrder) {
        return transportOrderService.saveTransportOrder(transportOrder);
    }

    @GetMapping("/transport-orders/{id}")
    public TransportOrder showOrderById(@PathVariable int id) {
        return transportOrderService.getTransportOrderById(id);
    }

    @PutMapping("transport-orders/{orderID}/add/cargos/{cargoID}")
    public String addCargoToOrder(@PathVariable int cargoID, @PathVariable int orderID) {
        return transportOrderService.addCargoToOrder(cargoID, orderID);
    }

    @PutMapping("transport-orders/{orderID}/remove/cargos/{cargoID}")
    public String removeCargo(@PathVariable int cargoID, @PathVariable int orderID) {
        return transportOrderService.removeCargo(cargoID, orderID);
    }

    @PutMapping("transport-orders/{orderID}/add/passengers/{passengerID}")
    public String addPassengerToOrder(@PathVariable int passengerID, @PathVariable int orderID) {
        return transportOrderService.addPassengerToOrder(passengerID, orderID);
    }

    @PutMapping("transport-orders/{orderID}/remove/passengers/{passengerID}")
    public String removePassenger(@PathVariable int passengerID, @PathVariable int orderID) {
        return transportOrderService.removePassenger(passengerID, orderID);
    }
}
