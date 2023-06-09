/**
 * PainterFactory.java
 * This is the PainterFactory Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 07 April 2023
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Painter;
import za.ac.cput.util.Helper;

public class PainterFactory {
    public static Painter createPainter(String firstName, String lastName, String address, String email, String phoneNumber) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(phoneNumber)) {
            return null;
        }

        String painterId = Helper.generateId();

        if(!Helper.isValidEmail(email)) {
            return null;
        }

        Painter painter = new Painter.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPainterId(painterId)
                .setAddress(address)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .build();

        return painter;


    }
}
