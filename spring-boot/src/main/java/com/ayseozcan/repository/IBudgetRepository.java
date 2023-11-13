package com.ayseozcan.repository;

import com.ayseozcan.repository.entity.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBudgetRepository extends MongoRepository<Budget, String> {

}
