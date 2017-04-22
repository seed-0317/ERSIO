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

@WebServlet(value="/ViewPendingExpenses")
public class ViewPendingExpenses extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BusinessLogic businessLogic = new BusinessLogic();
        List<Expense> expenses = businessLogic.retrievePendingExpenses();

        HttpSession session = request.getSession();
        session.setAttribute("expenses", expenses);

        request.getRequestDispatcher("Expenses.html").forward(request, response);
    }
}