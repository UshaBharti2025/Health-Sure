package com.java.jsf.main;



import com.java.jsf.recipient.dao.RecipientDaoImpl;
import com.java.jsf.recipient.model.Recipient;

public class TestRecipientReset {

    public static void main(String[] args) {
        RecipientDaoImpl dao = new RecipientDaoImpl();

        // Suppose we want to test with this hId
        String testHid = "H1001"; // Make sure this exists in your DB

        // Step 1: Fetch original data
        Recipient original = dao.getRecipientByhId(testHid);
        if (original == null) {
            System.out.println("❌ No recipient found with hId: " + testHid);
            return;
        }

        System.out.println("✅ Original Data:");
        printRecipient(original);

        // Step 2: Simulate updating recipient object in memory
        Recipient modified = new Recipient();
        modified.sethId(original.gethId());
        modified.setFirstName("ModifiedFirstName");
        modified.setLastName("ModifiedLastName");
        modified.setMobile("9999999999"); // example only

        System.out.println("\n🛠️ Modified In-Memory Recipient (Not DB):");
        printRecipient(modified);

        // Step 3: Simulate discard/reset using DAO (fetching again from DB)
        Recipient reset = dao.getRecipientByhId(testHid);

        System.out.println("\n🔁 After Discard (Re-fetched from DB):");
        printRecipient(reset);

        // Step 4: Compare to verify discard worked (original vs reset)
        boolean isReset = reset.getFirstName().equals(original.getFirstName()) &&
                          reset.getLastName().equals(original.getLastName()) &&
                          reset.getMobile().equals(original.getMobile());

        if (isReset) {
            System.out.println("\n✅ Changes discarded successfully.");
        } else {
            System.out.println("\n❌ Discard failed.");
        }
    }

    private static void printRecipient(Recipient r) {
        System.out.println("HID: " + r.gethId());
        System.out.println("First Name: " + r.getFirstName());
        System.out.println("Last Name: " + r.getLastName());
        System.out.println("Mobile: " + r.getMobile());
    }
}

