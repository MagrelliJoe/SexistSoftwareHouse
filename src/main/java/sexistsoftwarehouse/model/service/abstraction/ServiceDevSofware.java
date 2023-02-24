package sexistsoftwarehouse.model.service.abstraction;

import sexistsoftwarehouse.model.Developer;

import java.util.List;
import java.util.Optional;

public interface ServiceDevSofware {
    Optional<Developer> findDeveloperById(long id);

    List<Developer> findDeveloperbyCompetence(String nameCompetence);

    Developer saveDeveloper(Developer developer);

    void updateDeveloper(Developer developer);

    void deleteDeveloperById(long id);
    boolean adjustActiveDeveloper(int numActive);
}
