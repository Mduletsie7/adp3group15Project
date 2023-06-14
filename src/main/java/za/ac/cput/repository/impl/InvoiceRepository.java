/*
InvoiceRepository.java
Entity for the customer repository
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/

package za.ac.cput.repository.impl;

import za.ac.cput.domain.Invoice;
import za.ac.cput.repository.IInvoiceRepository;

import java.util.HashSet;
import java.util.Set;

public class InvoiceRepository implements IInvoiceRepository {
        private static InvoiceRepository repository = null;
        private Set<Invoice> invoiceDB = null;

    private InvoiceRepository(){
        invoiceDB = new HashSet<Invoice>();
    }

    public static InvoiceRepository getRepository(){
            if(repository == null){
                repository = new InvoiceRepository();
            }
            return repository;
        }


        @Override
        public Invoice create(Invoice invoice) {
            boolean success = invoiceDB.add(invoice);
            if(!success){
                return null;
            }
            return invoice;
        }

        @Override
        public Invoice read(String invoiceNumber) {
            // linear or sequential search
       /* for (Invoice i : invoiceDB){
            if(i.getInvoiceNumber().equalsIgnoreCase(invoiceNumber)){
                return i;
            }

        }
        return null;
*/
            // Lambda expressions Java 8
            Invoice invoice = invoiceDB.stream().
                    filter(i -> i.getInvoiceNumber()
                            .equals(invoiceNumber)).
                    findAny()
                    .orElse(null);
            return invoice;
        }

        @Override
        public Invoice update(Invoice invoice) {
            Invoice oldInvoice = read(invoice.getInvoiceNumber());
            if(oldInvoice != null){
                invoiceDB.remove(oldInvoice);
                invoiceDB.add(invoice);
                return invoice;
            }
            return null;
        }

        @Override
        public boolean delete(String invoiceNumber) {
            Invoice invoiceToDelete = read(invoiceNumber);
            if(invoiceToDelete == null) {
                return false;
            }
            invoiceDB.remove(invoiceToDelete);
            return true;
        }

        @Override
        public Set<Invoice> getAll() {
            return invoiceDB;
        }
}
