package com.seed.Test;

import com.seed.Model.*;
import com.seed.Service.BusinessLogic;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class myMain {
    public static void main(String[] args) {
        createExpenses(20);
    }

    public static void createUsers(int x) {
        BusinessLogic businessLogic = new BusinessLogic();

        List<String> firstName = Arrays.asList("Emma", "Noah", "Olivia", "Liam", "Sophia", "Mason", "Ava", "Jacob", "Isabella", "William", "Mia",
                "Ethan", "Abigail", "James", "Emily", "Alexander", "Charlotte", "Michael", "Harper", "Benjamin");
        List<String> lastName = Arrays.asList("Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor",
                "Anderson", "Thomas", "Jackson");
        int[] managerIDs = {4, 5, 6};

        Random generator = new Random();
        int randomIndex;

        for (int i = 0; i < x; i++) {
            randomIndex = generator.nextInt(firstName.size());
            String tempFirstName = firstName.get(randomIndex);

            randomIndex = generator.nextInt(lastName.size());
            String tempLastName = firstName.get(randomIndex);

            String email = tempFirstName + "." + tempLastName + "@ersio.com";

            randomIndex = generator.nextInt(managerIDs.length);
            int tempManager = managerIDs[randomIndex];

            String tempUserName = "u" + generator.nextInt(89999) + 10000;

            //UserID will be created upon insertion into table
            User newUser = new User(0, tempUserName, tempFirstName, tempLastName, email, tempManager, "employee");
            businessLogic.createUser(newUser);
            System.out.println(newUser);
        }
    }

    public static void createExpenses(int x) {
        BusinessLogic businessLogic = new BusinessLogic();
        Map<Integer, Integer> map = businessLogic.retrieveEmployeeMap();

        List<String> description = Arrays.asList("Travel", "Mileage", "Meal", "Lodging", "Supplies", "Fun Event");

        Random generator = new Random();

        for (int i = 0; i < x; i++) {
            double amount = (1.00*generator.nextInt(10000))/100;

            int type = generator.nextInt(6);
            int employee = generator.nextInt(29)+1;
            Expense newExpense = new Expense();
            newExpense.setAmount(amount);
            newExpense.setDescriptor(description.get(type));
            newExpense.setIdAuthor(employee);
            newExpense.setResolver(map.get(employee));
            newExpense.setType(description.get(type));
            System.out.println(newExpense);
            businessLogic.createExpense(newExpense);
        }
    }
}


