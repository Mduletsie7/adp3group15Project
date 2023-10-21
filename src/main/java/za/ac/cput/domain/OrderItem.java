package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Term 4 Submission
 * This is the OrderIterm domain layer and it represents a table inside a database
 * due date: 22/10/2023
 * */
@Entity
public class OrderItem {
    @Id
    private String orderItemId;
    private String orderId;
    private String itemOrdered;
    private String unitPrice;
    private String quantity;

    protected OrderItem() {}

    public OrderItem(Builder builder) {
        this.orderItemId = builder.orderItemId;
        this.orderId = builder.orderId;
        this.itemOrdered = builder.itemOrdered;
        this.unitPrice = builder.unitPrice;
        this.quantity = builder.quantity;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getItemOrdered() {
        return itemOrdered;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public static class Builder {
        public String orderItemId;
        private String orderId;
        private String itemOrdered;
        private String unitPrice;
        private String quantity;

        public Builder setOrderItemId(String orderItemId) {
            this.orderItemId = orderItemId;
        return this;
        }

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
        return this;
        }

        public Builder setItemOrdered(String itemOrdered) {
            this.itemOrdered = itemOrdered;
        return this;
        }

        public Builder setUnitPrice(String unitPrice) {
            this.unitPrice = unitPrice;
        return this;
        }

        public Builder setQuantity(String quantity) {
            this.quantity = quantity;
        return this;
        }

        public Builder copy(OrderItem orderItem) {
            this.orderItemId = orderItem.orderItemId;
            this.orderId = orderItem.orderId;
            this.itemOrdered = orderItem.itemOrdered;
            this.unitPrice = orderItem.unitPrice;
            this.quantity = orderItem.quantity;
            return this;
        }
        public OrderItem build(){ return new OrderItem(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem orderItem)) return false;
        return Objects.equals(orderItemId, orderItem.orderItemId) && Objects.equals(orderId, orderItem.orderId) && Objects.equals(itemOrdered, orderItem.itemOrdered) && Objects.equals(unitPrice, orderItem.unitPrice) && Objects.equals(quantity, orderItem.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemId, orderId, itemOrdered, unitPrice, quantity);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId='" + orderItemId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", itemOrdered='" + itemOrdered + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
