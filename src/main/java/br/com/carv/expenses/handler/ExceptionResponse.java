package br.com.carv.expenses.handler;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ExceptionResponse(
        @JsonProperty("Título")
        String title,
        @JsonProperty("Código do Erro")
        Integer status,
        @JsonProperty("Detalhes")
        String details,
        @JsonProperty("Ocorrência em")
        LocalDateTime timestamp
) implements Serializable {
}
