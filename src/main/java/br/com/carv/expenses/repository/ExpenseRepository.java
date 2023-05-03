package br.com.carv.expenses.repository;

import br.com.carv.expenses.model.enumerated.Category;
import br.com.carv.expenses.model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {
   Page<Expense> findByNameIgnoreCase(String name, Pageable pageable);
   Page<Expense> findByCategory(Category category, Pageable pageable);
   Page<Expense> findByNameContaining(String name, Pageable pageable);
   Page<Expense> findByDescriptionContaining(String description, Pageable pageable);
   Page<Expense> findByDateBetween(LocalDate start, LocalDate end, Pageable pageable);
   List<Expense> findByDateBetween(LocalDate start, LocalDate end);

}
