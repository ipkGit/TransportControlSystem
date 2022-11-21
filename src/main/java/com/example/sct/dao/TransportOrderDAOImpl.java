package com.example.sct.dao;

import com.example.sct.entity.Cargo;
import com.example.sct.entity.Passenger;
import com.example.sct.entity.TransportOrder;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TransportOrderDAOImpl implements TransportOrderDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public TransportOrder saveTransportOrder(TransportOrder transportOrder) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(transportOrder);
        return transportOrder;
    }

    @Override
    public List<TransportOrder> getAllTransportOrders() {
        Session session = entityManager.unwrap(Session.class);
        Query<TransportOrder> query = session.createQuery("from TransportOrder", TransportOrder.class);
        return query.getResultList();
    }

    @Override
    public TransportOrder getTransportOrderById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(TransportOrder.class, id);
    }

    @Override
    public String addCargoToOrder(int cargoID, int orderID) {
        Session session = entityManager.unwrap(Session.class);
        Cargo cargo = session.get(Cargo.class, cargoID);
        TransportOrder order = session.get(TransportOrder.class, orderID);
        if (cargo != null || order != null) {
            if (order.addCargoToOrder(cargo)) {
                session.saveOrUpdate(order);
                return "successful";
            }
        }
        return "failed";
    }

    @Override
    public String addPassengerToOrder(int passengerID, int orderID) {
        Session session = entityManager.unwrap(Session.class);
        Passenger passenger = session.get(Passenger.class, passengerID);
        TransportOrder order = session.get(TransportOrder.class, orderID);
        if (passenger == null || order == null) {
            return "false";
        }
        if (order.addPassengerToOrder(passenger)) {
            session.saveOrUpdate(passenger);
            return "successful";
        }
        return "false";
    }

    @Override
    public String removePassenger(int passengerID, int orderID) {
        Session session = entityManager.unwrap(Session.class);
        Passenger passenger = session.get(Passenger.class, passengerID);
        TransportOrder order = session.get(TransportOrder.class, orderID);
        if (passenger == null || order == null) {
            return "false";
        }
        if (order.removePassenger(passenger)) {
            session.saveOrUpdate(passenger);
            return "successful";
        }
        return "false";
    }

    @Override
    public String removeCargo(int cargoID, int orderID) {
        Session session = entityManager.unwrap(Session.class);
        Cargo cargo = session.get(Cargo.class, cargoID);
        TransportOrder order = session.get(TransportOrder.class, orderID);
        if (cargo == null || order == null) {
            return "false";
        }
        if (order.removeCargo(cargo)) {
            session.saveOrUpdate(order);
            return "successful";
        }
        return "false";
    }
}
