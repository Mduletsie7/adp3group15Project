package za.ac.cput.repository;

import za.ac.cput.domain.SuppPickupAddress;
import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.TransactionHistory;

import java.util.Set;

public interface ITransactionRepository extends IRepository<TransactionHistory, String> {
    public Set<TransactionHistory> getAll();
}
