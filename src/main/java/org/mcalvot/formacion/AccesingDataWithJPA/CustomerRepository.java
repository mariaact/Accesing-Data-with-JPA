package org.mcalvot.formacion.AccesingDataWithJPA;


import org.springframework.data.repository.CrudRepository;

import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    List<Customer> findByFirstName(String firstName);

    @ManyToMany
    @OrderBy("firstName ASC")
    List<Customer> findAllByOrderByFirstNameAsc();

}
