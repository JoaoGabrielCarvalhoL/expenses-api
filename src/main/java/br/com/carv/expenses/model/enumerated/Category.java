package br.com.carv.expenses.model.enumerated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
public enum Category {
    WATER_BILL("1", "Water Bill"),
    ENERGY_BILL("2", "Energy Bill"),
    TELEPHONE_BILL("3", "Telephone Bill"),
    INTERNET_BILL("4", "Internet Bill"),
    TELEVISION_BILL("5", "Television Bill"),
    SUPERMARKET("6", "Supermarket"),
    PERSONAL_EXPENSES("7", "Personal Expenses"),
    TRANSPORT("8", "Transport"),
    HOME("9", "Home"),
    LEISURE("10", "Leisure"),
    HEALTH_AND_BEAUTY("11", "Health and Beauty"),
    BARS_AND_RESTAURANTS("12", "Bars and Restaurants"),
    EDUCATION("13", "Education"),
    FOOD("14", "Food"),
    BEAUTY_SALON("15", "Beauty and Salon");

    public final String id;
    public final String description;

    Category(String id, String description) {
        this.id = id;
        this.description = description;
    }

//    @JsonCreator
//    public static Category forValue(String value) {
//        return Arrays.stream(Category.values()).filter(category -> category.id.equals(value)).findFirst().orElse(null);
//    }




}
