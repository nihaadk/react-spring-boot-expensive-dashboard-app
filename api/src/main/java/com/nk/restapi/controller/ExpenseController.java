package com.nk.restapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nk.restapi.dto.ExpensDto;
import com.nk.restapi.io.ExpenseResponse;
import com.nk.restapi.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@RestController()
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;

    @GetMapping("/expensess")
    public List<ExpenseResponse> getExpenses() {
        List<ExpensDto> expenses = expenseService.getAllExpense();
        List<ExpenseResponse> listOfExpenseResponse = expenses.stream()
                .map(expensDto -> mapToExpenseResponse(expensDto))
                .collect(Collectors.toList());

        return listOfExpenseResponse;
    }

    private ExpenseResponse mapToExpenseResponse(ExpensDto expensDto) {
        return modelMapper.map(expensDto, ExpenseResponse.class);
    }

}
