package br.com.carv.expenses.controller.impl;

import br.com.carv.expenses.controller.ExpenseController;
import br.com.carv.expenses.model.dto.request.ExpensePostRequest;
import br.com.carv.expenses.model.dto.request.ExpensePutRequest;
import br.com.carv.expenses.model.dto.response.ExpenseGetResponse;
import br.com.carv.expenses.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/expense")
public class ExpenseControllerImpl implements ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseControllerImpl(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public ResponseEntity<ExpenseGetResponse> save(ExpensePostRequest expensePostRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.expenseService.save(expensePostRequest));
    }

    @Override
    public ResponseEntity<Void> update(ExpensePutRequest expensePutRequest) {
        this.expenseService.update(expensePutRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<ExpenseGetResponse> findById(UUID id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.expenseService.findById(id));
    }

    @Override
    public ResponseEntity<List<ExpenseGetResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.expenseService.findAll());
    }

    @Override
    public ResponseEntity<Page<ExpenseGetResponse>> findAllPaginated(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(this.expenseService.findAllPaginated(pageable));
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        this.expenseService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
