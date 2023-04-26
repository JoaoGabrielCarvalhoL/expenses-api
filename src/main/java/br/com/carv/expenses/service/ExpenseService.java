package br.com.carv.expenses.service;

import br.com.carv.expenses.model.dto.request.ExpensePostRequest;
import br.com.carv.expenses.model.dto.request.ExpensePutRequest;
import br.com.carv.expenses.model.dto.response.ExpenseGetResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ExpenseService {

    List<ExpenseGetResponse> findAll();

    Page<ExpenseGetResponse> findAllPaginated(final Pageable pageable);

    ExpenseGetResponse save(final ExpensePostRequest expensePostRequest);

    ExpenseGetResponse update(final ExpensePutRequest expensePutRequest);

    void delete(final UUID uuid);

    ExpenseGetResponse findById(final UUID uuid);

}


