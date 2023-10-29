package com.ayseozcan.controller;

import com.ayseozcan.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ayseozcan.constant.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(INCOME)
public class IncomeController {
    private final IncomeService incomeService;
}
