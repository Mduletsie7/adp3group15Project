package za.ac.cput.domain;

import java.util.Objects;

public class Job {


    private String quote;
    private String startDate;
    private String endDate;
    private String invoice;
    private String painterId;
    private String jobNo;

    public Job() {}

    // Add private constructor

    private Job(Builder builder) {
        this.quote = builder.quote;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.invoice = builder.invoice;
        this.painterId = builder.painterId;
        this.jobNo = builder.jobNo;
    }

    public String getQuote() {
        return quote;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getInvoice()  {
        return invoice;
    }
    public String getPainterId() {
        return painterId;
    }

    public String getJobNo() {
        return jobNo;
    }

    public static class Builder {
        private String quote;
        private String startDate;
        private String endDate;
        private  String invoice;
        private  String painterId;
        private  String jobNo;


        // SETTERS
        public Builder setQuote(String quote) {
            this.quote = quote;
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

        public Builder setInvoice(String invoice) {
            this.invoice = invoice;
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
            this.quote = job.quote;
            this.startDate = job.startDate;
            this.endDate = job.endDate;
            this.invoice = job.invoice;
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
        return Objects.equals(quote, job.quote) && Objects.equals(startDate, job.startDate) && Objects.equals(endDate, job.endDate) && Objects.equals(invoice, job.invoice) && Objects.equals(painterId, job.painterId) && Objects.equals(jobNo, job.jobNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quote, startDate, endDate, invoice, painterId, jobNo);
    }

    @Override
    public String toString() {
        return "Job{" +
                "quote='" + quote + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", invoice='" + invoice + '\'' +
                ", painterId='" + painterId + '\'' +
                ", jobNo='" + jobNo + '\'' +
                '}';
    }
}

