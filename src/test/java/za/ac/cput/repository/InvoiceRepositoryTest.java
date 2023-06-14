package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Invoice;
import za.ac.cput.factory.InvoiceFactory;
import za.ac.cput.repository.impl.InvoiceRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class InvoiceRepositoryTest {
    private static InvoiceRepository repository = InvoiceRepository.getRepository();
    private static Invoice invoice = InvoiceFactory.createInvoice("5", "07/06/2023", 4500);

    @Test
    void a_create() {
        Invoice created = repository.create(invoice);
        assertNotNull(created);
        assertEquals(invoice.getInvoiceNumber(), created.getInvoiceNumber());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Invoice read = repository.read(invoice.getInvoiceNumber());
        assertNotNull(read);
        System.out.println("Read: "+ read);

    }

    @Test
    void c_update() {
        Invoice updated = new Invoice.Builder().copy(invoice).setQuoteNumber("7").setIssueDate("08/07/2023")
                .setAmountPaid(6000).build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(invoice.getInvoiceNumber());
        assertTrue(success);
        System.out.println("Deleted "+ success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll().toString());
    }
}
