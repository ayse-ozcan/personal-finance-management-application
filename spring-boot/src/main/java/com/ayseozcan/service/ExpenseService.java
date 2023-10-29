package com.ayseozcan.service;

import com.ayseozcan.repository.IExpenseRepository;
import com.ayseozcan.repository.entity.Expense;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService extends ServiceManager<Expense, String> {
    private final IExpenseRepository expenseRepository;

    public ExpenseService(IExpenseRepository expenseRepository) {
        super(expenseRepository);
        this.expenseRepository = expenseRepository;
    }
}
