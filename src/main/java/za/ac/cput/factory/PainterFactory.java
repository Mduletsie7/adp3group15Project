package za.ac.cput.factory;

import za.ac.cput.domain.Painter;
import za.ac.cput.util.Helper;

public class PainterFactory {
    public static Painter createPainter(String firstName, String lastName, String email, String phoneNumber) {
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
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .build();

        return painter;


    }
}
