package com.ayseozcan.service;

import com.ayseozcan.dto.request.ExpenseSaveRequestDto;
import com.ayseozcan.dto.request.ExpenseUpdateRequestDto;
import com.ayseozcan.dto.response.FindExpenseResponseDto;
import com.ayseozcan.dto.response.GetExpenseAmountResponseDto;
import com.ayseozcan.exception.ErrorType;
import com.ayseozcan.exception.FinanceManagementException;
import com.ayseozcan.mapper.IExpenseMapper;
import com.ayseozcan.repository.IExpenseRepository;
import com.ayseozcan.repository.entity.Expense;
import com.ayseozcan.utility.JwtProvider;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService extends ServiceManager<Expense, String> {
    private final IExpenseRepository expenseRepository;
    private final JwtProvider jwtProvider;
    private final IExpenseMapper iExpenseMapper;

    public ExpenseService(IExpenseRepository expenseRepository, JwtProvider jwtProvider, IExpenseMapper iExpenseMapper) {
        super(expenseRepository);
        this.expenseRepository = expenseRepository;
        this.jwtProvider = jwtProvider;
        this.iExpenseMapper = iExpenseMapper;
    }

    public Boolean save(ExpenseSaveRequestDto dto) {
        Optional<String> userId = jwtProvider.getByIdFromToken(dto.getToken());
        if (userId.isEmpty()) {
            throw new FinanceManagementException(ErrorType.INVALID_TOKEN);
        }
        Expense expense = iExpenseMapper.fromExpenseSaveRequestDtoToExpense(dto);
        expense.setUserId(userId.get());
        save(expense);
        return true;
    }

    public List<FindExpenseResponseDto> findAllExpenseByUserId(String token) {
        Optional<String> userId = jwtProvider.getByIdFromToken(token);
        if (userId.isEmpty()) {
            throw new FinanceManagementException(ErrorType.INVALID_TOKEN);
        }
        return expenseRepository.findAllByUserId(userId.get()).stream().map(iExpenseMapper::fromExpenseToFindExpenseResponseDto).toList();
    }

    public Boolean update(ExpenseUpdateRequestDto dto) {
        Optional<Expense> optionalExpense = expenseRepository.findById(dto.getExpenseId());
        if (optionalExpense.isPresent()) {
            update(iExpenseMapper.fromExpenseUpdateRequestDtoToExpense(dto, optionalExpense.get()));
            return true;
        }
        throw new FinanceManagementException(ErrorType.EXPENSE_NOT_FOUND);
    }

    public Boolean delete(String expenseId) {
        Optional<Expense> optionalExpense = expenseRepository.findById(expenseId);
        if (optionalExpense.isPresent()) {
            expenseRepository.deleteById(expenseId);
            return true;
        }
        throw new FinanceManagementException(ErrorType.EXPENSE_NOT_FOUND);
    }

    public Double sumExpense(String token) {
        Optional<String> userId = jwtProvider.getByIdFromToken(token);
        if (userId.isEmpty()) {
            throw new FinanceManagementException(ErrorType.INVALID_TOKEN);
        }
        double expenses = expenseRepository.findAllByUserId(userId.get()).stream()
                .map(iExpenseMapper::fromExpenseToGetExpenseAmountResponseDto).mapToDouble(GetExpenseAmountResponseDto::getAmount).sum();
        return expenses;
    }
}
