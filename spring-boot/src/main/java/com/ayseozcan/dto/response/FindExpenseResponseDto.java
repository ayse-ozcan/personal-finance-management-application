package com.ayseozcan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindExpenseResponseDto {
    private String expenseId;
    private double amount;
    private String description;
    private String category;
}
