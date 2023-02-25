package sexistsoftwarehouse.model.data.abstraction;
import sexistsoftwarehouse.model.Competence;
import sexistsoftwarehouse.model.Developer;
import sexistsoftwarehouse.model.Level;

import java.util.List;
import java.util.Optional;

public interface DeveloperRepository {
    Optional<Developer> findById(long id);

    List<Developer> findByComepetenceLevel(String nameCompetence,Level level);

    List<Developer> findByComepetence(String nameCompetence);

    Developer create(Developer dev);

    void update(Developer dev);

    void deleteById(long id);
    List<Developer> showDeveloper();
    Competence createCompetence(Competence competence);

    List<Developer> showDeveloperByNumberOfCompetence(int numberCompetence);

    Developer addNewCompetence(Competence competence,Developer developer);

    List<Developer> showDevelopersByNumOfCompetenceAndLevels(int numOfCompetence,Level level);

    List<String> showNameCompetencebyDevelopersDistinct(Level level);

    List<Level> getLevelbyCompetence(List<Competence> competenceList);

}

