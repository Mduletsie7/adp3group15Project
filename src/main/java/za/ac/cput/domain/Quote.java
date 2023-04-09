/*
Quote.java
Entity for the quote
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.domain;

import java.util.Objects;

public class Quote {

    private String quoteNumber;
    private String businessName;
    private String businessAddress;
    private String issueDate;
    private String expiryDate;
    private String description;
    private int totalCost;

    public Quote() {}

    // Add private constructor

    private Quote(Builder builder) {
        this.quoteNumber = builder.quoteNumber;
        this.businessName = builder.businessName;
        this.businessAddress = builder.businessAddress;
        this.issueDate = builder.issueDate;
        this.expiryDate = builder.expiryDate;
        this.description = builder.description;
        this.totalCost = builder.totalCost;
    }

    public String getQuoteNumber() {
        return quoteNumber;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getDescription() {
        return description;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public static class Builder {
        private String quoteNumber;
        private String businessName;
        private String businessAddress;
        private String issueDate;
        private String expiryDate;
        private String description;
        private int totalCost;


        // SETTERS


        public Builder setQuoteNumber(String quoteNumber) {
            this.quoteNumber = quoteNumber;
            return this;
        }

        public Builder setBusinessName(String businessName) {
            this.businessName = businessName;
            return this;
        }

        public Builder setBusinessAddress(String businessAddress) {
            this.businessAddress = businessAddress;
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

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setTotalCost(int totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public Builder copy(Quote quote) {
            this.quoteNumber = quote.quoteNumber;
            this.businessName = quote.businessName;
            this.businessAddress = quote.businessAddress;
            this.issueDate = quote.issueDate;
            this.expiryDate = quote.expiryDate;
            this.description = quote.description;
            this.totalCost = quote.totalCost;
            return this;
        }

        public Quote build() {
            return new Quote(this);
        }
    }

    @Override
    public boolean equals(Object q) {
        if (this == q) return true;
        if (q == null || getClass() != q.getClass()) return false;
        Quote quote = (Quote) q;
        return Objects.equals(quoteNumber, quote.quoteNumber) && Objects.equals(businessName, quote.businessName) && Objects.equals(businessAddress, quote.businessAddress)
                && Objects.equals(issueDate, quote.issueDate) && Objects.equals(expiryDate, quote.expiryDate) &&
                Objects.equals(description, quote.description) && Objects.equals(totalCost, quote.totalCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quoteNumber, businessName, businessAddress, issueDate, expiryDate, description, totalCost);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quoteNumber='" + quoteNumber + '\'' +
                ", businessName='" + businessName + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", description='" + description + '\'' +
                ", totalCost=" + totalCost +
                '}';
    }
}
