package com.nk.restapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.nk.restapi.dto.ExpensDto;
import com.nk.restapi.entity.ExpenseEntity;
import com.nk.restapi.repository.ExpenseRepository;
import com.nk.restapi.service.ExpenseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * This is Service Implementation for Expense module
 * 
 * @author Nihad K.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    /**
     * Fetch all expenses from the database
     * 
     * @return List of ExpensDto
     */
    @Override
    public List<ExpensDto> getAllExpense() {

        List<ExpenseEntity> list = expenseRepository.findAll();

        log.info("Printing the data from repository {}", list);

        List<ExpensDto> listOfExpense = list.stream().map(expensEntity -> mapToExpensDto(expensEntity))
                .collect(Collectors.toList());
        return listOfExpense;
    }

    /**
     * Mapper method for converting ExpenseEntity to ExpensDto
     * 
     * @param expenseEntity
     * @return ExpensDto
     */
    private ExpensDto mapToExpensDto(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity, ExpensDto.class);
    }

}
