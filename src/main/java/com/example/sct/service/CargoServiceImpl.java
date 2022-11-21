package com.example.sct.service;

import com.example.sct.dao.CargoDAO;
import com.example.sct.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    CargoDAO cargoDAO;

    @Override
    @Transactional
    public Cargo saveCargo(Cargo cargo) {
        return cargoDAO.saveCargo(cargo);
    }

    @Override
    @Transactional
    public List<Cargo> getAllCargo() {
        return cargoDAO.getAllCargo();
    }

    @Override
    @Transactional
    public Cargo getCargoById(int id) {
        return cargoDAO.getCargoById(id);
    }
}
