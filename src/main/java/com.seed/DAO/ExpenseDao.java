package com.seed.DAO;

import com.seed.Model.Expense;
import java.util.List;

public interface ExpenseDao {

    void createExpense(Expense newExpense);
    List<Expense> retrieveExpenses();
}