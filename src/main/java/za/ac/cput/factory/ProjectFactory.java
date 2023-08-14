package za.ac.cput.factory;

import za.ac.cput.domain.Project;
import za.ac.cput.util.Helper;

public class ProjectFactory {
    public static Project createProject(String projectName, String startDate, String endDate, String totalCost, String status) {
        if (Helper.isNullOrEmpty(projectName) || Helper.isNullOrEmpty(startDate) || Helper.isNullOrEmpty(endDate) || Helper.isNullOrEmpty(totalCost) || Helper.isNullOrEmpty(status)) {
            return null;
        }

        String projectId = Helper.generateId();

        Project project = new Project.Builder()
                .setProjectId(projectId)
                .setProjectName(projectName)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setTotalCost(totalCost)
                .setStatus(status)
                .build();
        return project;
    }
}
