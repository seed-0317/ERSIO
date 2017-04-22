package com.seed.Servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.seed.Model.*;
import com.seed.Service.BusinessLogic;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

@WebServlet(value="/Login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Login.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userNameForm");

        if(userName == null) {
            response.sendRedirect("Login.html");
        } else {
            HttpSession session = request.getSession();

            //Get user data and set attributes below:
            BusinessLogic businessLogic = new BusinessLogic();

            User user = businessLogic.login(userName);
            if (user == null){
                response.sendRedirect("Login.html");
            }
            else{
                session.setAttribute("user", user);//adding user Object to session

                session.setAttribute("userName", userName);
                session.setAttribute("userID", user.getUserID());
                session.setAttribute("firstName", user.getFirstName());
                session.setAttribute("lastName", user.getLastName());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("manager", user.getManager());
                session.setAttribute("userRoleType", user.getUserRoleType());

                System.out.println(session.getAttribute("user"));
                System.out.println(session.getAttribute("userName"));
                System.out.println(session.getAttribute("userID"));
                System.out.println(session.getAttribute("firstName"));
                System.out.println(session.getAttribute("lastName"));
                System.out.println(session.getAttribute("email"));
                System.out.println(session.getAttribute("manager"));
                System.out.println(session.getAttribute("userRoleType"));

                //Send user to either employee home or manager home depending on UR_ROLE in ERSIO.ERS_USER_ROLES
                if (user.getUserRoleType().equals("employee")){
                    response.sendRedirect("Body.html");
                }
                else {
                    //List<Expense> expenses = businessLogic.retrieveExpenses();
                    //session.setAttribute("expenses", expenses);
                    response.sendRedirect("Body.html");
                }
            }
        }
    }
}