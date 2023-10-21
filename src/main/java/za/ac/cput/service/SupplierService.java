package za.ac.cput.service;

import za.ac.cput.domain.Supplier;

import java.util.List;
/*
 * Author: Ayanda Mcengwa
 * Student No: 218335989
 * Subject: Applications development practice 3
 * Term 4 Submission
 * This is the Supplier Service interface in business logic
 * due date: 21/10/2023
 * */
public interface SupplierService extends IService<Supplier, String> {
    List<Supplier> getAll();
}
