package za.ac.cput.factory;

import za.ac.cput.domain.Job;
import za.ac.cput.util.Helper;

public class JobFactory {
    public static Job createJob(String quoteNo, String startDate, String endDate, String invoiceNo, String painterId) {
        if (Helper.isNullOrEmpty(quoteNo) || Helper.isNullOrEmpty(startDate) || Helper.isNullOrEmpty(endDate) || Helper.isNullOrEmpty(invoiceNo)
                || Helper.isNullOrEmpty(painterId)) {
            return null;
        }

        String jobNo = Helper.generateJobNumber();


        Job job = new Job.Builder()
                .setQuoteNo(quoteNo)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setInvoiceNo(invoiceNo)
                .setPainterId(painterId)
                .setJobNo(jobNo)
                .build();

        return job;


    }
}
