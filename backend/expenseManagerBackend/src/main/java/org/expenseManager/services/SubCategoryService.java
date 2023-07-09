package org.expenseManager.services;

import org.expenseManager.dto.SubCategoryCreateDto;
import org.expenseManager.dto.SubCategoryUpdateDto;
import org.expenseManager.models.SubCategory;
import org.expenseManager.repositories.CategoryRepository;
import org.expenseManager.repositories.SubCategoryRepository;
import org.expenseManager.repositories.UsersRepository;
import org.expenseManager.security.JWTTokensManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class SubCategoryService {
    final SubCategoryRepository subCategoryRepository;

    final CategoryRepository categoryRepository;

    final UsersRepository usersRepository;

    @Autowired
    private JWTTokensManager jwtTokensManager;

    public SubCategoryService(SubCategoryRepository subCategoryRepository, CategoryRepository categoryRepository, UsersRepository usersRepository) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository = categoryRepository;
        this.usersRepository = usersRepository;
    }

    public List<SubCategory> getSubCategories(Long categoryId, String token){
        token = token.replace("Bearer ", "");
        if (!jwtTokensManager.validateToken(token)){
            throw new RuntimeException("Invalid Token");
        }
        Long userId = jwtTokensManager.getUserIdToken(token);
        System.out.println(userId);
        return subCategoryRepository.findSubCategoryByUserIdCategoryId(userId, categoryId);
    }

    public void createSubCategories(SubCategoryCreateDto subCategoryCreateDto, String token){
        token = token.replace("Bearer ", "");
        if (!jwtTokensManager.validateToken(token)){
            throw new RuntimeException("Invalid Token");
        }
        Long userId = jwtTokensManager.getUserIdToken(token);
        SubCategory subCategory = new SubCategory(subCategoryCreateDto.getSubCategory(),
                categoryRepository.findCategoryById(subCategoryCreateDto.getCategoryId()),
                usersRepository.findUsersById(userId)
        );
        subCategory.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Calendar.getInstance().getTime()));
        subCategory.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Calendar.getInstance().getTime()));
        subCategoryRepository.save(subCategory);
    }

    public void updateSubCategories(SubCategoryUpdateDto subCategoryUpdateDto, String token){
        token = token.replace("Bearer ", "");
        if (!jwtTokensManager.validateToken(token)){
            throw new RuntimeException("Invalid Token");
        }
        SubCategory subCategory = subCategoryRepository.findSubCategoryById(subCategoryUpdateDto.getSubCategoryId());

        subCategory.setName(subCategoryUpdateDto.getSubCategory());
        subCategory.setCategory(categoryRepository.findCategoryById(subCategoryUpdateDto.getCategoryId()));
        subCategoryRepository.save(subCategory);
    }

    public void deleteSubCategories(Long subCategoryId, String token){
        token = token.replace("Bearer ", "");
        if (!jwtTokensManager.validateToken(token)){
            throw new RuntimeException("Invalid Token");
        }
        SubCategory subCategory = subCategoryRepository.findSubCategoryById(subCategoryId);
        subCategoryRepository.delete(subCategory);
    }
}
