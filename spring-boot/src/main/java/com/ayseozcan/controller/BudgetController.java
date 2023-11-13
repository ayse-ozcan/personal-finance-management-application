package com.ayseozcan.controller;

import com.ayseozcan.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ayseozcan.constant.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(BUDGET)
public class BudgetController {
    private final BudgetService budgetService;
    @PostMapping(CALCULATE_BUDGET + "/{token}")
    @CrossOrigin("*")
    public ResponseEntity<Double> calculateBudget(@PathVariable String token){
      return ResponseEntity.ok(budgetService.calculateBudget(token));
    }
}
