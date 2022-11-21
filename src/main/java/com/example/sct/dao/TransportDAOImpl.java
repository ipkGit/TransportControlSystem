package com.example.sct.dao;

import com.example.sct.entity.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TransportDAOImpl implements TransportDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public Transport saveCargoTransport(Transport cargoTransport) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(cargoTransport);
        return cargoTransport;
    }

    @Override
    public Transport savePassengerTransport(Transport passengerTransport) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(passengerTransport);
        return passengerTransport;
    }

    @Override
    public Transport saveCargoPassTransport(Transport cargoPassengerTransport) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(cargoPassengerTransport);
        return cargoPassengerTransport;
    }

    @Override
    public List<Transport> getAllTransport() {
        Session session = entityManager.unwrap(Session.class);
        Query<Transport> query = session.createQuery("from Transport order by id", Transport.class);
        return query.getResultList();
    }

    @Override
    public List<Transport> getOnlyCargoTransport() {
        Session session = entityManager.unwrap(Session.class);
        Query<Transport> query = session.createQuery("from CargoTransport", Transport.class);
        return query.getResultList();
    }

    @Override
    public List<Transport> getOnlyPassengerTransport() {
        Session session = entityManager.unwrap(Session.class);
        Query<Transport> query = session.createQuery("from PassengerTransport", Transport.class);
        return query.getResultList();
    }

    @Override
    public List<Transport> getOnlyCargoPassTransport() {
        Session session = entityManager.unwrap(Session.class);
        Query<Transport> query = session.createQuery("from CargoPassengerTransport", Transport.class);
        return query.getResultList();
    }

    @Override
    public Transport getTransportByID(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Transport.class, id);
    }

    @Override
    public String refuelTank(int id) {
        Session session = entityManager.unwrap(Session.class);
        Transport transport = session.get(Transport.class, id);
        if (transport == null) {
            return "Transport with id: " + id + " is not exist";
        }
        if (!transport.isFullTank()) {
            transport.setFullTank(true);
            session.saveOrUpdate(transport);
            System.out.println(transport.isFullTank());

            String result = "Transport id: " + transport.getId() + " " + transport.getMark() + " successfully filled";
            return result;
        }

        String result = "Transport id: " + transport.getId() + " " + transport.getMark() + " does not require refueling";
        return result;
    }

    @Override
    public String disinfectedSalon(int id) {
        Session session = entityManager.unwrap(Session.class);
        Transport transport = session.get(Transport.class, id);
        if (transport == null) {
            return "Transport with id: " + id + " is not exist";
        }
        if (transport instanceof ForPassenger) {
            if (((ForPassenger) transport).isDisinfected()) {
                return "Salon of transport id: " + transport.getId() +
                        " " + transport.getMark() + " " + transport.getModel() +
                        " already disinfected";
            }
            ((ForPassenger) transport).disinfectedSalon(true);
            session.saveOrUpdate(transport);
            return "Salon of transport id: " + transport.getId() +
                    " " + transport.getMark() + " " + transport.getModel() +
                    " successfully disinfected";
        }
        return "Transport id: " + transport.getId() +
                " " + transport.getMark() + " " + transport.getModel() +
                " has no salon. Please choose the right one transport option";
    }

    @Override
    public String sealUp(int id) {
        Session session = entityManager.unwrap(Session.class);
        Transport transport = session.get(Transport.class, id);
        if (transport == null) {
            return "Transport with id: " + id + " is not exist";
        }
        if (transport instanceof ForCargo) {
            if (((ForCargo) transport).isSealed()) {
                return "Cargo compartment of transport id: " + transport.getId() +
                        " " + transport.getMark() + " " + transport.getModel() +
                        " already sealed";
            }
            ((ForCargo) transport).sealUP(true);
            session.saveOrUpdate(transport);
            return "Cargo compartment of transport id: " + transport.getId() +
                    " " + transport.getMark() + " " + transport.getModel() +
                    " successfully sealed";
        }
        return "id: " + transport.getId() +
                " " + transport.getMark() + " " + transport.getModel() + " inappropriate transport";
    }

    @Override
    public String addOrderToTransport(int transportID, int orderID) {
        Session session = entityManager.unwrap(Session.class);
        Transport transport = session.get(Transport.class, transportID);
        TransportOrder order = session.get(TransportOrder.class, orderID);
        if (transport != null && order != null) {
            if (transport.addOrderToTransport(order)) {
                session.saveOrUpdate(transport);
                return "successful";
            }
        }
        return "failed";
    }

    @Override
    public String removeOrder(int transportID, int orderID) {
        Session session = entityManager.unwrap(Session.class);
        Transport transport = session.get(Transport.class, transportID);
        TransportOrder order = session.get(TransportOrder.class, orderID);
        if (transport != null && order != null) {
            if (transport.removeOrder(order)) {
                session.saveOrUpdate(transport);
                return "successful";
            }
        }
        return "failed";
    }

    @Override
    public String repair(int id) {
        Session session = entityManager.unwrap(Session.class);
        Transport transport = session.get(Transport.class, id);
        if (transport == null) {
            return "Transport with id: " + id + " is not exist";
        }
        if (transport.getStatus() == Status.OUT_OF_ORDER) {
            transport.setStatus(Status.READY);
            session.saveOrUpdate(transport);
            System.out.println(transport.isFullTank());

            String result = "Transport id: " + transport.getId() + " " + transport.getMark() + " successfully repaired";
            return result;
        }

        String result = "Transport id: " + transport.getId() + " " + transport.getMark() + " does not require repair";
        return result;
    }


}
