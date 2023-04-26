package br.com.carv.expenses.mapper;

import br.com.carv.expenses.model.Expense;
import br.com.carv.expenses.model.dto.request.ExpensePostRequest;
import br.com.carv.expenses.model.dto.request.ExpensePutRequest;
import br.com.carv.expenses.model.dto.response.ExpenseGetResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExpenseMapper {

    ExpenseGetResponse toExpenseGetResponse(Expense expense);

    Expense toExpense(ExpensePostRequest expensePostRequest);

    Expense toExpense(ExpensePutRequest expensePutRequest);

}
