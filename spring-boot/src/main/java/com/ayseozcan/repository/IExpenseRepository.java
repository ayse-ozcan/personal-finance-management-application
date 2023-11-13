package com.ayseozcan.repository;

import com.ayseozcan.repository.entity.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExpenseRepository extends MongoRepository<Expense, String> {
    List<Expense> findAllByUserId(String userId);
}
