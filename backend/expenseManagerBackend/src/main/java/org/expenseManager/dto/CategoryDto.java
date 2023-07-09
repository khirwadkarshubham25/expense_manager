package org.expenseManager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryDto {
    @JsonProperty(value = "category")
    private String category;

    @JsonProperty(value = "categoryType")
    private String categoryType;

    public CategoryDto() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "category='" + category + '\'' +
                ", categoryType='" + categoryType + '\'' +
                '}';
    }
}
