package com.tothenew.JPADemo2.Repositories;

import com.tothenew.JPADemo2.Entities.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction,Integer> {
}
