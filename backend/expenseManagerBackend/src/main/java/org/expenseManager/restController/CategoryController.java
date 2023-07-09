package org.expenseManager.restController;

import org.expenseManager.dto.CategoryDto;
import org.expenseManager.models.Category;
import org.expenseManager.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/get")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("/createCategories")
    public ResponseEntity<String> createCategories(@RequestBody CategoryDto categoryDto){
        categoryService.createCategories(categoryDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully Created new category");
    }
}
