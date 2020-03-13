package com.tothenew.JPADemo3.Repositories;

import com.tothenew.JPADemo3.Entities.Programmer;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammerRepository extends CrudRepository<Programmer,Integer> {
    Programmer findOne(int i);
}
