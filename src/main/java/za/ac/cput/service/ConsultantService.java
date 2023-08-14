/**
 * ConsultantService.java
 * This is the Consultant POJO
 * @author Lerato Moshabi - 220076073
 * 14 August 2023
 */

package za.ac.cput.service;

import za.ac.cput.domain.Consultant;

import java.util.List;

public interface ConsultantService extends IService <Consultant, String>{
    List<Consultant> getAll();
}
