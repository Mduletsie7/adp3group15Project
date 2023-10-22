package za.ac.cput.service;

import za.ac.cput.domain.OrderItem;

import java.util.List;

public interface OrderItemService extends IService<OrderItem, String> {
    List<OrderItem> getAll();
}
