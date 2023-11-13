package com.ayseozcan.repository;

import com.ayseozcan.repository.entity.Income;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IIncomeRepository extends MongoRepository<Income, String> {
    List<Income> findAllByUserId(String userId);
}
