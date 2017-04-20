package com.seed.DAO;

import com.seed.Model.Expense;
import java.util.List;

public interface ExpenseDao {

    void createExpense(Expense newExpense);
    List<Expense> retrieveExpenses();
    void resolveExpense(String RS_ID, String RS_STATUS, String managerUserName);
}