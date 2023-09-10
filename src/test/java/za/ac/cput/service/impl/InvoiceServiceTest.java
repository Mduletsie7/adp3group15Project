/*
InvoiceServiceTest.java
Tests the invoice service
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class InvoiceServiceTest {
/*
    @Autowired
    private InvoiceService invoiceService;

    private static Customer customer = CustomerFactory.createCustomer("Tom", "Ford", "0693618412", "tf@gmail.com");
    private static Project project = ProjectFactory.createProject(customer,"Amazon Offices","02/03/23","05/05/23","20000","true");
    private static Invoice invoice =  InvoiceFactory.createInvoice(project,"05/05/23", 20000);

    @Test
    void a_create(){
        System.out.print("Created: ");
        Invoice created = invoiceService.create(invoice);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read(){
        System.out.println("Read: ");
        Invoice read = invoiceService.read(invoice.getInvoiceNumber());
        assertEquals(read.getInvoiceNumber(), invoice.getInvoiceNumber());
        System.out.println(read);
    }

    @Test
    void c_update(){
        System.out.println("Updated: ");
        Invoice updated = invoiceService.update(new Invoice.Builder().copy(invoice).setAmountPaid(25000).build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void d_delete(){
        System.out.println("Deleted: ");
        boolean success = invoiceService.delete(invoice.getInvoiceNumber());
        assertTrue(success);
        System.out.println(success);
    }

    @Test
    void e_getAll(){
        System.out.println("Get all: ");
        System.out.println(invoiceService.getAll());
    }
 */

}
