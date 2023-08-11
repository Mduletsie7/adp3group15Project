/**
 * JobFactory.java
 * This is the JobFactory Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 11 August 2023
 */

package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Job {


    @Id
    private String jobId;
    private String projectId;
    private String jobName;
    private String jobDescription;
    private String startDate;
    private String endDate;
    private String status;


    public Job() {}

    // Add private constructor

    private Job(Builder builder) {
        this.jobId = builder.jobId;
        this.projectId = builder.projectId;
        this.jobName = builder.jobName;
        this.jobDescription = builder.jobDescription;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.status = builder.status;
    }

    // GETTERS

    public String getJobId() {
        return jobId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public static class Builder {
        private String jobId;
        private String projectId;
        private String jobName;
        private String jobDescription;
        private String startDate;
        private String endDate;
        private String status;

        // SETTERS

        public Builder setJobId(String jobId) {
            this.jobId = jobId;
            return this;
        }
        public Builder setProjectId(String projectId) {
            this.projectId = Builder.this.projectId;
            return this;
        }
        public Builder setJobName(String jobName) {
            this.jobName = Builder.this.jobName;
            return this;
        }
        public Builder setJobDescription(String jobDescription) {
            this.jobDescription = Builder.this.jobDescription;
            return this;
        }
        public Builder setStartDate(String startDate) {
            this.startDate = Builder.this.startDate;
            return this;
        }
        public Builder setEndDate(String endDate) {
            this.endDate = Builder.this.endDate;
            return this;
        }
        public Builder setStatus(String status) {
            this.status = Builder.this.status;
            return this;
        }

        private Builder copy(Job job) {
            this.jobId = job.jobId;
            this.projectId = job.projectId;
            this.jobName = job.jobName;
            this.jobDescription = job.jobDescription;
            this.startDate = job.startDate;
            this.endDate = job.endDate;
            this.status = job.status;
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
        return Objects.equals(jobId, job.jobId) && Objects.equals(projectId, job.projectId) && Objects.equals(jobName, job.jobName) && Objects.equals(jobDescription, job.jobDescription) && Objects.equals(startDate, job.startDate) && Objects.equals(endDate, job.endDate) && Objects.equals(status, job.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, projectId, jobName, jobDescription, startDate, endDate, status);
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId='" + jobId + '\'' +
                ", projectId='" + projectId + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

