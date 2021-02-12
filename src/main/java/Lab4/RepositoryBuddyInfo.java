package Lab4;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RepositoryBuddyInfo extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(String Name);
    BuddyInfo findById(long id);
}
