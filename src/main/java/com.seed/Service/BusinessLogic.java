package com.seed.Service;

import com.seed.DAO.ExpenseDao;
import com.seed.DAO.ExpenseDaoImpl;
import com.seed.DAO.UserDao;
import com.seed.DAO.UserDaoImpl;
import com.seed.Model.User;
import com.seed.Model.Expense;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BusinessLogic {

    public BusinessLogic() {
    }

    /**
     * @param userName
     * @return person object if logged in successfully, otherwise {@code null}
     */
    public User login(String userName) {
        if (userName == null || userName.isEmpty()) {
            return null;
        }
        else {
            UserDao dao = new UserDaoImpl();
            User user = dao.retrieveUser(userName);
            return user;
        }
    }
    public User login(int userID) {
        if (userID != 0) {
            return null;
        }
        else {
            UserDao dao = new UserDaoImpl();
            User user = dao.retrieveUser(userID);
            return user;
        }
    }
    public void resolveReimbursement(int RS_ID, int RS_STATUS){
        ExpenseDao dao = new ExpenseDaoImpl();
        dao.resolveExpense(RS_ID, RS_STATUS);
    }

    public void createUser(User newUser){
        UserDao dao = new UserDaoImpl();
        dao.createUser(newUser);
    }
    public void updateUser(User updatedUser){
        UserDao dao = new UserDaoImpl();
        dao.updateUser(updatedUser);
    }

    public void createExpense(Expense newExpense){
        ExpenseDao dao = new ExpenseDaoImpl();
        dao.createExpense(newExpense);
    }

    public List<Expense> retrieveExpenses(){
        ExpenseDao dao = new ExpenseDaoImpl();
        return dao.retrieveExpenses();
    }

    public List<Expense> retrievePendingExpenses(){
        ExpenseDao dao = new ExpenseDaoImpl();
        return dao.retrievePendingExpenses();
    }
    public List<Expense> retrieveResolvedExpenses(){
        ExpenseDao dao = new ExpenseDaoImpl();
        return dao.retrieveResolvedExpenses();
    }

    public Map<String,Integer> retrieveExpenseTypes(){
        ExpenseDao dao = new ExpenseDaoImpl();
        return dao.retrieveExpenseTypes();
    }

    public Map<String,Integer> retrieveExpenseStatus(){
        ExpenseDao dao = new ExpenseDaoImpl();
        return dao.retrieveExpenseStatus();
    }

    public List<User> retrieveUsers(int managerID){
        UserDao dao = new UserDaoImpl();
        return dao.retrieveUsers(managerID);
    }

    public List<Expense> retrieveExpensesByAuthor(int IdAuthor){
        List<Expense> list = retrieveExpenses();
        Iterator<Expense> iter = list.listIterator();

        Expense expense;
        while(iter.hasNext()) {
            expense = iter.next();
            if (expense.getIdAuthor()!=IdAuthor) {
                iter.remove();
            }
        }
        return list;
    }

//    public List<Expense> retrievePendingExpensesByAuthor(int IdAuthor){
//        List<Expense> list = retrievePendingExpenses();
//        Iterator<Expense> iter = list.listIterator();
//
//        Expense expense;
//        while(iter.hasNext()) {
//            expense = iter.next();
//            if (expense.getIdAuthor()!=IdAuthor) {
//                iter.remove();
//            }
//        }
//        return list;
//    }

    public List<Expense> retrieveResolvedExpensesByAuthor(int IdAuthor){
        List<Expense> list = retrieveResolvedExpenses();
        Iterator<Expense> iter = list.listIterator();

        Expense expense;
        while(iter.hasNext()) {
            expense = iter.next();
            if (expense.getIdAuthor()!=IdAuthor) {
                iter.remove();
            }
        }
        return list;
    }


    public List<Expense> retrieveResolvedExpensesByManager(int managerID){
        List<Expense> list = retrieveResolvedExpenses();
        Iterator<Expense> iter = list.listIterator();

        Expense expense;
        while(iter.hasNext()) {
            expense = iter.next();
            if (expense.getResolver()!=managerID) {
                iter.remove();
            }
        }
        return list;
    }

    public List<Expense> retrievePendingExpensesByManager(int managerID){
        List<Expense> list = retrievePendingExpenses();
        Iterator<Expense> iter = list.listIterator();

        Expense expense;
        while(iter.hasNext()) {
            expense = iter.next();
            if (expense.getResolver()!=managerID) {
                iter.remove();
            }
        }
        return list;
    }

    public Map<Integer, Integer> retrieveEmployeeMap(){
        UserDao dao = new UserDaoImpl();
        Map<Integer, Integer> map = dao.retrieveEmployeeMap();
        return map;
    }
}