package com.ayseozcan.mapper;

import com.ayseozcan.dto.request.ExpenseSaveRequestDto;
import com.ayseozcan.dto.request.ExpenseUpdateRequestDto;
import com.ayseozcan.dto.response.FindExpenseResponseDto;
import com.ayseozcan.dto.response.GetExpenseAmountResponseDto;
import com.ayseozcan.repository.entity.Expense;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IExpenseMapper {

    IExpenseMapper INSTANCE = Mappers.getMapper(IExpenseMapper.class);

    Expense fromExpenseSaveRequestDtoToExpense(final ExpenseSaveRequestDto dto);

    FindExpenseResponseDto fromExpenseToFindExpenseResponseDto(final Expense expense);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Expense fromExpenseUpdateRequestDtoToExpense(final ExpenseUpdateRequestDto dto, @MappingTarget Expense expense);

    GetExpenseAmountResponseDto fromExpenseToGetExpenseAmountResponseDto(final Expense expense);
}
