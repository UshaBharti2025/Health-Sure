package com.java.jsf.main;

import java.util.List;
import com.java.jsf.recipient.dao.RecipientDaoImpl;
import com.java.jsf.recipient.model.Recipient;

public class TestRecipientSearch {

    public static void main(String[] args) {
        
        RecipientDaoImpl dao = new RecipientDaoImpl();

        // Sample test data
        String nameToSearch = "ra";  // You can change this to anything like "an", "Sa", "ni", etc.

        System.out.println("========= Testing: searchByFirstNameStartsWith =========");
        List<Recipient> startsWithResults = dao.searchByFirstNameStartsWith(nameToSearch);
        if (startsWithResults.isEmpty()) {
            System.out.println("No recipients found starting with '" + nameToSearch + "'");
        } else {
            for (Recipient r : startsWithResults) {
                System.out.println("Found: " + r.gethId() + " | " + r.getFirstName() + " " + r.getLastName() + " | " + r.getMobile());
            }
        }

        System.out.println("\n========= Testing: searchByFirstNameContains =========");
        List<Recipient> containsResults = dao.searchByFirstNameContains(nameToSearch);
        if (containsResults.isEmpty()) {
            System.out.println("No recipients found containing '" + nameToSearch + "'");
        } else {
            for (Recipient r : containsResults) {
                System.out.println("Found: " + r.gethId() + " | " + r.getFirstName() + " " + r.getLastName() + " | " + r.getMobile());
            }
        }
    }
}
