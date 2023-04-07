package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
class AddressFactoryTest {

        // i. Object Equality Test
        @Test
        public void testCompareAddresses() {
            Address address = new Address();
            Address myAddress = AddressFactory.createAddress("105", "Mark Street", "Mhew", "652", "EC");
            String addressDetails = myAddress.getStreetName().toString();
            assertEquals(addressDetails, "Jackson Street");
        }


        // ii. Object Identity Test
        @Test
        public void testObjectIdentity() {
            Address address = new Address();
            Address address1 = AddressFactory.createAddress("25", "Whale Street", "dfghtrg", "8580", "WC");
            Address address2 =  address1;
            Address address3 = AddressFactory.createAddress("2083", "Shark Street", "rete", "8111", "WC");

            assertSame(address1, address3);
        }

        // iii. Animal build Failing TEST
        @Test
        public void test_fail(){
            Address address = AddressFactory.createAddress("893", "Dog Street","Woof", "8888", "WC");
            assertNotNull(address);
            System.out.println(address.toString());

        }

        // iv. Timeout Test
        @Test
        void testTimeOut() {
            assertTimeout(Duration.ofMillis(100), () -> {
                Thread.sleep(2000);

                System.out.println("Execution exceeded timout duration!");
            });
        }

        // v. Disabling Test
        @Disabled("TODO: Still need to code this method")
        @Test
        public void test_productInTransit() {
        }
}