package com.seed.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.seed.Model.*;
import com.seed.Service.BusinessLogic;

@WebServlet(value="/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Login.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("userNameForm");
        System.out.println(username);
        if(username == null) {
            response.sendRedirect("Login.html");
        } else {
            HttpSession session = request.getSession();

            //Get user data and set attributes below:
            BusinessLogic businessLogic = new BusinessLogic();

            User user = businessLogic.login(username);
            if (user == null){
                response.sendRedirect("Login.html");
            }
            else{
                //Send user to either employee home or manager home depending on UR_ROLE in ERSIO.ERS_USER_ROLES
                if (user.getUserRoleType().equals("1")){
                    session.setAttribute("thisUser", user);
                    response.sendRedirect("index.html");
                }
                else {
                    session.setAttribute("thisUser", user);
                    response.sendRedirect("index.html");
                }
            }
//            session.setAttribute("firstName", user);
//            response.sendRedirect("index.html");

        }
    }
}