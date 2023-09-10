/*
InvoiceService.java
Entity for the invoice service
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/

package za.ac.cput.service;



/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Invoice;
import za.ac.cput.repository.IInvoiceRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InvoiceService implements IInvoiceService {

    private IInvoiceRepository repository;

    @Autowired
    private InvoiceService(IInvoiceRepository repository){
        this.repository = repository;
    }

    @Override
    public Invoice create(Invoice invoice){
        return this.repository.save(invoice);
    }

    @Override
    public Invoice read(String invoiceId){
        return this.repository.findById(invoiceId).orElse(null);
    }


    @Override
    public Invoice update(Invoice invoice){
        if(this.repository.existsById(invoice.getInvoiceNumber())){
            return this.repository.save(invoice);
        }
        return null;
    }
    @Override
    public boolean delete(String invoiceId){
        if(this.repository.existsById(invoiceId)){
            this.repository.deleteById(invoiceId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Invoice> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

}
 */
