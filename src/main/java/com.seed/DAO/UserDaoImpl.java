package com.seed.DAO;

import com.seed.Model.User;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void createUser(User newUser) {
        try (Connection connection = ConnectionFactory.createConnection();) {

            PreparedStatement statement = connection.prepareStatement("insert into ERSIO.ERS_USERS(U_USERNAME, U_FIRSTNAME, U_LASTNAME," +
                    "U_EMAIL, U_MANAGER, UR_ID) " +
                    "values(?, ?, ?, ?, ?, ?)");
            statement.setString(1, newUser.getUserName());
            statement.setString(2, newUser.getFirstName());
            statement.setString(3, newUser.getLastName());
            statement.setString(4, newUser.getEmail());
            statement.setString(5, newUser.getManager());
            statement.setString(6, "1");//only able to create employees

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> retrieveUsers() {
        try (Connection connection = ConnectionFactory.createConnection();) {

            PreparedStatement statement = connection.prepareStatement("select U_ID, U_USERNAME, U_FIRSTNAME, U_LASTNAME, U_EMAIL, reports_to as U_MANAGER, B.UR_ROLE " +
                    "from ERSIO.ERS_USERS A JOIN ERSIO.ERS_USER_ROLES B ON A.UR_ID = B.UR_ID");

            ResultSet resultset = statement.executeQuery();

            if (resultset == null) {
                return null;
            } else {
                List<User> users = new LinkedList<>();

                while (resultset.next()) {
                    String userID = resultset.getString("U_ID");
                    String userName = resultset.getString("U_USERNAME");
                    String firstName = resultset.getString("U_FIRSTNAME");
                    String lastName = resultset.getString("U_LASTNAME");
                    String email = resultset.getString("U_EMAIL");
                    String manager = resultset.getString("U_MANAGER");//add U_MANAGER
                    String userRoleType = resultset.getString("UR_ROLE");

                    User temp = new User(userID, userName, firstName, lastName, email, manager, userRoleType);

                    users.add(temp);
                    System.out.println(temp);
                }
                return users;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User retrieveUser(String userName) {
        try (Connection connection = ConnectionFactory.createConnection();) {

            PreparedStatement statement = connection.prepareStatement("select U_ID, U_USERNAME, U_FIRSTNAME, U_LASTNAME, U_EMAIL, reports_to as U_MANAGER, B.UR_ROLE " +
                    "from ERSIO.ERS_USERS A JOIN ERSIO.ERS_USER_ROLES B ON A.UR_ID = B.UR_ID " +
                    "WHERE U_USERNAME = ? ");

            //Need to add single quotes around userName
            statement.setString(1, userName);

            ResultSet resultset = statement.executeQuery();

            if (resultset == null) {
                return null;
            } else {
                resultset.next();
                String userID = resultset.getString("U_ID");
                //String userName = resultset.getString("U_USERNAME");
                String firstName = resultset.getString("U_FIRSTNAME");
                String lastName = resultset.getString("U_LASTNAME");
                String email = resultset.getString("U_EMAIL");
                String manager = resultset.getString("U_MANAGER");
                String userRoleType = resultset.getString("UR_ROLE");

                User user = new User(userID, userName, firstName, lastName, email, manager, userRoleType);

                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(User updatedUser) {
        try (Connection connection = ConnectionFactory.createConnection();) {

            PreparedStatement statement = connection.prepareStatement("UPDATE ERSIO.ERS_USERS A" +
                    "SET U_FIRSTNAME=?," +
                    "U_LASTNAME=?," +
                    "U_EMAIL=?" +
                    "WHERE U_ID=?");

            //Need to add single quotes around userName
            statement.setString(1, updatedUser.getFirstName());
            statement.setString(2, updatedUser.getLastName());
            statement.setString(3, updatedUser.getEmail());
            statement.setString(4, updatedUser.getUserID());

            ResultSet resultset = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
