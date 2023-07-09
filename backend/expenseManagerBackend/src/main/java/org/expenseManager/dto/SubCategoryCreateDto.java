package org.expenseManager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubCategoryCreateDto {
    @JsonProperty(value = "categoryId")
    private Long categoryId;

    @JsonProperty(value = "subCategory")
    private String subCategory;

    public SubCategoryCreateDto(Long categoryId, String subCategory) {
        this.categoryId = categoryId;
        this.subCategory = subCategory;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
}
