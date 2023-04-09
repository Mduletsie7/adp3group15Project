/*
IQuoteRepository.java
Interface for quote repository
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.repository;
import za.ac.cput.domain.Quote;

import java.util.List;
import java.util.Set;

public interface IQuoteRepository extends IRepository<Quote, String>{

    public Set<Quote> getAll();

}
