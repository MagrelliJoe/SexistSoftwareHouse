package sexistsoftwarehouse.model.data.abstraction;
import sexistsoftwarehouse.model.Competence;
import sexistsoftwarehouse.model.Developer;
import sexistsoftwarehouse.model.Level;

import java.util.List;
import java.util.Optional;

public interface DeveloperRepository {
    Optional<Developer> findById(long id);

    List<Developer> findByComepetence(String nameCompetence,Level level);

    Developer create(Developer dev);

    void update(Developer dev);

    void deleteById(long id);
    List<Developer> showDeveloper();
    Competence createCompetence(Competence competence);

}

