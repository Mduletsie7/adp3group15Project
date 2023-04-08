/*
Helper.java
Class handling validation
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.util;

import org.apache.commons.validator.EmailValidator;

import java.util.UUID;

public class Helper {
    public static boolean isNullOrEmpty(String s){
        return (s == null || s.isEmpty() || s.equals("") || s.equalsIgnoreCase(null));
    }

    public static String generateId(){
        return UUID.randomUUID().toString();
    }

    public static boolean isValidEmail(String email){
        EmailValidator ev = EmailValidator.getInstance();
        return ev.isValid(email);
    }


}
