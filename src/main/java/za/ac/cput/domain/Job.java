package za.ac.cput.domain;

import java.util.Objects;

public class Job {


    private String quoteNo;
    private String startDate;
    private String endDate;
    private String invoiceNo;
    private String painterId;
    private String jobNo;

    public Job() {}

    // Add private constructor

    private Job(Builder builder) {
        this.quoteNo = builder.quoteNo;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.invoiceNo = builder.invoiceNo;
        this.painterId = builder.painterId;
        this.jobNo = builder.jobNo;
    }

    public String getQuote() {
        return quoteNo;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getInvoiceNo()  {
        return invoiceNo;
    }
    public String getPainterId() {
        return painterId;
    }

    public String getJobNo() {
        return jobNo;
    }

    public static class Builder {
        private String quoteNo;
        private String startDate;
        private String endDate;
        private  String invoiceNo;
        private  String painterId;
        private  String jobNo;


        // SETTERS
        public Builder setQuoteNo(String quoteNo) {
            this.quoteNo = quoteNo;
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setInvoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
            return this;
        }

        public Builder setPainterId(String painterId) {
            this.painterId = painterId;
            return this;
        }

        public Builder setJobNo(String jobNo) {
            this.jobNo = jobNo;
            return this;
        }

        public Builder copy(Job job) {
            this.quoteNo = job.quoteNo;
            this.startDate = job.startDate;
            this.endDate = job.endDate;
            this.invoiceNo = job.invoiceNo;
            this.painterId = job.painterId;
            this.jobNo = job.jobNo;
            return this;
        }

        public Job build() {
            return new Job(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(quoteNo, job.quoteNo) && Objects.equals(startDate, job.startDate) && Objects.equals(endDate, job.endDate) && Objects.equals(invoiceNo, job.invoiceNo) && Objects.equals(painterId, job.painterId) && Objects.equals(jobNo, job.jobNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quoteNo, startDate, endDate, invoiceNo, painterId, jobNo);
    }

    @Override
    public String toString() {
        return "Job{" +
                "quote='" + quoteNo + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", invoice='" + invoiceNo + '\'' +
                ", painterId='" + painterId + '\'' +
                ", jobNo='" + jobNo + '\'' +
                '}';
    }
}

