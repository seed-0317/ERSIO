package com.seed.DAO;

import com.seed.Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public void createUser(User newUser) {
        try(Connection connection = ConnectionFactory.createConnection();){

            PreparedStatement statement = connection.prepareStatement("insert into ERSIO.ERS_USERS(U_ID, U_USERNAME, U_FIRST_NAME, U_LAST_NAME," +
                    "U_EMAIL, UR_ID) " +
                    "values(?, ?, ?, ?, ?, ?)");
            statement.setString(1, newUser.getUserID());
            statement.setString(2, newUser.getUserName());
            statement.setString(3, newUser.getFirstName());
            statement.setString(4, newUser.getLastName());
            statement.setString(5, newUser.getEmail());
            statement.setString(6, newUser.getUserRoleID());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> retrieveUsers() {
        try(Connection connection = ConnectionFactory.createConnection();){

            PreparedStatement statement = connection.prepareStatement("select * from ERSIO.ERS_USERS");

            ResultSet resultset = statement.executeQuery();

            while(resultset.next()) {
                String userID = resultset.getString("U_ID");
                String userName = resultset.getString("U_USERNAME");
                String firstName = resultset.getString("U_FIRST_NAME");
                String lastName = resultset.getString("U_LAST_NAME");
                String email = resultset.getString("U_EMAIL");
                String userRoleID = resultset.getString("UR_ID");

                User temp = new User(userID, userName, firstName, lastName, email, userRoleID);

                System.out.println(temp);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
