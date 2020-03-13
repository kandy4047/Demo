package com.tothenew.JPADemo3.Repositories;

import com.tothenew.JPADemo3.Entities.License;
import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License,Long> {
}
