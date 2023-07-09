package org.expenseManager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IncomeExpenseCreateDto {

    @JsonProperty(value = "subCategoryId")
    private Long subCategoryId;

    @JsonProperty(value = "amount")
    private Double amount;

    public IncomeExpenseCreateDto(Long subCategoryId, Double amount) {
        this.subCategoryId = subCategoryId;
        this.amount = amount;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "IncomeExpenseCreateDto{" +
                "subCategoryId=" + subCategoryId +
                ", amount=" + amount +
                '}';
    }
}
