package com.example.sct.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transports")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transport")
    private int id;
    @Column(name = "mark")
    private String mark;
    @Column(name = "model")
    private String model;
    @Column(name = "fuel")
    @Enumerated(EnumType.STRING)
    private Fuel fuel;
    @Column(name = "consumption")
    private int consumption;
    @Column(name = "yearOfIssue")
    private int yearOfIssue;
    @Column(name = "fullTank")
    private boolean fullTank;
    @Column(name = "status")
    Status status = Status.READY;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transport", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    List<TransportOrder> orderList = new ArrayList<>();

    public abstract boolean addOrderToTransport(TransportOrder transportOrder);

    public boolean removeOrder (TransportOrder transportOrder) {
        if (orderList.contains(transportOrder)) {
            orderList.remove(transportOrder);
            transportOrder.setTransport(null);
            return true;
        }
        return false;
    }


}

