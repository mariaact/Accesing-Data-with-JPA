package org.mcalvot.formacion.AccesingDataWithJPA;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String fisrt_name;
    private String last_name;

    protected Customer(){}

    public Customer(long id, String fisrt_name, String last_name) {
        this.id = id;
        this.fisrt_name = fisrt_name;
        this.last_name = last_name;
    }
}
