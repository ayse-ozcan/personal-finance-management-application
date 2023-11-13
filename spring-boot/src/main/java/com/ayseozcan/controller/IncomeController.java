package com.ayseozcan.controller;

import com.ayseozcan.dto.request.IncomeSaveRequestDto;
import com.ayseozcan.dto.request.IncomeUpdateRequestDto;
import com.ayseozcan.dto.response.FindIncomeResponseDto;
import com.ayseozcan.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.ayseozcan.constant.ApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(INCOME)
public class IncomeController {
    private final IncomeService incomeService;

    @PostMapping(SAVE)
    @CrossOrigin("*")
    public ResponseEntity<Boolean> save(@RequestBody @Valid IncomeSaveRequestDto dto) {
        return ResponseEntity.ok(incomeService.save(dto));
    }

    @GetMapping(FIND_BY_ID + "/{token}")
    @CrossOrigin("*")
    public ResponseEntity<List<FindIncomeResponseDto>> findAllByUserId(@PathVariable String token) {
        return ResponseEntity.ok(incomeService.findAllByUserId(token));
    }

    @PutMapping(UPDATE)
    @CrossOrigin("*")
    public ResponseEntity<Boolean> update(@RequestBody @Valid IncomeUpdateRequestDto dto) {
        return ResponseEntity.ok(incomeService.update(dto));
    }

    @DeleteMapping(DELETE + "/{incomeId}")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> delete(@PathVariable String incomeId) {
        return ResponseEntity.ok(incomeService.delete(incomeId));
    }

    @GetMapping(FIND_SUM_OF_INCOME + " /{token}")
    public ResponseEntity<Double> sumIncome(@PathVariable String token) {
        return ResponseEntity.ok(incomeService.sumIncome(token));
    }
}
