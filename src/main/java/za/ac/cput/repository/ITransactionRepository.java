package za.ac.cput.repository;

import za.ac.cput.domain.Supplier;
import za.ac.cput.domain.TransactionHistory;

import java.util.Set;

public interface ITransactionRepository {
    public Set<TransactionHistory> getAll();
}
