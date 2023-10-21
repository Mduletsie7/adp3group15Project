package za.ac.cput.service;

import za.ac.cput.domain.Order;

import java.util.List;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Term 4 Submission
 * This is the Order Service interface in the service layer
 * due date: 22/10/2023
 * */
public interface OrderService extends IService<Order, String>{
    List<Order>getAll();
}
