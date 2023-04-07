package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Random;
import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        return false;
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }


    public static String generateJobNumber() {
        Random rand = new Random();
        String start = "Job";
        String jobNumber = null;
        for (int i = 0; i < 8; i++) {
            int n = rand.nextInt(10) + 0;
            jobNumber = start+= Integer.toString(n);
        }
        for (int i = 0; i < 16; i++) {
            if (i % 4 == 0)
                System.out.print(" ");
        }
        return jobNumber;
    }

    public static Boolean isValidEmail(String email) {
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }

}
