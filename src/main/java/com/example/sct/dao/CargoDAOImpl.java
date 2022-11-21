package com.example.sct.dao;

import com.example.sct.entity.Cargo;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CargoDAOImpl implements CargoDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public Cargo saveCargo(Cargo cargo) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(cargo);
        return cargo;
    }

    @Override
    public List<Cargo> getAllCargo() {
        Session session = entityManager.unwrap(Session.class);
        Query<Cargo> query = session.createQuery("from Cargo", Cargo.class);
        return query.getResultList();
    }

    @Override
    public Cargo getCargoById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Cargo.class, id);
    }
}
