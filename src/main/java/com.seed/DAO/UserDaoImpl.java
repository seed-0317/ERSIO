package com.seed.DAO;

import com.seed.Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public void createUser(User newUser) {
        try(Connection connection = ConnectionFactory.createConnection();){

            //Need to insert into ERSIO.ERS_USER_ROLES
            PreparedStatement statement = connection.prepareStatement("insert into ERSIO.ERS_USERS(U_ID, U_USERNAME, U_FIRST_NAME, U_LAST_NAME," +
                    "U_EMAIL, UR_ID, UR_ROLE) " +
                    "values(?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, newUser.getUserID());
            statement.setString(2, newUser.getUserName());
            statement.setString(3, newUser.getFirstName());
            statement.setString(4, newUser.getLastName());
            statement.setString(5, newUser.getEmail());
            statement.setString(6, newUser.getUserRoleID());
            statement.setString(7, newUser.getUserRoleType());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> retrieveUsers() {
        try(Connection connection = ConnectionFactory.createConnection();){

            PreparedStatement statement = connection.prepareStatement("select U_ID, U_USERNAME, U_FIRSTNAME, U_LASTNAME, U_EMAIL, A.UR_ID, B.UR_ID " +
                    "from ERSIO.ERS_USERS A JOIN ERSIO.ERS_USER_ROLES B ON A.UR_ID = B.UR_ID");

            ResultSet resultset = statement.executeQuery();

            if (resultset == null){
                return null;
            }
            else{
                List<User> users=new LinkedList<>();

                while(resultset.next()) {
                    String userID = resultset.getString("U_ID");
                    String userName = resultset.getString("U_USERNAME");
                    String firstName = resultset.getString("U_FIRST_NAME");
                    String lastName = resultset.getString("U_LAST_NAME");
                    String email = resultset.getString("U_EMAIL");
                    String userRoleID = resultset.getString("UR_ID");
                    String userRoleType = resultset.getString("UR_ROLE");

                    User temp = new User(userID, userName, firstName, lastName, email, userRoleID, userRoleType);

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
}
