/*
Quote.java
Entity for the quote
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/
package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Quote {
    @Id
    private String quoteNumber;
    private String issueDate;
    private String expiryDate;
    private double totalCost;
    private boolean status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customerId;

    public Quote() {}

    // Add private constructor

    private Quote(Builder builder) {
        this.quoteNumber = builder.quoteNumber;
        this.issueDate = builder.issueDate;
        this.expiryDate = builder.expiryDate;
        this.totalCost = builder.totalCost;
        this.status = builder.status;
        this.customerId = builder.customerId;
    }

    public String getQuoteNumber() {
        return quoteNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }


    public double getTotalCost() {
        return totalCost;
    }
    public boolean isStatus() {
        return status;
    }

    public Customer getCustomerId() {
        return customerId;
    }
    public static class Builder {
        private String quoteNumber;
        private String issueDate;
        private String expiryDate;
        private double totalCost;

        private boolean status;

        private Customer customerId;


        // SETTERS


        public Builder setQuoteNumber(String quoteNumber) {
            this.quoteNumber = quoteNumber;
            return this;
        }

        public Builder setIssueDate(String issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public Builder setTotalCost(double totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public Builder setStatus(boolean status) {
            this.status = status;
            return this;
        }

        public Builder setCustomerId(Customer customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder copy(Quote quote) {
            this.quoteNumber = quote.quoteNumber;
            this.issueDate = quote.issueDate;
            this.expiryDate = quote.expiryDate;
            this.status = quote.status;
            this.totalCost = quote.totalCost;
            this.customerId = quote.customerId;
            return this;
        }

        public Quote build() {
            return new Quote(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quote quote)) return false;
        return getTotalCost() == quote.getTotalCost() && isStatus() == quote.isStatus() && Objects.equals(getQuoteNumber(), quote.getQuoteNumber()) && Objects.equals(getIssueDate(), quote.getIssueDate()) && Objects.equals(getExpiryDate(), quote.getExpiryDate()) && Objects.equals(getCustomerId(), quote.getCustomerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuoteNumber(), getIssueDate(), getExpiryDate(), getTotalCost(), isStatus(), getCustomerId());
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quoteNumber='" + quoteNumber + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", totalCost=" + totalCost +
                ", status=" + status +
                ", customerId=" + customerId +
                '}';
    }
}
