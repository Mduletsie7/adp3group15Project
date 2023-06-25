package za.ac.cput.service;

import za.ac.cput.domain.Service;

import java.util.Set;

public interface ServiceService extends IService <Service, String> {

    Set<Service> getAll();
}
