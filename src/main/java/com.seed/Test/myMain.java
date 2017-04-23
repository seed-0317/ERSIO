package com.seed.Test;

import com.seed.Model.*;
import com.seed.Service.BusinessLogic;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class myMain {
    public static void main(String[] args) {
        BusinessLogic businessLogic = new BusinessLogic();

        List<String> firstName = Arrays.asList("Emma", "Noah", "Olivia", "Liam", "Sophia", "Mason", "Ava", "Jacob", "Isabella", "William", "Mia",
                "Ethan", "Abigail", "James", "Emily", "Alexander","Charlotte", "Michael", "Harper", "Benjamin");
        List<String> lastName = Arrays.asList("Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor",
                "Anderson", "Thomas","Jackson");
        int[] managerIDs = {4,5,6};

        Random generator = new Random();
        int randomIndex;

        //for (int i = 0; i < 100; i++) {
            randomIndex= generator.nextInt(firstName.size());
            String tempFirstName=firstName.get(randomIndex);

            randomIndex= generator.nextInt(lastName.size());
            String tempLastName=firstName.get(randomIndex);

            String email = tempFirstName+"."+tempLastName+"@ersio.com";

            randomIndex= generator.nextInt(managerIDs.length);
            int tempManager = managerIDs[randomIndex];

            String tempUserName ="u"+generator.nextInt(99999);

            //UserID will be created upon insertion into table
            User newUser = new User(0, tempUserName, tempFirstName, tempLastName, email, tempManager, "employee");
            businessLogic.createUser(newUser);
        //}
    }
}
