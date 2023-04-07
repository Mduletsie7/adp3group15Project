package za.ac.cput.domain;

import java.util.Objects;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Assignment 1
 * due date: 09/04/2023
 * */
public class TransactionHistory {
    private String transNo;
    private String supplierId;
    private String transDate;
    private  String orderTotal;

    public TransactionHistory() {
    }

    public TransactionHistory(Builder builder) {
        this.transNo = transNo;
        this.supplierId = supplierId;
        this.transDate = transDate;
        this.orderTotal = orderTotal;
    }

    public String getTransNo() {
        return transNo;
    }
    public String getSupplierId() {
        return supplierId;
    }
    public String getTransDate() {
        return transDate;
    }
    public String getOrderTotal() {
        return orderTotal;
    }
    private static class Builder {
        private String transNo;
        private String supplierId;
        private String transDate;
        private  String orderTotal;

        public Builder setTransNo(String transNo) {
            this.transNo = transNo;
            return this;
        }
        public Builder setSupplierId(String supplierId) {
            this.supplierId = supplierId;
            return this;
        }
        public Builder setTransDate(String transDate) {
            this.transDate = transDate;
            return this;
        }
        public Builder setOrderTotal(String orderTotal) {
            this.orderTotal = orderTotal;
            return this;
        }
        public Builder copy(TransactionHistory transactionHistory){
            this.transNo = transactionHistory.transNo;
            this.supplierId = transactionHistory.supplierId;
            this.transDate = transactionHistory.transDate;
            this.orderTotal = transactionHistory.orderTotal;
            return  this;
        }
        public TransactionHistory build(){
            return new TransactionHistory(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass()!= obj.getClass()) return false;
        TransactionHistory transactionHistory = (TransactionHistory) obj;
        return Objects.equals(transNo,transactionHistory.transNo)&& Objects.equals(supplierId, transactionHistory.supplierId)&& Objects.equals(transDate, transactionHistory.transDate)&& Objects.equals(orderTotal, transactionHistory.orderTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transNo, supplierId, transDate, orderTotal);
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "transNo='" + transNo + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", transDate='" + transDate + '\'' +
                ", orderTotal='" + orderTotal + '\'' +
                '}';
    }
}
