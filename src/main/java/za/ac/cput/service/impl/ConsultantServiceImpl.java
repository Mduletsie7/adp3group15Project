/**
 * ConsultsantServiceImpl.java
 * This is the Consultant POJO
 * @author Lerato Moshabi - 220076073
 * 14 August 2023
 */

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Consultant;
import za.ac.cput.repository.IConsultantRepository;
import za.ac.cput.service.ConsultantService;

import java.util.List;

@Service
public class ConsultantServiceImpl implements ConsultantService {
    private IConsultantRepository repository;

    @Autowired
    private ConsultantServiceImpl(IConsultantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Consultant create(Consultant consultant) {
        return this.repository.save(consultant);
    }

    @Override
    public Consultant read(String consultantId) {
        return this.repository.findById(consultantId).orElse(null);
    }

    @Override
    public Consultant update(Consultant consultant) {
        if (this.repository.existsById(consultant.getConsultantId()))
            return this.repository.save(consultant);
        return null;
    }

    @Override
    public boolean delete(String consultantId) {
        if (this.repository.existsById(consultantId)) {
            this.repository.deleteById(consultantId);
            return true;
        }
        return false;
    }

    @Override
    public List<Consultant> getAll() {
        return this.repository.findAll();
    }
}
