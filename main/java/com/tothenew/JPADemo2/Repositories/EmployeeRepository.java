package com.tothenew.JPADemo2.Repositories;

import com.tothenew.JPADemo2.Entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}
