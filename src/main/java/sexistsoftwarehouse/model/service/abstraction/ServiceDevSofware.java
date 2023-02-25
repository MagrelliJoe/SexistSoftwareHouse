package sexistsoftwarehouse.model.service.abstraction;

import sexistsoftwarehouse.model.Competence;
import sexistsoftwarehouse.model.Developer;
import sexistsoftwarehouse.model.Level;

import java.util.List;
import java.util.Optional;

public interface ServiceDevSofware {
    Optional<Developer> findDeveloperById(long id);

    List<Developer> findDeveloperbyCompetence(String nameCompetence, Level level);

    Developer saveDeveloper(Developer developer);

    void updateDeveloper(Developer developer);

    void deleteDeveloperById(long id);
    List<Developer> showDeveloper();
    Competence Savecompetences(Competence competence);


}
