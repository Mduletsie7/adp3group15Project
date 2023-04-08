/**
 * ServiceFactory.java
 * This is the ServiceFactory Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 07 April 2023
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Service;
import za.ac.cput.util.Helper;

public class ServiceFactory {

        public static Service createService(String serviceName) {
            if (Helper.isNullOrEmpty(serviceName)) {
                return null;
            }

            String serviceId = Helper.generateId();


            Service service = new Service.Builder()
                    .setServiceName(serviceName)
                    .setServiceId(serviceId)
                    .build();

            return service;


        }
}
