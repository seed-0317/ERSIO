package com.seed.DAO;

import com.seed.Model.Expense;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExpenseDaoImpl implements ExpenseDao {

    @Override
    public void createExpense(Expense newExpense) {
        try(Connection connection = ConnectionFactory.createConnection();){

            PreparedStatement statement = connection.prepareStatement("insert into ERSIO.ERS_REIMBURSEMENTS(R_AMOUNT, R_DESCRIPTION, " +
                    "R_SUBMITTED, R_RESOLVED, U_ID_AUTHOR, U_ID_RESOLVER, RT_TYPE, RT_STATUS) " +
                    "values(?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setDouble(1, newExpense.getAmount());
            statement.setString(2, newExpense.getDescriptor());

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/DD/YYYY");
            Date localDate = java.sql.Date.valueOf(java.time.LocalDate.now().format(dtf));
            statement.setString(3, localDate.toString());

            statement.setString(4, "");//Resolved date is empty when created

            statement.setInt(5, newExpense.getIdAuthor());
            statement.setString(6, "");//new expense cannot be resolved
            statement.setString(7, newExpense.getType());
            statement.setInt(8, 3);//set status to 3 for pending

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Expense> createListFromResultSet(ResultSet resultset) {

        try {
            List<Expense> list = new LinkedList<>();
            while (resultset.next()) {
                int expenseID = resultset.getInt("R_ID");
                Double amount = resultset.getDouble("R_AMOUNT");
                String descriptor = resultset.getString("R_DESCRIPTION");
                String submitted = resultset.getString("R_SUBMITTED");
                String resolved = resultset.getString("R_RESOLVED");
                int idAuthor = resultset.getInt("U_ID_AUTHOR");
                int resolver = resultset.getInt("U_ID_RESOLVER");
                String type = resultset.getString("RT_TYPE");
                String status = resultset.getString("RT_STATUS");

                Expense temp = new Expense(amount, descriptor, submitted, resolved, idAuthor, resolver, type, status);
                list.add(temp);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Expense> retrieveExpenses() {
        try(Connection connection = ConnectionFactory.createConnection();){

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT R_ID, R_AMOUNT, R_DESCRIPTION, R_SUBMITTED, R_RESOLVED, U_ID_AUTHOR, U_ID_RESOLVER, B.RT_TYPE, C.RS_STATUS AS RT_STATUS " +
                            "FROM ERSIO.ERS_REIMBURSEMENTS A " +
                            "LEFT JOIN ERSIO.ERS_REIMBURSEMENT_TYPE B " +
                            "ON A.RT_TYPE=B.RT_ID " +
                            "LEFT JOIN ERSIO.ERS_REIMBURSEMENT_STATUS C " +
                            "ON A.RT_STATUS=C.RS_ID " +
                            "WHERE RT_STATUS <> 3");

            ResultSet resultset = statement.executeQuery();
            return createListFromResultSet(resultset);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Expense> retrievePendingExpenses() {
        try(Connection connection = ConnectionFactory.createConnection();){

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT R_ID, R_AMOUNT, R_DESCRIPTION, R_SUBMITTED, R_RESOLVED, U_ID_AUTHOR, U_ID_RESOLVER, B.RT_TYPE, C.RS_STATUS AS RT_STATUS " +
                            "FROM ERSIO.ERS_REIMBURSEMENTS A " +
                            "LEFT JOIN ERSIO.ERS_REIMBURSEMENT_TYPE B " +
                            "ON A.RT_TYPE=B.RT_ID " +
                            "LEFT JOIN ERSIO.ERS_REIMBURSEMENT_STATUS C " +
                            "ON A.RT_STATUS=C.RS_ID " +
                            "WHERE RT_STATUS = 3");

            ResultSet resultset = statement.executeQuery();
            return createListFromResultSet(resultset);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void resolveExpense(String R_ID, String RS_STATUS, String managerUserName){
        try(Connection connection = ConnectionFactory.createConnection();){

            PreparedStatement statement = connection.prepareStatement("update ERSIO.ERS_REIMBURSEMENTS A" +
                    "SET RT_STATUS=?," +
                    "U_ID_RESOLVER=?," +
                    "R_RESOLVED=?" +
                    "WHERE R_ID=?");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/DD/YYYY");
            LocalDate localDate = LocalDate.now();

            statement.setString(1, RS_STATUS);
            statement.setString(2, managerUserName);
            statement.setString(3, localDate.toString());
            statement.setString(4, R_ID);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, String> retrieveExpenseTypes(){
        try(Connection connection = ConnectionFactory.createConnection();){

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT RT_ID, RT_TYPE FROM ERSIO.ERS_REIMBURSEMENT_TYPE");

            ResultSet resultset = statement.executeQuery();

            Map<Integer,String> map = new HashMap<>();

            while(resultset.next()) {
                Integer key = Integer.valueOf(resultset.getInt("RT_ID"));
                String type = resultset.getString("RT_TYPE");
                map.put(key,type);
            }
            return map;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<Integer, String> retrieveExpenseStatus(){
        try(Connection connection = ConnectionFactory.createConnection();){

            PreparedStatement statement = connection.prepareStatement(
                    "SELECT RS_ID, RS_STATUS FROM ERSIO.ERS_REIMBURSEMENT_STATUS");

            ResultSet resultset = statement.executeQuery();

            Map<Integer,String> map = new HashMap<>();

            while(resultset.next()) {
                Integer key = Integer.valueOf(resultset.getInt("RS_ID"));
                String status = resultset.getString("RS_STATUS");
                map.put(key,status);
            }
            return map;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
