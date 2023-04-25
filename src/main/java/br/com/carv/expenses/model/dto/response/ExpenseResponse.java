package br.com.carv.expenses.model.dto.response;

import br.com.carv.expenses.model.Category;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public record ExpenseResponse(
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
        LocalDate date,
        @JsonProperty("Ativo: ")
        Boolean isActive,
        @JsonProperty("Criado em")
        OffsetDateTime createdAt,
        @JsonProperty("Atualizado em")
        OffsetDateTime updatedAt

) {
}
