package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Orders;

import java.util.List;
@Repository
public interface IOrderRepository extends JpaRepository<Orders, String> {
//    List<Order> getAll();
}
