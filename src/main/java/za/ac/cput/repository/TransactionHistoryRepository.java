package za.ac.cput.repository;
import za.ac.cput.domain.TransactionHistory;

import java.util.HashSet;
import java.util.Set;

public class TransactionHistoryRepository implements ITransactionRepository {
    public static TransactionHistory transactionHistoryRepository = null;
    private Set<TransactionHistory> transactionHistoryDB = null;
    private TransactionHistoryRepository(){
        transactionHistoryDB = new HashSet<TransactionHistory>();
    }
    public static TransactionHistoryRepository getTransactionHistoryRepository(){
        if(transactionHistoryRepository==null){
            transactionHistoryRepository= new TransactionHistory();
        }
        return null;
    }
    //creating a new supplier
    public TransactionHistory create(TransactionHistory transactionHistory){
        boolean success = transactionHistoryDB.add(transactionHistory);
        if(!success){
            return null;
        }
        return transactionHistory;
    }
    //retrieving a supplier
    public TransactionHistory read(String transactionHistoryId) {
        // Lambda expressions Java 8
        TransactionHistory transactionHistory = transactionHistoryDB.stream()
                .filter(j -> j.getTransNo().equals(transactionHistoryId))
                .findAny()
                .orElse(null);
        return transactionHistory;
    }
    public TransactionHistory update(TransactionHistory transactionHistory){
        TransactionHistory oldTransaction = read(transactionHistory.getTransNo());
        if(oldTransaction != null){
            transactionHistoryDB.remove(oldTransaction);
            transactionHistoryDB.add(transactionHistory);
            return transactionHistory;
        }
        return null;
    }
    public boolean delete(String transactionHistoryId) {
        TransactionHistory transactionHistoryToDelete = read(transactionHistoryId);
        if (transactionHistoryToDelete == null){
            return false;
        }
        transactionHistoryDB.remove(transactionHistoryToDelete);
        return true;
    }
    public Set<TransactionHistory> getAll() {
        return transactionHistoryDB;
    }

}
