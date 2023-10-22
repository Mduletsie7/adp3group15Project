package za.ac.cput.factory;

import za.ac.cput.domain.Orders;
import za.ac.cput.util.Helper;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Term 4 Submission
 * This is the OrderFactory where objects are created
 * due date: 21/10/2023
 * */
public class OrderFactory {
    public static Orders createOrder(String orderId, String supplierId, String orderDate, String deliveryDate, String totalAmount){
        if(Helper.isNullOrEmpty(orderId) ||Helper.isNullOrEmpty(supplierId) ||Helper.isNullOrEmpty(orderDate) || Helper.isNullOrEmpty(deliveryDate) ||Helper.isNullOrEmpty(totalAmount)){
            return null;
        }
        return new Orders.Builder().setOrderId(orderId)
                .setSupplierId(supplierId)
                .setOrderDate(orderDate)
                .setDeliveryDate(deliveryDate)
                .setTotalAmount(totalAmount)
                .build();
    }
}
