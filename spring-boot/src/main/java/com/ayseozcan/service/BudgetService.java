package com.ayseozcan.service;

import com.ayseozcan.exception.ErrorType;
import com.ayseozcan.exception.FinanceManagementException;
import com.ayseozcan.repository.IBudgetRepository;
import com.ayseozcan.repository.entity.Budget;
import com.ayseozcan.utility.JwtProvider;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BudgetService extends ServiceManager<Budget, String> {
    private final IBudgetRepository budgetRepository;
    private final ExpenseService expenseService;
    private final IncomeService incomeService;
    private final JwtProvider jwtProvider;

    public BudgetService(IBudgetRepository budgetRepository, ExpenseService expenseService, IncomeService incomeService, JwtProvider jwtProvider) {
        super(budgetRepository);
        this.budgetRepository = budgetRepository;
        this.expenseService = expenseService;
        this.incomeService = incomeService;
        this.jwtProvider = jwtProvider;
    }

    public Double calculateBudget(String token) {
        Optional<String> userId = jwtProvider.getByIdFromToken(token);
        if (userId.isEmpty()) {
            throw new FinanceManagementException(ErrorType.INVALID_TOKEN);
        }
        Budget budget = new Budget();
        budget.setAmount(incomeService.sumIncome(token) - expenseService.sumExpense(token));
        double total = budget.getAmount();
        return total;
    }
}

