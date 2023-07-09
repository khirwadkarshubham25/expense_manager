package org.expenseManager.models;

import javax.persistence.*;


@Entity
@Table
public class Users {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;

    @Column(
            name = "firstName",
            nullable = false,
            columnDefinition = "Text"
    )
    private String firstName;

    @Column(
            name = "lastName",
            nullable = false,
            columnDefinition = "Text"
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            unique = true,
            updatable = false,
            columnDefinition = "Text"
    )
    private String email;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "Text",
            length = 1000
    )
    private String password;

    @Column(
            name = "createdAt",
            nullable = false
    )
    private String createdAt;

    @Column(
            name = "updatedAt",
            nullable = false
    )
    private String updatedAt;

    @Column(
            name = "status",
            nullable = false,
            columnDefinition = "integer default 1"
    )
    private int status;

    public Users() {
    }

    public Users(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
