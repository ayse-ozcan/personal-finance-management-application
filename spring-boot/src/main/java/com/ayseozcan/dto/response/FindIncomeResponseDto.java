package com.ayseozcan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindIncomeResponseDto {
    private String incomeId;
    private double amount;
    private String description;
    private String category;
}
