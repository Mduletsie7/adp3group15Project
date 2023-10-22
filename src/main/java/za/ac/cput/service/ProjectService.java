/**
 * ProjectService.java
 * This is the Consultant POJO
 * @author Lerato Moshabi - 220076073
 * 14 August 2023
 */

package za.ac.cput.service;

import za.ac.cput.domain.Painter;
import za.ac.cput.domain.Project;

import java.util.List;

public interface ProjectService extends IService <Project, String>{
    List<Project> getAll();
}
