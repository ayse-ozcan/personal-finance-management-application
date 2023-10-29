package com.ayseozcan.service;

import com.ayseozcan.repository.IIncomeRepository;
import com.ayseozcan.repository.entity.Income;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class IncomeService extends ServiceManager<Income, String> {
    private final IIncomeRepository incomeRepository;

    public IncomeService(IIncomeRepository incomeRepository) {
        super(incomeRepository);
        this.incomeRepository = incomeRepository;
    }
}
