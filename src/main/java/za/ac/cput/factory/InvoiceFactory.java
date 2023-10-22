package za.ac.cput.factory;


import za.ac.cput.domain.Invoice;
import za.ac.cput.util.Helper;

public class InvoiceFactory {
    public static Invoice createInvoice(String quoteNumber, String issueDate, int amountPaid){
        if(Helper.isNullOrEmpty(quoteNumber) || Helper.isNullOrEmpty(issueDate) || amountPaid <= 0 ){
            return null;
        }

        String invoiceNumber = Helper.generateId();

        Invoice invoice = new Invoice.Builder()
                .setInvoiceNumber(invoiceNumber)
                .setQuoteNumber(quoteNumber)
                .setIssueDate(issueDate)
                .setAmountPaid(amountPaid)
                .build();

        return invoice;
    }
}
