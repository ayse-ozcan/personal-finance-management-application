package com.ayseozcan.mapper;

import com.ayseozcan.dto.request.IncomeSaveRequestDto;
import com.ayseozcan.dto.request.IncomeUpdateRequestDto;
import com.ayseozcan.dto.response.FindIncomeResponseDto;
import com.ayseozcan.dto.response.GetIncomeAmountResponseDto;
import com.ayseozcan.repository.entity.Income;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IIncomeMapper {
    IIncomeMapper INSTANCE = Mappers.getMapper(IIncomeMapper.class);

    Income fromIncomeSaveRequestDtoToIncome(final IncomeSaveRequestDto dto);

    FindIncomeResponseDto fromIncomeToFindIncomeResponseDto(final Income income);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Income fromIncomeUpdateRequestDtoToIncome(final IncomeUpdateRequestDto dto, @MappingTarget Income income);

    GetIncomeAmountResponseDto fromIncomeToGetIncomeAmountResponseDto(final Income income);
}
