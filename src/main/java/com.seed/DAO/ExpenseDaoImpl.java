package com.seed.DAO;

import com.seed.Model.Expense;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ExpenseDaoImpl implements ExpenseDao {

    @Override
    public void createExpense(Expense newExpense) {
        try(Connection connection = ConnectionFactory.createConnection();){

            PreparedStatement statement = connection.prepareStatement("insert into ERSIO.ERS_REIMBURSEMENTS(R_ID, R_AMOUNT, R_DESCRIPTION, R_RECEIPT," +
                    "R_SUBMITTED, R_RESOLVED, U_ID_AUTHOR, U_ID_RESOLVER, RT_TYPE, RT_STATUS) " +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, newExpense.getExpenseID());
            statement.setString(2, newExpense.getAmount());
            statement.setString(3, newExpense.getDescriptor());
            statement.setString(4, newExpense.getReceipt());
            statement.setString(5, newExpense.getSubmitted());
            statement.setString(6, newExpense.getResolved());
            statement.setString(7, newExpense.getIdAuthor());
            statement.setString(8, newExpense.getIdAuthor());
            statement.setString(9, newExpense.getStatus());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Expense> retrieveExpenses() {
        try(Connection connection = ConnectionFactory.createConnection();){

            PreparedStatement statement = connection.prepareStatement("select * from ERSIO.ERS_REIMBURSEMENTS");

            ResultSet resultset = statement.executeQuery();

            while(resultset.next()) {
                String expenseID = resultset.getString("R_ID");
                String amount = resultset.getString("R_AMOUNT");
                String descriptor = resultset.getString("R_DESCRIPTOR");
                String receipt = resultset.getString("R_RECEIPT");
                String submitted = resultset.getString("R_SUBMITTED");
                String resolved = resultset.getString("R_RESOLVED");
                String idAuthor = resultset.getString("U_ID_AUTHOR");
                String resolver = resultset.getString("U_ID_RESOLVER");
                String type = resultset.getString("RT_TYPE");
                String status = resultset.getString("RT_STATUS");

                Expense temp = new Expense(expenseID, amount, descriptor,receipt,submitted,resolved, idAuthor, resolver, type, status);

                System.out.println(temp);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
