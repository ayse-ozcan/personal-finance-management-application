package com.ayseozcan.service;

import com.ayseozcan.repository.IBudgetRepository;
import com.ayseozcan.repository.entity.Budget;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class BudgetService extends ServiceManager<Budget, String> {
    private final IBudgetRepository budgetRepository;

    public BudgetService(IBudgetRepository budgetRepository) {
        super(budgetRepository);
        this.budgetRepository = budgetRepository;
    }
}
