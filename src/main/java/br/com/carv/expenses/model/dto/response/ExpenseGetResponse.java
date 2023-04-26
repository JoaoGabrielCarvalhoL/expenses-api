package br.com.carv.expenses.model.dto.response;

import br.com.carv.expenses.model.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class ExpenseGetResponse extends RepresentationModel<ExpenseGetResponse> {

    @JsonProperty("Id")
    private UUID id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Descrição")
    private String description;
    @JsonProperty("Valor")
    private BigDecimal amountSpent;
    @JsonProperty("Categoria")
    private Category category;
    @JsonProperty("Data")
    private LocalDate date;

    public ExpenseGetResponse() {}

    public ExpenseGetResponse(UUID id, String name, String description, BigDecimal amountSpent,
                              Category category, LocalDate date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amountSpent = amountSpent;
        this.category = category;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(BigDecimal amountSpent) {
        this.amountSpent = amountSpent;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
