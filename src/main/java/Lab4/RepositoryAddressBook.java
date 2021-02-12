package Lab4;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RepositoryAddressBook extends CrudRepository<AddressBook, Integer> {
    AddressBook findById(long id);
    List<AddressBook> findAll();
}
