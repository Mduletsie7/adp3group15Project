/**
 * ConsultantFactory.java
 * This is the ConsultantFactory POJO
 * @author Lerato Moshabi - 220076073
 * 14 August 2023
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Consultant;
import za.ac.cput.util.Helper;

public class ConsultantFactory {

    public static Consultant createConsultant(String firstName, String lastName, String address, String email, String phoneNumber) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(phoneNumber)) {
            return null;
        }

        String consultantId = Helper.generateId();

        if(!Helper.isValidEmail(email)) {
            return null;
        }

        Consultant consultant = new Consultant.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setConsultantId(consultantId)
                .setAddress(address)
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .build();

        return consultant;
    }
}
