package za.ac.cput.factory;

import za.ac.cput.domain.Quote;
import za.ac.cput.util.Helper;

public class QuoteFactory {
    public static Quote createQuote(String businessName, String businessAddress, String issueDate, String expiryDate, String description, int totalCost){
        if(Helper.isNullOrEmpty(businessName) || Helper.isNullOrEmpty(businessAddress)  || Helper.isNullOrEmpty(issueDate)  || Helper.isNullOrEmpty(expiryDate)  || Helper.isNullOrEmpty(description) || totalCost <= 0 ){
            return null;
        }

        String quoteNumber = Helper.generateId();

        Quote quote = new Quote.Builder()
                .setQuoteNumber(quoteNumber)
                .setBusinessName(businessName)
                .setIssueDate(issueDate)
                .setExpiryDate(expiryDate)
                .setDescription(description)
                .setTotalCost(totalCost)
                .build();

        return quote;
    }

}
