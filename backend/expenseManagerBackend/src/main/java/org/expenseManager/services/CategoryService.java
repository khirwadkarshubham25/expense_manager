package org.expenseManager.services;

import org.expenseManager.dto.CategoryDto;
import org.expenseManager.models.Category;
import org.expenseManager.models.CategoryType;
import org.expenseManager.repositories.CategoryRepository;
import org.expenseManager.repositories.CategoryTypeRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class CategoryService {
    final CategoryRepository categoryRepository;

    final CategoryTypeRepository categoryTypeRepository;


    public CategoryService(CategoryRepository categoryRepository, CategoryTypeRepository categoryTypeRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryTypeRepository = categoryTypeRepository;
    }

    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

    public void createCategories(CategoryDto categoryDto){
        CategoryType categoryType = categoryTypeRepository.findByCategoryType(categoryDto.getCategoryType().toLowerCase());
        Category category = new Category(categoryType, categoryDto.getCategory());
        category.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Calendar.getInstance().getTime()));
        category.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Calendar.getInstance().getTime()));
        categoryRepository.save(category);
    }
}
