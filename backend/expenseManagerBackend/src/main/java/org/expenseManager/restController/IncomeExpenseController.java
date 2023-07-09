package org.expenseManager.restController;

import org.expenseManager.dto.IncomeExpenseCreateDto;
import org.expenseManager.services.CategoryService;
import org.expenseManager.services.IncomeExpenseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/incomeExpense")
public class IncomeExpenseController {

    private final IncomeExpenseService incomeExpenseService;

    public IncomeExpenseController(IncomeExpenseService incomeExpenseService) {
        this.incomeExpenseService = incomeExpenseService;
    }

    @GetMapping(path = "/get")
    public void getIncomeExpense(){

    }

    @PostMapping(path = "create")
    public void createIncomeExpense(@RequestHeader("Authorization") String token, @RequestBody IncomeExpenseCreateDto incomeExpenseCreateDto){
        incomeExpenseService.createIncomeExpense(token, incomeExpenseCreateDto);
    }
}
