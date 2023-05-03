package br.com.carv.expenses.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.UUID;

@JsonPropertyOrder({"id", "name", "email", "username", "birthDate"})
public class UserGetResponse extends RepresentationModel<UserGetResponse> {
    @JsonProperty("id")
    private UUID id;
    @JsonProperty("Nome")
    private String name;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Usuário")
    private String username;
    @JsonProperty("Data de Nascimento")
    private LocalDate birthDate;

    public UserGetResponse() {}

    public UserGetResponse(String name, String email, String username, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.birthDate = birthDate;
    }

    public UserGetResponse(UUID id, String name, String email, String username, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.birthDate = birthDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
