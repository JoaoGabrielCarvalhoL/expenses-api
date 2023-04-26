package br.com.carv.expenses.handler;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ExceptionMessageValidator(
        @JsonProperty("Título")
        String title,
        @JsonProperty("Código do Erro")
        Integer status,
        @JsonProperty("Detalhes")
        String details,
        @JsonProperty("Campo")
        String field,
        @JsonProperty("Mensagem")
        String message,
        @JsonProperty("Ocorrência em")
        LocalDateTime timestamp
) implements Serializable {
}
