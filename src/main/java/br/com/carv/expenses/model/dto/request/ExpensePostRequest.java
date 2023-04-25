package br.com.carv.expenses.model.dto.request;

import br.com.carv.expenses.model.Category;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpensePostRequest(
        @JsonProperty("Nome")
        String name,
        @JsonProperty("Descrição")
        String description,
        @JsonProperty("Valor")
        BigDecimal amountSpent,
        @JsonProperty("Categoria")
        Category category,
        @JsonProperty("Data")
        LocalDate date
        ) {
}
