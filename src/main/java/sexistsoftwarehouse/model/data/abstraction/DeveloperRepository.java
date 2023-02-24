package sexistsoftwarehouse.model.data.abstraction;
import sexistsoftwarehouse.model.Developer;
import java.util.List;
import java.util.Optional;

public interface DeveloperRepository {
    Optional<Developer> findById(long id);

    List<Developer> findByComepetence(String nameCompetence);

    Developer create(Developer dev);

    void update(Developer dev);

    void deleteById(long id);
    public List<Developer> getActiveDeveloper();

}

