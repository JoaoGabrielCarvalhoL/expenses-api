package br.com.carv.expenses.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "tb_user")
public class User extends GenericEntity {

    @Column(nullable = false, length = 150)
    private String name;
    @Email
    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, unique = true, length = 100)
    private String username;

    @Column(nullable = false)
    private String password;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate birthDate;

    private String role;

    public User() {}

    public User(String name, String email, String username, String password, LocalDate birthDate, String role) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
