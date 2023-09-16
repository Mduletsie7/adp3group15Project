/*
Invoice.java
Entity for the invoice
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/
package za.ac.cput.domain;

//@Entity
//@Table(name = "invoice")
public class Invoice {
/*
    @Id
    private String invoiceNumber;
    @OneToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private Project projectId;
    private String issueDate;
    private double amountPaid;

    public Invoice() {}

    // Add private constructor

    private Invoice(Builder builder) {
        this.invoiceNumber = builder.invoiceNumber;
        this.projectId = builder.projectId;
        this.issueDate = builder.issueDate;
        this.amountPaid = builder.amountPaid;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public Project getProjectId() {
        return projectId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public static class Builder {
        private String invoiceNumber;
        private Project projectId;
        private String issueDate;
        private double amountPaid;

        // SETTERS

        public Builder setInvoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder setProjectId(Project projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder setIssueDate(String issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder setAmountPaid(double amountPaid) {
            this.amountPaid = amountPaid;
            return this;
        }

        public Builder copy(Invoice invoice) {
            this.invoiceNumber = invoice.invoiceNumber;
            this.projectId = invoice.projectId;
            this.issueDate = invoice.issueDate;
            this.amountPaid = invoice.amountPaid;
            return this;
        }

        public Invoice build() {
            return new Invoice(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice invoice)) return false;
        return getAmountPaid() == invoice.getAmountPaid() && Objects.equals(getInvoiceNumber(), invoice.getInvoiceNumber()) && Objects.equals(getProjectId(), invoice.getProjectId()) && Objects.equals(getIssueDate(), invoice.getIssueDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceNumber(), getProjectId(), getIssueDate(), getAmountPaid());
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber='" + invoiceNumber + '\'' +
                ", projectId=" + projectId +
                ", issueDate='" + issueDate + '\'' +
                ", amountPaid=" + amountPaid +
                '}';
    }
 */
}
