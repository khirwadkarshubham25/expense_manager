package org.expenseManager.repositories;

import org.expenseManager.models.IncomeExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeExpenseRepository extends JpaRepository<IncomeExpense, Long> {


}
