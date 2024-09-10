package com.nk.restapi.service;

import java.util.List;

import com.nk.restapi.dto.ExpensDto;

public interface ExpenseService {

    List<ExpensDto> getAllExpense();
}
