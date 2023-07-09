package org.expenseManager.models;

import javax.persistence.*;

@Entity
@Table
public class SubCategory {
    @Id
    @SequenceGenerator(
            name = "sub_category_sequence",
            sequenceName = "sub_category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sub_category_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "Text"
    )
    private String name;

    @OneToOne
    @JoinColumn(
            name = "categoryId", referencedColumnName = "id", nullable = false
    )
    private Category category;

    @OneToOne
    @JoinColumn(
            name = "userId", referencedColumnName = "id", nullable = false
    )
    private Users users;

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

    public SubCategory() {
    }

    public SubCategory(String name, Category category, Users users) {
        this.name = name;
        this.category = category;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", users=" + users +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
