package org.expenseManager.models;

import javax.persistence.*;

@Entity
@Table
public class IncomeExpense {

    @Id
    @SequenceGenerator(
            name = "income_expense_sequence",
            sequenceName = "income_expense_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "income_expense_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @OneToOne
    @JoinColumn(
            name = "subCategoryId", referencedColumnName = "id", nullable = false
    )
    private SubCategory subCategory;

    @Column(
            name = "amount",
            nullable = false
    )
    private Double amount;

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

    public IncomeExpense(SubCategory subCategory, Double amount) {
        this.subCategory = subCategory;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
}
