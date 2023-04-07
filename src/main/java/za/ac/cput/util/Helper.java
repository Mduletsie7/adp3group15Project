/**
 * AnimalFactoryTest.java
 * This is the AnimalFactoryTest
 * @author
 * Lerato Moshabi - 220076073
 * Mdumisi Kelvin Letsie - 220120137
 * 11 March 2023
 */

package za.ac.cput.util;

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

}
