/**
 * JobFactory.java
 * This is the JobFactory Class
 * @author Mdumisi Kelvin Letsie - 220120137
 * 11 August 2023
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Job;
import za.ac.cput.util.Helper;

public class JobFactory {
    public static Job createJob(String projectId, String jobName, String jobDescription, String startDate, String endDate, String status) {
        if (Helper.isNullOrEmpty(projectId) || Helper.isNullOrEmpty(jobName) || Helper.isNullOrEmpty(jobDescription) || Helper.isNullOrEmpty(startDate)
                || Helper.isNullOrEmpty(endDate) || Helper.isNullOrEmpty(status)) {
            return null;
        }

        String jobId = Helper.generateJobNumber();


        Job job = new Job.Builder()
                .setJobId(jobId)
                .setProjectId(projectId)
                .setJobName(jobName)
                .setJobDescription(jobDescription)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setStatus(status)
                .build();

        return job;

    }
}
