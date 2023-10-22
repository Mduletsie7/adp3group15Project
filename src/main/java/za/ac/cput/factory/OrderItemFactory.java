package za.ac.cput.factory;

import za.ac.cput.domain.OrderItem;
import za.ac.cput.util.Helper;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Term 4 Submission
 * This is the OrderItem factory where object are created
 * due date: 22/10/2023
 * */
public class OrderItemFactory {
    public static OrderItem createOrderItem(String orderItemId, String orderId, String itemOrdered, String unitPrice, String quantity){
        if(Helper.isNullOrEmpty(orderItemId) ||Helper.isNullOrEmpty(orderId) ||Helper.isNullOrEmpty(itemOrdered) ||Helper.isNullOrEmpty(unitPrice) ||Helper.isNullOrEmpty(quantity)){
            return null;
        }
        return new OrderItem.Builder()
                .setOrderItemId(orderItemId)
                .setOrderId(orderId)
                .setItemOrdered(itemOrdered)
                .setUnitPrice(unitPrice)
                .setQuantity(quantity)
                .build();
    }
}
