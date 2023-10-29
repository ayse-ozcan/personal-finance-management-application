package com.ayseozcan.controller;

import com.ayseozcan.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ayseozcan.constant.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(BUDGET)
public class BudgetController {
    private final BudgetService budgetService;
}
