package com.example.sct.service;


import com.example.sct.entity.Cargo;

import java.util.List;

public interface CargoService {
    Cargo saveCargo (Cargo cargo);

    List<Cargo> getAllCargo ();

    Cargo getCargoById (int id);
}
