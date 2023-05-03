package br.com.carv.expenses.model.dto.request;

import br.com.carv.expenses.model.enumerated.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ExpensePutRequest(
        @JsonProperty("id")
        @NotNull(message = "Id cannot be null")
        UUID id,
        @JsonProperty("Nome")
        @NotBlank(message = "Name cannot be empty!") @Size(max = 100, min = 5, message = "Maximum number of " +
                "characters for this field is 100")
        String name,
        @JsonProperty("Descrição")
        @NotBlank(message = "Description cannot be empty!") @Size(max = 100, min = 5, message = "Maximum number " +
                "of characters for this field is 150")
        String description,
        @JsonProperty("Valor")
        @NotNull(message = "AmountSpent cannot be null")
        BigDecimal amountSpent,
        @JsonProperty("Categoria")
        @NotNull(message = "Category cannot be null")
        Category category,
        @JsonProperty("Data")
        @NotNull(message = "Date cannot be null")
        LocalDate date
) {
}
