package br.com.carv.expenses.model.dto.response;

import br.com.carv.expenses.model.enumerated.Category;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ExpenseSimpleResponse(
        @JsonProperty("id")
        UUID id,
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

) implements Serializable {
}
