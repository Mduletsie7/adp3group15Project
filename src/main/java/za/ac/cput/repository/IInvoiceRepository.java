/*
IInvoiceRepository.java
Interface for invoice repository
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/

package za.ac.cput.repository;

import za.ac.cput.domain.Invoice;

import java.util.List;
import java.util.Set;

public interface IInvoiceRepository extends IRepository<Invoice, String> {

    public Set<Invoice> getAll();


}
