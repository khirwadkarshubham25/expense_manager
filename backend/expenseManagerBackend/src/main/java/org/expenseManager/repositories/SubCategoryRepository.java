package org.expenseManager.repositories;

import org.expenseManager.models.Category;
import org.expenseManager.models.SubCategory;
import org.expenseManager.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    @Query("SELECT sc FROM SubCategory sc WHERE sc.users.id = :userId and sc.category.id = :categoryId")
    List<SubCategory> findSubCategoryByUserIdCategoryId(@Param("userId") Long userId, @Param("categoryId") Long categoryId);

    SubCategory findSubCategoryById(Long id);
}
