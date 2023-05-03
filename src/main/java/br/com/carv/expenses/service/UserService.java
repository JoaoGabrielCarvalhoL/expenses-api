package br.com.carv.expenses.service;

import br.com.carv.expenses.model.dto.request.ExpensePostRequest;
import br.com.carv.expenses.model.dto.request.ExpensePutRequest;
import br.com.carv.expenses.model.dto.request.UserPostRequest;
import br.com.carv.expenses.model.dto.request.UserPutRequest;
import br.com.carv.expenses.model.dto.response.ExpenseGetResponse;
import br.com.carv.expenses.model.dto.response.ExpenseSimpleResponse;
import br.com.carv.expenses.model.dto.response.UserGetResponse;
import br.com.carv.expenses.model.dto.response.UserSimpleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserSimpleResponse> findAll();

    Page<UserSimpleResponse> findAllPaginated(final Pageable pageable);

    UserGetResponse save(final UserPostRequest expensePostRequest);

    UserGetResponse update(final UserPutRequest expensePutRequest);

    void delete(final UUID uuid);

    UserGetResponse findById(final UUID uuid);

    UserSimpleResponse findUserByUsername(String username);
}
