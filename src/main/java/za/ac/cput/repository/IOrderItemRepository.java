package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.OrderItem;

import java.util.List;

@Repository
public interface IOrderItemRepository extends JpaRepository<OrderItem, String> {
//    List<OrderItem> findAll();
}
