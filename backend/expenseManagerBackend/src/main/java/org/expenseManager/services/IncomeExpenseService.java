package org.expenseManager.services;

import org.expenseManager.dto.IncomeExpenseCreateDto;
import org.expenseManager.models.IncomeExpense;
import org.expenseManager.repositories.IncomeExpenseRepository;
import org.expenseManager.repositories.SubCategoryRepository;
import org.expenseManager.repositories.UsersRepository;
import org.expenseManager.security.JWTTokensManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class IncomeExpenseService {

    final IncomeExpenseRepository incomeExpenseRepository;

    final SubCategoryRepository subCategoryRepository;

    final UsersRepository usersRepository;

    @Autowired
    private JWTTokensManager jwtTokensManager;

    public IncomeExpenseService(IncomeExpenseRepository incomeExpenseRepository, SubCategoryRepository subCategoryRepository, UsersRepository usersRepository) {
        this.incomeExpenseRepository = incomeExpenseRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.usersRepository = usersRepository;
    }

    public void createIncomeExpense(String token, IncomeExpenseCreateDto incomeExpenseCreateDto){
        token = token.replace("Bearer ", "");
        if (!jwtTokensManager.validateToken(token)){
            throw new RuntimeException("Invalid Token");
        }
        Long userId = jwtTokensManager.getUserIdToken(token);
        IncomeExpense incomeExpense = new IncomeExpense(subCategoryRepository.findSubCategoryById(incomeExpenseCreateDto.getSubCategoryId()), incomeExpenseCreateDto.getAmount());
        incomeExpense.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Calendar.getInstance().getTime()));
        incomeExpense.setUpdatedAt(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Calendar.getInstance().getTime()));
        incomeExpenseRepository.save(incomeExpense);
    }
}
