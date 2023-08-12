package za.ac.cput.factory;

import za.ac.cput.domain.TransactionHistory;
import za.ac.cput.util.Helper;

public class TransactionHistoryFactory {
public  static TransactionHistory createInvoice(String transNumber, String supplierId, String transDate, String orderTotal) {


    if (Helper.isNullOrEmpty(supplierId) || Helper.isNullOrEmpty(transDate) || Helper.isNullOrEmpty(orderTotal)) {


    }
    TransactionHistory transactionHistory = new TransactionHistory.Builder()
            .setTransNo(transNumber)
            .setSupplierId(supplierId)
            .setTransDate(transDate)
            .setOrderTotal(orderTotal)
            .build();
    return transactionHistory;
}
}
