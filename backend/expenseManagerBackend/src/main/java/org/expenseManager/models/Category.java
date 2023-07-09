package org.expenseManager.models;

import javax.persistence.*;

@Entity
@Table
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @OneToOne
    @JoinColumn(
            name = "categoryTypeId", referencedColumnName = "id", nullable = false
    )
    private CategoryType categoryType;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "Text"
    )
    private String name;

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

    public Category() {
    }

    public Category(CategoryType categoryType, String name) {
        this.categoryType = categoryType;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Category{" +
                "id=" + id +
                ", categoryType=" + categoryType +
                ", name='" + name + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
