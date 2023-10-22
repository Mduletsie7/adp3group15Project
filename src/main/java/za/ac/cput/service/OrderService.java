package za.ac.cput.service;

import za.ac.cput.domain.Orders;

import java.util.List;

public interface OrderService extends IService<Orders, String>{
    List<Orders>getAll();
}