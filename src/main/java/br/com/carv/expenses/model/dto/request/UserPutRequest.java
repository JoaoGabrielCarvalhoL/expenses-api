package br.com.carv.expenses.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public record UserPutRequest(
        @JsonProperty("id")
        @NotNull(message = "Id cannot be null!")
        UUID id,
        @JsonProperty("Nome")
        @NotBlank(message = "Name cannot be empty!") @Size(max = 100, min = 5, message = "Maximum number of " +
                "characters for this field is 100")
        String name,
        @JsonProperty("Email")
        @NotBlank(message = "Email cannot be empty!")
        @Email
        String email,

        @JsonProperty("Usuário")
        @NotBlank(message = "Username cannot be empty!")
        String username,

        @JsonProperty("Senha")
        @NotBlank(message = "Password cannot be empty!")
        String password,

        @JsonProperty("Data de Nascimento")
        LocalDate birthDate
) implements Serializable {
}
