package com.seed.Servlet;

import com.seed.Model.Expense;
import com.seed.Service.BusinessLogic;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value="/PendingExpenses")
public class ViewPendingExpenses extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BusinessLogic businessLogic = new BusinessLogic();
        HttpSession session = request.getSession();
        String userRoleType=(String)session.getAttribute("userRoleType");
        int userID=(int)session.getAttribute("userID");

        List<Expense> expenses;
        if (userRoleType.equals("employee")){
            expenses = businessLogic.retrievePendingExpensesByAuthor(userID);
        }
        else{
            expenses = businessLogic.retrievePendingExpensesByManager(userID);
        }

        session.setAttribute("expenses", expenses);

        request.getRequestDispatcher("ExpenseGrid.html").forward(request, response);
    }
}