package com.ayseozcan.repository;

import com.ayseozcan.repository.entity.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpenseRepository extends MongoRepository<Expense, String> {
}
