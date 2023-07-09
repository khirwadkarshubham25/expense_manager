package org.expenseManager.restController;

import org.expenseManager.dto.SubCategoryCreateDto;
import org.expenseManager.dto.SubCategoryUpdateDto;
import org.expenseManager.models.SubCategory;
import org.expenseManager.services.SubCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/subcategories")
public class SubCategoryController {

    final SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping("/get")
    public List<SubCategory> getSubCategories(@RequestHeader("Authorization") String token, @RequestParam(value = "categoryId", required = true) Long categoryId){
        return subCategoryService.getSubCategories(categoryId, token);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createSubCategories(@RequestHeader("Authorization") String token, @RequestBody SubCategoryCreateDto subCategoryCreateDto){
        subCategoryService.createSubCategories(subCategoryCreateDto, token);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully Created new sub-category");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateSubCategories(@RequestHeader("Authorization") String token, @RequestBody SubCategoryUpdateDto subCategoryUpdateDto){
        subCategoryService.updateSubCategories(subCategoryUpdateDto, token);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully updated sub-category");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteSubCategories(@RequestHeader("Authorization") String token, @RequestParam(value = "subCategoryId", required = true) Long subCategoryId){
        subCategoryService.deleteSubCategories(subCategoryId, token);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully deleted sub-category");
    }
}
