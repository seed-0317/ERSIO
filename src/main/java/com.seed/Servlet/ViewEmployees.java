package com.seed.Servlet;

import com.seed.Model.User;
import com.seed.Service.BusinessLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value="/ViewEmployees")
public class ViewEmployees extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        BusinessLogic businessLogic = new BusinessLogic();
        List<User> employees = businessLogic.retrieveUsers((int)session.getAttribute("userID"));

        session.setAttribute("employees",employees);

        request.getRequestDispatcher("UserGrid.html").forward(request, response);
    }
}