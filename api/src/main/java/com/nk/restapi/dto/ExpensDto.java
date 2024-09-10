package com.nk.restapi.dto;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpensDto {

    private String expenseId;

    private String name;

    private String note;

    private String category;

    private Date date;

    private BigDecimal amount;

    private Timestamp createdAt;

    private Timestamp updatedAt;

}
