package com.nk.restapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nk.restapi.dto.ExpensDto;
import com.nk.restapi.io.ExpenseResponse;
import com.nk.restapi.service.ExpenseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This is Controller for Expense module
 * 
 * @author Nihad K.
 */
@RestController()
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;

    /**
     * Fetch all expenses from the database
     * 
     * @return List of ExpenseResponse
     */
    @GetMapping("/expensess")
    public List<ExpenseResponse> getExpenses() {
        log.info("API GET /expensess called");

        List<ExpensDto> expenses = expenseService.getAllExpense();

        log.info("Printing the data from service {}", expenses);

        List<ExpenseResponse> listOfExpenseResponse = expenses.stream()
                .map(expensDto -> mapToExpenseResponse(expensDto))
                .collect(Collectors.toList());

        return listOfExpenseResponse;
    }

    /**
     * Mapper method for converting ExpensDto to ExpenseResponse
     * 
     * @param expensDto
     * @return ExpenseResponse
     */
    private ExpenseResponse mapToExpenseResponse(ExpensDto expensDto) {
        return modelMapper.map(expensDto, ExpenseResponse.class);
    }

}
