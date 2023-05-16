package br.com.carv.expenses.model.dto.request;

import java.io.Serializable;

public record LoginRequest(
        String username,
        String password
) implements Serializable {
}
