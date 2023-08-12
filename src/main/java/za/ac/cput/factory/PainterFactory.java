/**
 * PainterFactory.java
 * This is the PainterFactory Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 09 August 2023
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Painter;
import za.ac.cput.util.Helper;

public class PainterFactory {
    public static Painter createPainter(String firstName, String lastName, String phoneNumber, String email, String streetAddress, String city, String province, String postalCode) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(phoneNumber)) {
            return null;
        }

        String painterId = Helper.generateId();

        if(!Helper.isValidEmail(email)) {
            return null;
        }

        Painter painter = new Painter.Builder()
                .setPainterId(painterId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setStreetAddress(streetAddress)
                .setCity(city)
                .setProvince(province)
                .setPostalCode(postalCode)
                .build();

        return painter;

    }
}
