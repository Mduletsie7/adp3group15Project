/**
 * IRepository.java
 * This is the IRepository POJO
 * @author Lerato Moshabi - 220076073
 * 07 April 2023
 */

package za.ac.cput.repository;

@Deprecated
public interface IRepository<T, ID>{
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
