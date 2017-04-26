package com.seed.DAO;

import com.seed.Model.Expense;
import java.util.List;
import java.util.Map;

public interface ExpenseDao {

    void createExpense(Expense newExpense);
    List<Expense> retrieveExpenses();
    void resolveExpense(int RS_ID, int RS_STATUS);
    Map<String, Integer> retrieveExpenseTypes();
    Map<String, Integer> retrieveExpenseStatus();
    List<Expense> retrieveResolvedExpenses();
    List<Expense> retrievePendingExpenses();

}