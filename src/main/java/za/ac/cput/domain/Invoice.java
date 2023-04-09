/*
Invoice.java
Entity for the invoice
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.domain;

import java.util.Objects;

public class Invoice {

    private String invoiceNumber;
    private String quoteNumber;
    private String issueDate;

    private int amountPaid;

    public Invoice() {}

    // Add private constructor

    private Invoice(Builder builder) {
        this.invoiceNumber = builder.invoiceNumber;
        this.quoteNumber = builder.quoteNumber;
        this.issueDate = builder.issueDate;
        this.amountPaid = builder.amountPaid;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getQuoteNumber() {
        return quoteNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public static class Builder {
        private String invoiceNumber;
        private String quoteNumber;
        private String issueDate;

        private int amountPaid;

        // SETTERS

        public Builder setInvoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder setQuoteNumber(String quoteNumber) {
            this.quoteNumber = quoteNumber;
            return this;
        }

        public Builder setIssueDate(String issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder setAmountPaid(int amountPaid) {
            this.amountPaid = amountPaid;
            return this;
        }

        public Builder copy(Invoice invoice) {
            this.invoiceNumber = invoice.invoiceNumber;
            this.quoteNumber = invoice.quoteNumber;
            this.issueDate = invoice.issueDate;
            this.amountPaid = invoice.amountPaid;
            return this;
        }

        public Invoice build() {
            return new Invoice(this);
        }
    }

    @Override
    public boolean equals(Object i) {
        if (this == i) return true;
        if (i == null || getClass() != i.getClass()) return false;
        Invoice invoice = (Invoice) i;
        return Objects.equals(invoiceNumber, invoice.invoiceNumber) &&
                Objects.equals(quoteNumber, invoice.quoteNumber) &&
                Objects.equals(issueDate, invoice.issueDate) &&
                Objects.equals(amountPaid, invoice.amountPaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceNumber, quoteNumber, issueDate, amountPaid);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber='" + invoiceNumber + '\'' +
                ", quoteNumber='" + quoteNumber + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", amountPaid=" + amountPaid +
                '}';
    }
}
