package br.com.carv.expenses.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public record UserSimpleResponse(
        @JsonProperty("id")
        UUID id,
        @JsonProperty("Nome")
        String name,
        @JsonProperty("Email")
        String email,
        @JsonProperty("Usuário")
        String username,
        @JsonProperty("Data de Nascimento")
        LocalDate birthDate
) implements Serializable {
}
