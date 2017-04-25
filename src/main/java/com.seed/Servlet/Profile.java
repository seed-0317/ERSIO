package com.seed.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.seed.Model.User;
import com.seed.Service.BusinessLogic;

@WebServlet(value="/Profile")
public class Profile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Profile.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstNameForm");
        String lastName = request.getParameter("lastNameForm");
        String email = request.getParameter("emailForm");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        User oldUser=user;

        if (!firstName.equals("") && !firstName.equals(session.getAttribute("firstName"))){
            session.setAttribute("firstName", firstName);
            user.setFirstName(firstName);
        }
        if (!lastName.equals("") && !lastName.equals(session.getAttribute("lastName"))){
            session.setAttribute("lastName", lastName);
            user.setLastName(lastName);
        }
        if (!email.equals("") && !email.equals(session.getAttribute("email"))){
            session.setAttribute("email", email);
            user.setEmail(email);
        }

        BusinessLogic businessLogic = new BusinessLogic();

        if (!user.equals(oldUser)){
            businessLogic.updateUser(user);
        }
        request.getRequestDispatcher("Home.html").forward(request, response);
    }
}