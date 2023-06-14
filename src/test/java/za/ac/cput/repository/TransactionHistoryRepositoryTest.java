package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.TransactionHistory;
import za.ac.cput.factory.TransactionHistoryFactory;
import za.ac.cput.repository.impl.TransactionHistoryRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class TransactionHistoryRepositoryTest {
    private static TransactionHistoryRepository transactionHistoryRepository = TransactionHistoryRepository.getTransactionHistoryRepository();
    private static TransactionHistory transactionHistory = TransactionHistoryFactory.createInvoice("002", "abc123", "04/09/2023", "15000");

    @Test
    public void a_create(){
        TransactionHistory transactionHistory1 = transactionHistoryRepository.create(transactionHistory);
        assertEquals(transactionHistory.getTransNo(), transactionHistory1.getTransNo());
        System.out.println("TransactionHistory: " + transactionHistory1);
    }
    @Test
    void b_read(){
        TransactionHistory transactionHistory1 = transactionHistoryRepository.read(transactionHistory.getTransNo());
        assertNotNull(transactionHistory1);
        System.out.println("transNo: " + transactionHistory1);
    }
    @Test
    void c_update(){
        TransactionHistory transactionHistory1 = new TransactionHistory.Builder().copy(transactionHistory)
                .setTransNo("354122")
                .setSupplierId("com12366")
                .setTransDate("09/04/2023")
                .setOrderTotal("15000")
                .build();
        assertNotNull(transactionHistoryRepository.update(transactionHistory1));
        System.out.println("Updated: " + transactionHistory1);
    }
    @Test
    void e_delete(){
        Boolean success = transactionHistoryRepository.delete(transactionHistory.getTransNo());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
    @Test
    void d_getAll(){
        System.out.println("Show all: ");
        System.out.println(transactionHistoryRepository.getAll());
    }

}
