/**
 * ConsultantFactory.java
 * This is the ConsultantFactory POJO
 * @author Lerato Moshabi - 220076073
 * 07 April 2023
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Consultant;
import za.ac.cput.util.Helper;

public class ConsultantFactory {

    public static Consultant createConsultant(String firstName, String lastName, String phoneNumber, String email, String address) {
        String consultantId = Helper.generateId();
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(phoneNumber) || Helper.isNullOrEmpty(String.valueOf(email)) || Helper.isNullOrEmpty(address)) {
            return null;
        }

        Consultant consultant = new Consultant.Builder()
                .setConsultantId(consultantId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setAddress(address)
                .build();

        return consultant;
    }
}
