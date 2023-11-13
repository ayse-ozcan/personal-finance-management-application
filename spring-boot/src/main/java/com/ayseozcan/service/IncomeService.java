package com.ayseozcan.service;

import com.ayseozcan.dto.request.IncomeSaveRequestDto;
import com.ayseozcan.dto.request.IncomeUpdateRequestDto;
import com.ayseozcan.dto.response.FindIncomeResponseDto;
import com.ayseozcan.dto.response.GetIncomeAmountResponseDto;
import com.ayseozcan.exception.ErrorType;
import com.ayseozcan.exception.FinanceManagementException;
import com.ayseozcan.mapper.IIncomeMapper;
import com.ayseozcan.repository.IIncomeRepository;
import com.ayseozcan.repository.entity.Income;
import com.ayseozcan.utility.JwtProvider;
import com.ayseozcan.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService extends ServiceManager<Income, String> {
    private final IIncomeRepository incomeRepository;
    private final JwtProvider jwtProvider;
    private final IIncomeMapper iIncomeMapper;

    public IncomeService(IIncomeRepository incomeRepository, JwtProvider jwtProvider, IIncomeMapper iIncomeMapper) {
        super(incomeRepository);
        this.incomeRepository = incomeRepository;
        this.jwtProvider = jwtProvider;

        this.iIncomeMapper = iIncomeMapper;
    }

    public Boolean save(IncomeSaveRequestDto dto) {
        Optional<String> userId = jwtProvider.getByIdFromToken(dto.getToken());
        if (userId.isEmpty()) {
            throw new FinanceManagementException(ErrorType.INVALID_TOKEN);
        }
        Income income = iIncomeMapper.fromIncomeSaveRequestDtoToIncome(dto);
        income.setUserId(userId.get());
        save(income);
        return true;
    }

    public List<FindIncomeResponseDto> findAllByUserId(String token) {
        Optional<String> userId = jwtProvider.getByIdFromToken(token);
        if (userId.isEmpty()) {
            throw new FinanceManagementException(ErrorType.INVALID_TOKEN);
        }
        return incomeRepository.findAllByUserId(userId.get()).stream().map(iIncomeMapper::fromIncomeToFindIncomeResponseDto).toList();
    }

    public Boolean update(IncomeUpdateRequestDto dto) {
        Optional<Income> optionalIncome = incomeRepository.findById(dto.getIncomeId());
        if (optionalIncome.isPresent()) {
            update(iIncomeMapper.fromIncomeUpdateRequestDtoToIncome(dto, optionalIncome.get()));
            return true;
        }
        throw new FinanceManagementException(ErrorType.INCOME_NOT_FOUND);
    }

    public Boolean delete(String incomeId) {
        Optional<Income> optionalIncome = incomeRepository.findById(incomeId);
        if (optionalIncome.isPresent()) {
            incomeRepository.deleteById(incomeId);
            return true;
        }
        throw new FinanceManagementException(ErrorType.INCOME_NOT_FOUND);
    }

    public Double sumIncome(String token) {
        Optional<String> userId = jwtProvider.getByIdFromToken(token);
        if (userId.isEmpty()) {
            throw new FinanceManagementException(ErrorType.INVALID_TOKEN);
        }
        double incomes = incomeRepository.findAllByUserId(userId.get()).stream().map(iIncomeMapper::fromIncomeToGetIncomeAmountResponseDto)
                .mapToDouble(GetIncomeAmountResponseDto::getAmount).sum();
        return incomes;
    }
}
