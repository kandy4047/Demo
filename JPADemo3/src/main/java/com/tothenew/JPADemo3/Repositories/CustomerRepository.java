package com.tothenew.JPADemo3.Repositories;

import com.tothenew.JPADemo3.Entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Customer findOne(long l);

    void delete(long l);
}
