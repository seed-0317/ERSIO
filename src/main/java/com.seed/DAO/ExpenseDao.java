package com.seed.DAO;

import com.seed.Model.Expense;
import java.util.List;
import java.util.Map;

public interface ExpenseDao {

    void createExpense(Expense newExpense);
    List<Expense> retrieveExpenses();
    void resolveExpense(String RS_ID, String RS_STATUS);
    Map<String, Integer> retrieveExpenseTypes();
    Map<String, Integer> retrieveExpenseStatus();
    List<Expense> retrievePendingExpenses();
}