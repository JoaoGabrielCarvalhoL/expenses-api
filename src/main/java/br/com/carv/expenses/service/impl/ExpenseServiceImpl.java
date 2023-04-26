package br.com.carv.expenses.service.impl;

import br.com.carv.expenses.controller.impl.ExpenseControllerImpl;
import br.com.carv.expenses.exception.ExpenseNotFoundException;
import br.com.carv.expenses.mapper.ExpenseMapper;
import br.com.carv.expenses.model.Expense;
import br.com.carv.expenses.model.dto.request.ExpensePostRequest;
import br.com.carv.expenses.model.dto.request.ExpensePutRequest;
import br.com.carv.expenses.model.dto.response.ExpenseGetResponse;
import br.com.carv.expenses.repository.ExpenseRepository;
import br.com.carv.expenses.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final Logger logger = Logger.getLogger(ExpenseServiceImpl.class.getCanonicalName());

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
    }

    @Override
    public List<ExpenseGetResponse> findAll() {
        logger.info("Getting all expenses.");
        List<ExpenseGetResponse> expenses = expenseRepository.findAll()
                .stream()
                .map(expenseMapper::toExpenseGetResponse)
                .collect(Collectors.toList());
        expenses.forEach(expense -> expense.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(ExpenseControllerImpl.class).findById(expense.getId())).withSelfRel()));
        return expenses;
    }

    @Override
    public Page<ExpenseGetResponse> findAllPaginated(Pageable pageable) {
        logger.info("Getting all expenses paginated.");
        List<ExpenseGetResponse> expenses = this.expenseRepository.findAll(pageable)
                .stream()
                .map(expenseMapper::toExpenseGetResponse)
                .collect(Collectors.toList());
        expenses.forEach(expense -> expense.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                .methodOn(ExpenseControllerImpl.class).findById(expense.getId())).withSelfRel()));
        return new PageImpl<ExpenseGetResponse>(expenses, pageable, expenses.size());
    }

    @Override
    public ExpenseGetResponse save(ExpensePostRequest expensePostRequest) {
        logger.info("Saving expense into database.");
        Expense saved = expenseRepository.save(expenseMapper.toExpense(expensePostRequest));
        return expenseMapper.toExpenseGetResponse(saved).add(WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(ExpenseControllerImpl.class)
                        .findById(saved.getId())).withSelfRel());
    }

    @Override
    public ExpenseGetResponse update(ExpensePutRequest expensePutRequest) {
        logger.info("Updating expense into database");
        Expense updated = expenseRepository.saveAndFlush(expenseMapper.toExpense(expensePutRequest));
        return expenseMapper.toExpenseGetResponse(updated).add(WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(ExpenseControllerImpl.class)
                        .findById(updated.getId())).withSelfRel());
    }

    @Override
    public void delete(UUID uuid) {
        logger.info("Deleting expense with id: " + uuid);
        this.expenseRepository.delete(findEntityById(uuid));

    }

    @Override
    public ExpenseGetResponse findById(UUID uuid) {
        logger.info("Finding expense with id: " + uuid);
        return expenseRepository.findById(uuid)
                .map(expenseMapper::toExpenseGetResponse)
                .orElseThrow(() ->
                new ExpenseNotFoundException("Expense not found into database. Id: " + uuid));
    }

    private Expense findEntityById(UUID uuid) {
        return expenseRepository.findById(uuid).orElseThrow(
                () -> new ExpenseNotFoundException("Expense not found into database. Id: " + uuid));
    }

}
