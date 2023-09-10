/*
QuoteFactory.java
Entity for the quote factory
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/

package za.ac.cput.factory;

import za.ac.cput.domain.Quote;
import za.ac.cput.util.Helper;

public class QuoteFactory {
    public static Quote createQuote(String issueDate, String expiryDate, double totalCost, boolean status){
        if(Helper.isNullOrEmpty(issueDate)  || Helper.isNullOrEmpty(expiryDate) || !Helper.dateCheck(issueDate) || !Helper.dateCheck(expiryDate) || totalCost <= 0 ){
            return null;
        }

        String quoteNumber = Helper.generateId();

        Quote quote = new Quote.Builder()
                .setQuoteNumber(quoteNumber)
                .setIssueDate(issueDate)
                .setExpiryDate(expiryDate)
                .setStatus(status)
                .setTotalCost(totalCost)
                .build();

        return quote;
    }

}
