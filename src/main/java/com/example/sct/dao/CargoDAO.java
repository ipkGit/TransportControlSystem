package com.example.sct.dao;

import com.example.sct.entity.Cargo;

import java.util.List;

public interface CargoDAO {
    Cargo saveCargo (Cargo cargo);

    List<Cargo> getAllCargo ();

    Cargo getCargoById (int id);
}
