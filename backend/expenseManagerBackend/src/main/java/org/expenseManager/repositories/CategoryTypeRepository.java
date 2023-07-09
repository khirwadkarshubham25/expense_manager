package org.expenseManager.repositories;

import org.expenseManager.models.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryTypeRepository extends JpaRepository<CategoryType, Integer> {


    CategoryType findByCategoryType(String categoryType);
}
