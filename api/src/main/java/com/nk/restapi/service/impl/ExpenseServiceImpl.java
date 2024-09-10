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

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ExpensDto> getAllExpense() {
        List<ExpenseEntity> list = expenseRepository.findAll();
        List<ExpensDto> listOfExpense = list.stream().map(expensEntity -> mapToExpensDto(expensEntity))
                .collect(Collectors.toList());
        return listOfExpense;
    }

    private ExpensDto mapToExpensDto(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity, ExpensDto.class);
    }

}
