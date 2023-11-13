package com.ayseozcan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IncomeUpdateRequestDto {
    @NotEmpty
    private String incomeId;
    @NotNull
    private double amount;
    private String description;
    private String category;
}
