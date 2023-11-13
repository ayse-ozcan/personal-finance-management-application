package com.ayseozcan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseUpdateRequestDto {
    @NotEmpty
    private String expenseId;
    @NotNull
    private double amount;
    private String description;
    private String category;
}
