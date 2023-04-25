package br.com.carv.expenses.service.impl;

import br.com.carv.expenses.mapper.ExpenseMapper;
import br.com.carv.expenses.repository.ExpenseRepository;
import br.com.carv.expenses.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final Logger logger = Logger.getLogger(ExpenseServiceImpl.class.getCanonicalName());

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
    }
}
