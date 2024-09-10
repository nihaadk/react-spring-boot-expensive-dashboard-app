package com.nk.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nk.restapi.entity.ExpenseEntity;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

}
