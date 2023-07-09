package org.expenseManager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubCategoryUpdateDto {
    @JsonProperty(value = "subCategoryId")
    private Long subCategoryId;

    @JsonProperty(value = "categoryId")
    private Long categoryId;

    @JsonProperty(value = "subCategory")
    private String subCategory;

    public SubCategoryUpdateDto(Long subCategoryId, Long categoryId, String subCategory) {
        this.subCategoryId = subCategoryId;
        this.categoryId = categoryId;
        this.subCategory = subCategory;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
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
