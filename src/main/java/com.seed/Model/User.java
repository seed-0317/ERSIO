package com.seed.Model;

/**
 * Created by bdq940 on 4/18/17.
 */
public class User {
    private String userID;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String userRoleID;
    private String userRoleType;

    public User (String userID, String userName, String firstName, String lastName, String  email, String userRoleID, String userRoleType){
        super();
        this.userID=userID;
        this.userName=userName;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.userRoleID=userRoleID;
        this.userRoleType=userRoleType;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(String userRoleID) {
        this.userRoleID = userRoleID;
    }

    public String getUserRoleType() {
        return userRoleType;
    }

    public void setUserRoleType(String userRoleType) {
        this.userRoleType = userRoleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userID.equals(user.userID)) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (userRoleID != null ? !userRoleID.equals(user.userRoleID) : user.userRoleID != null) return false;
        return userRoleType != null ? userRoleType.equals(user.userRoleType) : user.userRoleType == null;
    }

    @Override
    public int hashCode() {
        int result = userID.hashCode();
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userRoleID != null ? userRoleID.hashCode() : 0);
        result = 31 * result + (userRoleType != null ? userRoleType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userRoleID='" + userRoleID + '\'' +
                ", userRoleType='" + userRoleType + '\'' +
                '}';
    }
}
