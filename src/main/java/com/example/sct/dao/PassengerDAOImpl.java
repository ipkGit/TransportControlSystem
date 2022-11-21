package com.example.sct.dao;

import com.example.sct.entity.Passenger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PassengerDAOImpl implements PassengerDAO {

    @Autowired
    EntityManager entityManager;
    @Override
    public Passenger savePassenger(Passenger passenger) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(passenger);
        return passenger;
    }

    @Override
    public List<Passenger> getAllPassengers() {
        Session session = entityManager.unwrap(Session.class);
        Query<Passenger> query = session.createQuery("from Passenger", Passenger.class);
        return query.getResultList();
    }

    @Override
    public Passenger getPassengerById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Passenger.class, id);
    }
}
