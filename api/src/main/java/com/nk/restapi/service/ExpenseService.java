package com.nk.restapi.service;

import java.util.List;

import com.nk.restapi.dto.ExpensDto;

/**
 * This is Service for Expense module
 * 
 * @author Nihad K.
 */
public interface ExpenseService {

    /**
     * Fetch all expenses from the database
     * 
     * @return List of ExpensDto
     */
    List<ExpensDto> getAllExpense();
}
