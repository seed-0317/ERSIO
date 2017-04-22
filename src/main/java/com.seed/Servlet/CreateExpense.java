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

@WebServlet(value="/CreateExpense")
public class CreateExpense extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("ExpenseForm.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String idAuthor= (String) session.getAttribute("userID");

        String amount=request.getParameter("SubmitAmount");
        String descriptor=request.getParameter("SubmitDescriptor");
        String type=request.getParameter("SubmitType");

        BusinessLogic businessLogic=new BusinessLogic();
        Expense newExpense =new Expense();
        newExpense.setAmount(amount);
        newExpense.setDescriptor(descriptor);
        newExpense.setType(type);
        newExpense.setIdAuthor(idAuthor);

        businessLogic.createExpense(newExpense);
    }
}