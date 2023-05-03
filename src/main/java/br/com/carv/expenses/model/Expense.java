package br.com.carv.expenses.model;

import br.com.carv.expenses.model.enumerated.Category;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "tb_expense")
@Entity
public class Expense extends GenericEntity {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 150)
    private String description;

    @Column(nullable = false, scale = 2, precision = 8)
    private BigDecimal amountSpent;

    @Enumerated(EnumType.STRING)
    private Category category;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate date;

    public Expense() {}

    public Expense(String name, String description, BigDecimal amountSpent, Category category, LocalDate date) {
        this.name = name;
        this.description = description;
        this.amountSpent = amountSpent;
        this.category = category;
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmountSpent() {
        return this.amountSpent;
    }

    public void setAmountSpent(BigDecimal amountSpent) {
        this.amountSpent = amountSpent;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
