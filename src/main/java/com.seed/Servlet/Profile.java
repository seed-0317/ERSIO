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
        request.getRequestDispatcher("UserGrid.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        HttpSession session = request.getSession();
        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);
        session.setAttribute("email", email);

        User user = (User) session.getAttribute("authUser");

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        BusinessLogic businessLogic = new BusinessLogic();

        businessLogic.updateUser(user);

        request.getRequestDispatcher("Home.html").forward(request, response);
    }
}