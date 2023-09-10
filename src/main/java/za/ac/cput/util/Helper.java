package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.test.util.AssertionErrors.assertTrue;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        if (s == null || s.isEmpty() || s.equals("") || s.equalsIgnoreCase(null)) {
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

    /*
    public static Boolean isValidEmail(String email) {
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }
    
     */

    public static boolean isValidEmail(String email)
    {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if (email == null)
            return false;
        return pattern.matcher(email).matches();
    }

   public static boolean isPhoneNumber(String phoneNumber){
       String sPhoneNumber = phoneNumber;

       Pattern pattern = Pattern.compile("^\\d{10}$");
       Matcher matcher = pattern.matcher(sPhoneNumber);

       if (matcher.matches()) {
           return true;
       }
       else
       {
           return false;
       }
   }

    public static boolean isZipCode(int zipCode){
        String zipcode = Integer.toString(zipCode);

        Pattern pattern = Pattern.compile("^\\d{4}$");
        Matcher matcher = pattern.matcher(zipcode);

        if (matcher.matches()) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isWithinRange(int number){
        int captured = number;
        if(captured < 1000 || captured > 9999 )
            return false;
        else{
            return true;
        }
    }

    public static boolean dateCheck(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        boolean valid;

        // Input to be parsed should strictly follow the defined date format
        // above.
        format.setLenient(false);

        String capturedDate = date;
        try {
            format.parse(date);
            valid = true;
        } catch (ParseException e) {
            valid = false;
            System.out.println("Date " + date + " is not valid according to " +
                    format.toPattern() + " pattern.");

        }
        return valid;
    }


}
