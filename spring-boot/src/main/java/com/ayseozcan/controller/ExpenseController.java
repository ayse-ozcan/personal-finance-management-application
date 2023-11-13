package com.ayseozcan.controller;

import com.ayseozcan.dto.request.ExpenseSaveRequestDto;
import com.ayseozcan.dto.request.ExpenseUpdateRequestDto;
import com.ayseozcan.dto.response.FindExpenseResponseDto;
import com.ayseozcan.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.ayseozcan.constant.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(EXPENSE)
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<Boolean> save(@RequestBody @Valid ExpenseSaveRequestDto dto) {
        return ResponseEntity.ok(expenseService.save(dto));
    }

    @GetMapping(FIND_BY_ID + "/{token}")
    @CrossOrigin("*")
    public ResponseEntity<List<FindExpenseResponseDto>> findAllByUserId(@PathVariable String token) {
        return ResponseEntity.ok(expenseService.findAllExpenseByUserId(token));
    }

    @PutMapping(UPDATE)
    @CrossOrigin("*")
    public ResponseEntity<Boolean> update(@RequestBody @Valid ExpenseUpdateRequestDto dto) {
        return ResponseEntity.ok(expenseService.update(dto));
    }

    @DeleteMapping(DELETE + "/{expenseId}")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> delete(@PathVariable String expenseId) {
        return ResponseEntity.ok(expenseService.delete(expenseId));
    }

    @GetMapping(FIND_SUM_OF_EXPENSE + "/{token}")
    public ResponseEntity<Double> sumExpense(@PathVariable String token) {
        return ResponseEntity.ok(expenseService.sumExpense(token));
    }
}
