/*
IRepository.java
Main interface for repository package
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.repository;

public interface IRepository<V, ID> {
    V create(V v);
    V read(ID id);
    V update(V v);
    boolean delete(ID id);

}
