package za.ac.cput.service;

import za.ac.cput.domain.Consultant;

import java.util.List;

public interface ConsultantService extends IService <Consultant, String>{
    List<Consultant> getAll();
}
