package com.seed.Servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
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

<<<<<<< HEAD
        String userName = request.getParameter("userNameForm");

        if(userName == null) {
=======
        String username = request.getParameter("userNameForm");
        System.out.println(username);
        if(username == null) {
>>>>>>> ae5e28068b7ef4e9682c1af8b859e9a182c0b2c5
            response.sendRedirect("Login.html");
        } else {
            HttpSession session = request.getSession();

            //Get user data and set attributes below:
            BusinessLogic businessLogic = new BusinessLogic();

<<<<<<< HEAD
            User user = businessLogic.login(userName);
=======
            User user = businessLogic.login(username);
            List<Expense> expenses = new LinkedList<>();
            Expense expenseone = new Expense("24", "200","descriptor of expense","receipt not used", "12/24",  "1/1", "Ben", "resolver", "meal", "pending");
            expenses.add(expenseone);
>>>>>>> ae5e28068b7ef4e9682c1af8b859e9a182c0b2c5
            if (user == null){
                response.sendRedirect("Login.html");
            }
            else{
                session.setAttribute("thisUser", user);//adding user Object to session

                session.setAttribute("userName", userName);
                session.setAttribute("userID", user.getUserID());
                session.setAttribute("firstName", user.getFirstName());
                session.setAttribute("lastName", user.getLastName());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("manager", user.getManager());
                session.setAttribute("userRoleType", user.getUserRoleType());

                //Send user to either employee home or manager home depending on UR_ROLE in ERSIO.ERS_USER_ROLES
<<<<<<< HEAD
                if (user.getUserRoleType().equals("employee")){
                    response.sendRedirect("Home.html");
                }
                else {
                    response.sendRedirect("Home.html");
                }
            }
=======

                if (user.getUserRoleType().equals("employee")){
                    session.setAttribute("thisUser", user);
                    response.sendRedirect("EmployeeHome.html");
                    }
                else {
                    session.setAttribute("thisUser", user);
                    response.sendRedirect("ManagerHome.html");
                    }
                }
            }
//            session.setAttribute("authUser", user);
//            response.sendRedirect("index.html");

>>>>>>> ae5e28068b7ef4e9682c1af8b859e9a182c0b2c5
        }
    }
