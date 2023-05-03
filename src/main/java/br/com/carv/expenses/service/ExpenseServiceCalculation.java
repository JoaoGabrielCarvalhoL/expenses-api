package br.com.carv.expenses.service;

import br.com.carv.expenses.model.enumerated.Category;
import br.com.carv.expenses.model.dto.response.ExpenseSimpleResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseServiceCalculation extends ExpenseQueryService{

    BigDecimal totalAmountExpensesInPeriod(LocalDate start, LocalDate end);
    List<ExpenseSimpleResponse> findExpensesInPeriod(LocalDate start, LocalDate end);
    BigDecimal totalAmountExpensesByCategoryInPeriod(LocalDate start, LocalDate end, Category category);
    List<ExpenseSimpleResponse> findAllExpensesByCategoryInPeriod(LocalDate start, LocalDate end, Category category);
    List<ExpenseSimpleResponse> findAllBillsExpensesInPeriod(LocalDate start, LocalDate end);
    BigDecimal totalAmountAllBillExpensesInPeriod(LocalDate start, LocalDate end);
}
