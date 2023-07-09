package org.expenseManager.dto;

import org.expenseManager.models.Users;

public class AuthenticatedUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String createdAt;

    private String updatedAt;

    public AuthenticatedUserDto() {
    }

    public AuthenticatedUserDto(Users users){
        this.id = users.getId();
        this.firstName = users.getFirstName();
        this.lastName = users.getLastName();
        this.email = users.getEmail();
        this.createdAt = users.getCreatedAt();
        this.updatedAt = users.getUpdatedAt();
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "LoginResponseDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
