package com.seed.Servlet;

import com.seed.Model.Expense;
import com.seed.Service.BusinessLogic;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(value="/PendingExpenses")
public class PendingExpenses extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BusinessLogic businessLogic = new BusinessLogic();
        HttpSession session = request.getSession();
        String userRoleType=(String)session.getAttribute("userRoleType");
        int userID=(int)session.getAttribute("userID");

        List<Expense> expenses = businessLogic.retrievePendingExpensesByManager(userID);

        session.setAttribute("expenses", expenses);

        request.getRequestDispatcher("ExpenseGrid.html").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BusinessLogic businessLogic = new BusinessLogic();

        Map<String, String[]> myMap = request.getParameterMap();

        Map<String, Integer> statusLookup= businessLogic.retrieveExpenseStatus();

        for (String key : myMap.keySet()) {
            int RS_ID = Integer.parseInt(key);
            String status = myMap.get(key)[0];
            int RS_STATUS=statusLookup.get(status);

            businessLogic.resolveReimbursement(RS_ID, RS_STATUS);
        }
        request.getRequestDispatcher("ExpenseGrid.html").forward(request, response);
    }
}