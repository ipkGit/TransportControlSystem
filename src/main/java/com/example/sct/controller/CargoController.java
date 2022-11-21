package com.example.sct.controller;

import com.example.sct.entity.Cargo;
import com.example.sct.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CargoController {
    @Autowired
    CargoService cargoService;

    @GetMapping("/cargos")
    public List<Cargo> showCargos() {
        return cargoService.getAllCargo();
    }

    @PostMapping("/cargos")
    public Cargo createNewCargo(@RequestBody Cargo cargo) {
        return cargoService.saveCargo(cargo);
    }

    @GetMapping("/cargos/{id}")
    public Cargo showCargoById(@PathVariable int id) {
        return cargoService.getCargoById(id);
    }
}
