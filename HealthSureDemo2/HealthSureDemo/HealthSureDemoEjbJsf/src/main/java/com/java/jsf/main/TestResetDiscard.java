package com.java.jsf.main;

import com.java.jsf.recipient.controller.RecipientController;
import com.java.jsf.recipient.dao.RecipientDaoImpl;
import com.java.jsf.recipient.model.Recipient;

public class TestResetDiscard {

    public static void main(String[] args) {
        // Create a DAO manually (not injected)
        RecipientDaoImpl dao = new RecipientDaoImpl();

        // Simulate a controller manually
        RecipientController controller = new RecipientController();
        controller.setRecipientDao(dao);

        // Step 1: Load initial recipient (simulate coming from DB)
        Recipient original = dao.getRecipientByhId("HID001");  // Replace with existing hId
        controller.setRecipient(original);
        System.out.println("Original Loaded -> " + controller.getRecipient().getFirstName());

        // Step 2: Simulate user making changes
        controller.getRecipient().setFirstName("FAKE NAME");
        System.out.println("User Changed -> " + controller.getRecipient().getFirstName());

        // Step 3: Now simulate discard/reset
        controller.resetUpdate();

        // Step 4: See if data is restored
        System.out.println("After Discard -> " + controller.getRecipient().getFirstName());
    }
}
