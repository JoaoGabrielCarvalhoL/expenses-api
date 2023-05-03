package br.com.carv.expenses.controller.impl;

import br.com.carv.expenses.controller.ExpenseControllerInfo;
import br.com.carv.expenses.model.enumerated.Category;
import br.com.carv.expenses.model.dto.response.ExpenseSimpleResponse;
import br.com.carv.expenses.service.ExpenseServiceCalculation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("expense/info")
public class ExpenseControllerInfoImpl implements ExpenseControllerInfo {

    private final ExpenseServiceCalculation expenseService;

    public ExpenseControllerInfoImpl(ExpenseServiceCalculation expenseServiceCalculation) {
        this.expenseService = expenseServiceCalculation;
    }

    @Override
    public ResponseEntity<List<ExpenseSimpleResponse>> findExpenseByNameIgnoreCase(String name, Pageable pageable) {
        return new ResponseEntity<>(this.expenseService.findByNameIgnoreCase(name, pageable), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ExpenseSimpleResponse>> findExpenseByNameContaining(String name, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.expenseService.findByNameContaining(name, pageable));
    }

    @Override
    public ResponseEntity<List<ExpenseSimpleResponse>> findExpenseByCategory(Category category, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.expenseService.findByCategory(category, pageable));
    }

    @Override
    public ResponseEntity<List<ExpenseSimpleResponse>> findExpenseByDescriptionContaining(String description, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.expenseService.findByDescriptionContaining(description, pageable));
    }

    @Override
    public ResponseEntity<List<ExpenseSimpleResponse>> findExpenseByDateBetween(LocalDate start, LocalDate end, Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.expenseService.findByDateBetween(start, end, pageable));
    }

    @Override
    public ResponseEntity<BigDecimal> totalAmountExpensesInPeriod(LocalDate start, LocalDate end) {
        return ResponseEntity.ok(this.expenseService.totalAmountExpensesInPeriod(start, end));
    }

    @Override
    public ResponseEntity<BigDecimal> totalAmountExpensesInPeriodByCategory(LocalDate start, LocalDate end, Category category) {
        return ResponseEntity.status(HttpStatus.OK).body(this.expenseService.totalAmountExpensesByCategoryInPeriod(start, end, category));
    }

    @Override
    public ResponseEntity<List<ExpenseSimpleResponse>> findAllBillExpenseInPeriod(LocalDate start, LocalDate end) {
        return ResponseEntity.status(HttpStatus.OK).body(this.expenseService.findAllBillsExpensesInPeriod(start, end));
    }

    @Override
    public ResponseEntity<BigDecimal> totalAmountBillExpensesInPeriod(LocalDate start, LocalDate end) {
        return ResponseEntity.status(HttpStatus.OK).body(this.expenseService.totalAmountAllBillExpensesInPeriod(start, end));
    }
}
