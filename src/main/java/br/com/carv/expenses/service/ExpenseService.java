package br.com.carv.expenses.service;

import br.com.carv.expenses.model.dto.request.ExpensePostRequest;
import br.com.carv.expenses.model.dto.request.ExpensePutRequest;
import br.com.carv.expenses.model.dto.response.ExpenseGetResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.UUID;

public interface ExpenseService {

    List<ExpenseGetResponse> findAll();

    Page<ExpenseGetResponse> findAllPaginated(Pageable pageable);

    ExpenseGetResponse save(ExpensePostRequest expensePostRequest);

    ExpenseGetResponse update(ExpensePutRequest expensePutRequest);

    void delete(UUID uuid);

    ExpenseGetResponse findById(UUID uuid);

}









