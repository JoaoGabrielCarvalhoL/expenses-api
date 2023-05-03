package br.com.carv.expenses.service;

import br.com.carv.expenses.model.enumerated.Category;
import br.com.carv.expenses.model.dto.response.ExpenseSimpleResponse;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseQueryService {

    List<ExpenseSimpleResponse> findByNameIgnoreCase(String name, Pageable pageable);
    List<ExpenseSimpleResponse> findByCategory(Category category, Pageable pageable);
    List<ExpenseSimpleResponse> findByNameContaining(String name, Pageable pageable);
    List<ExpenseSimpleResponse> findByDescriptionContaining(String description, Pageable pageable);
    List<ExpenseSimpleResponse> findByDateBetween(LocalDate start, LocalDate end, Pageable pageable);


}
