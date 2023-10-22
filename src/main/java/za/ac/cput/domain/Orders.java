package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Term 4 Submission
 * This is the Order Domain layer represents a table inside a database
 * due date: 22/10/2023
 * */
@Entity
public class Orders implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String orderId;
    private String supplierId;
    private String orderDate;
    private  String deliveryDate;
    private String totalAmount;

    public Orders() {
    }

    private Orders(Builder builder) {
        this.orderId = builder.orderId;
        this.supplierId = builder.supplierId;
        this.orderDate = builder.orderDate;
        this.deliveryDate = builder.deliveryDate;
        this.totalAmount = builder.totalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public static class Builder {
        private String orderId;
        private String supplierId;
        private String orderDate;
        private  String deliveryDate;
        private String totalAmount;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setSupplierId(String supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        public Builder setOrderDate(String orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setDeliveryDate(String deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public Builder setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder copy(Orders order) {
            this.orderId = order.orderId;
            this.supplierId = order.supplierId;
            this.orderDate = order.orderDate;
            this.deliveryDate = order.deliveryDate;
            this.totalAmount = order.totalAmount;
            return this;
        }
        public Orders build(){
            return new Orders(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders order)) return false;
        return Objects.equals(orderId, order.orderId) && Objects.equals(supplierId, order.supplierId) && Objects.equals(orderDate, order.orderDate) && Objects.equals(deliveryDate, order.deliveryDate) && Objects.equals(totalAmount, order.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, supplierId, orderDate, deliveryDate, totalAmount);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                '}';
    }
}
