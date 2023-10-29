package com.ayseozcan.controller;

import com.ayseozcan.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ayseozcan.constant.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(EXPENSE)
public class ExpenseController {
    private final ExpenseService expenseService;
}
