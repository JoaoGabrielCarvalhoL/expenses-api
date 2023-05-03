package br.com.carv.expenses.service.impl;

import br.com.carv.expenses.mapper.ExpenseMapper;
import br.com.carv.expenses.model.enumerated.Category;
import br.com.carv.expenses.model.Expense;
import br.com.carv.expenses.model.dto.response.ExpenseSimpleResponse;
import br.com.carv.expenses.repository.ExpenseRepository;
import br.com.carv.expenses.service.ExpenseServiceCalculation;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceInfoImpl implements ExpenseServiceCalculation {

    private final Logger logger = Logger.getLogger(ExpenseServiceInfoImpl.class.getCanonicalName());
    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    public ExpenseServiceInfoImpl(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
    }

    @Override
    public List<ExpenseSimpleResponse> findByNameIgnoreCase(String name, Pageable pageable) {
        logger.info("Getting expenses by name: " + name);
        List<Expense> expenses = expenseRepository.findByNameIgnoreCase(name, pageable).toList();
        return expenses.stream().map(expenseMapper::toExpenseSimpleResponse).collect(Collectors.toList());
    }

    @Override
    public List<ExpenseSimpleResponse> findByCategory(Category category, Pageable pageable) {
        logger.info("Getting expenses by category: " + category);
        List<Expense> expenses = expenseRepository.findByCategory(category, pageable).toList();
        return expenses.stream().map(expenseMapper::toExpenseSimpleResponse).collect(Collectors.toList());
    }

    @Override
    public List<ExpenseSimpleResponse> findByNameContaining(String name, Pageable pageable) {
        logger.info("Getting expenses containing name: " + name);
        List<Expense> expenses = expenseRepository.findByNameContaining(name, pageable).toList();
        return expenses.stream().map(expenseMapper::toExpenseSimpleResponse).collect(Collectors.toList());
    }

    @Override
    public List<ExpenseSimpleResponse> findByDescriptionContaining(String description, Pageable pageable) {
        logger.info("Getting expenses containing description: " + description);
        List<Expense> expenses = expenseRepository.findByDescriptionContaining(description, pageable).toList();
        return expenses.stream().map(expenseMapper::toExpenseSimpleResponse).collect(Collectors.toList());
    }

    @Override
    public List<ExpenseSimpleResponse> findByDateBetween(LocalDate start, LocalDate end, Pageable pageable) {
        logger.info("Getting expenses in a period");
        List<Expense> expenses = expenseRepository.findByDateBetween(start, end, pageable).toList();
        return expenses.stream().map(expenseMapper::toExpenseSimpleResponse).collect(Collectors.toList());
    }

    @Override
    public BigDecimal totalAmountExpensesInPeriod(LocalDate start, LocalDate end) {
        logger.info("Calculating the total amount of expenses in a period...");
        List<Expense> expenses = expenseRepository.findByDateBetween(start, end);
        BigDecimal total = BigDecimal.ZERO;
        for (Expense expense : expenses) {
            total = total.add(expense.getAmountSpent());
        }
        return total;
    }

    @Override
    public List<ExpenseSimpleResponse> findExpensesInPeriod(LocalDate start, LocalDate end) {
        logger.info("Finding expenses in period");
        List<Expense> expenses = expenseRepository.findByDateBetween(start, end);
        return expenses.stream().map(expenseMapper::toExpenseSimpleResponse).collect(Collectors.toList());
    }

    @Override
    public BigDecimal totalAmountExpensesByCategoryInPeriod(LocalDate start, LocalDate end, Category category) {
        logger.info("Calculating the total amount of expenses in a period by category: " + category);
        List<Expense> expenses = expenseRepository.findByDateBetween(start, end);
        BigDecimal total = BigDecimal.ZERO;
        for (Expense expense : expenses) {
            if (expense.getCategory().equals(category)) {
                total = total.add(expense.getAmountSpent());
            }
        }
        return total;
    }

    @Override
    public List<ExpenseSimpleResponse> findAllExpensesByCategoryInPeriod(LocalDate start, LocalDate end, Category category) {
        logger.info("Getting all expenses by category: " + category + " in period");
        List<Expense> expenses = expenseRepository.findByDateBetween(start, end);
        return expenses.stream().filter(expense -> expense.getCategory().equals(category))
                .map(expenseMapper::toExpenseSimpleResponse).collect(Collectors.toList());
    }

    @Override
    public List<ExpenseSimpleResponse> findAllBillsExpensesInPeriod(LocalDate start, LocalDate end) {
        logger.info("Getting all bill expenses in period");
        List<Expense> expenses = expenseRepository.findByDateBetween(start, end);
        List<Expense> expQuery = new ArrayList<Expense>();
        for (Expense expense : expenses) {
            if (expense.getCategory().equals(Category.ENERGY_BILL) || expense.getCategory().equals(Category.INTERNET_BILL)
                    || expense.getCategory().equals(Category.TELEPHONE_BILL) || expense.getCategory().equals(Category.WATER_BILL)
                    || expense.getCategory().equals(Category.TELEVISION_BILL)) {
                expQuery.add(expense);
            }
        }
        return expQuery.stream().map(expenseMapper::toExpenseSimpleResponse).collect(Collectors.toList());
    }

    @Override
    public BigDecimal totalAmountAllBillExpensesInPeriod(LocalDate start, LocalDate end) {
        logger.info("Calculating the total amount of bills expenses in a period");
        List<ExpenseSimpleResponse> allBillsExpensesInPeriod = findAllBillsExpensesInPeriod(start, end);
        BigDecimal total = BigDecimal.ZERO;
        for (ExpenseSimpleResponse expenseSimpleResponse : allBillsExpensesInPeriod) {
            total = total.add(expenseSimpleResponse.amountSpent());
        }
        return total;
    }

    private Category verify(String category) {
        return Category.valueOf(category);
    }
}
