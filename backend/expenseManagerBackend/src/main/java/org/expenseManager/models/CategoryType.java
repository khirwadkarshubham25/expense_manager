package org.expenseManager.models;

import javax.persistence.*;

@Entity
@Table(name = "categoryType")
public class CategoryType {

    @Id
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;

    @Column(
            name = "categoryType",
            updatable = false
    )
    private String categoryType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "CategoryType{" +
                "id=" + id +
                ", categoryType='" + categoryType + '\'' +
                '}';
    }
}
