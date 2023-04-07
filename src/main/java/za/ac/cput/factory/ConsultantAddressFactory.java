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
import za.ac.cput.util.Helper;

public class ConsultantAddressFactory {

    public static ConsultantAddress createConsultantAddress(Consultant consultantId, Address addressId) {
         /*String consultantId = Helper.generateId();
         String addressId = Helper.generateId();*/
        if (Helper.isNullOrEmpty(String.valueOf(consultantId)) || Helper.isNullOrEmpty(String.valueOf(addressId))){
            return null;
        }

        ConsultantAddress consultantAddress = new ConsultantAddress.Builder()
                .setConsultantId(consultantId)
                .setAddressId(addressId)
                .build();

        return consultantAddress;
    }
}
