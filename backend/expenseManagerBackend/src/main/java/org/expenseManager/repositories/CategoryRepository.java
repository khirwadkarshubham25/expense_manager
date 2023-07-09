package org.expenseManager.repositories;

import org.expenseManager.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAll();

    Category findCategoryById(Long id);
}
