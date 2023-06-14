/**
 * ConsultantAddressFactory.java
 * This is the ConsultantAddressFactory POJO
 * @author Lerato Moshabi - 220076073
 * 07 April 2023
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Consultant;
import za.ac.cput.domain.ConsultantAddress;
import za.ac.cput.domain.PainterAddress;
import za.ac.cput.util.Helper;

public class ConsultantAddressFactory {

    public static ConsultantAddress createConsultantAddress(String consultantId, String addressId) {
        if (Helper.isNullOrEmpty(consultantId) || Helper.isNullOrEmpty(addressId)) {
            return null;
        }

        String consultantAddressId = Helper.generateId();


        ConsultantAddress consultantAddress = new ConsultantAddress.Builder()
                .setConsultantAddressId(consultantAddressId)
                .setConsultantId(consultantId)
                .setAddressId(addressId)
                .build();

        return consultantAddress;

    }
}
