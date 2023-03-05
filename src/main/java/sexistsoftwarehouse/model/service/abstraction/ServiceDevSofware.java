package sexistsoftwarehouse.model.service.abstraction;
import sexistsoftwarehouse.model.Competence;
import sexistsoftwarehouse.model.Developer;
import sexistsoftwarehouse.model.Level;
import java.util.List;
import java.util.Optional;

public interface ServiceDevSofware {
    Optional<Developer> findDeveloperById(long id);
    List<Developer> showDeveloperbyCompetence(String nameCompetence);
    List<Developer> showDevelopersByCompetenceAndLevel(String nameCompetence,Level level);
    Developer saveDeveloper(Developer developer);
    void deleteDeveloperById(long id);
    List<Developer> showAllDevelopers();
    Competence Savecompetences(Competence competence);
    List<Developer> showDeveloperByNumberOfCompetence(int numberCompetence);
    void addCompetenceToDeveloper(Competence competence,Developer developer);
    List<Developer> showDevelopersByNumOfCompetenceAndLevels(int numOfCompetence,Level level);
    List<Competence> showCompetenceByLevel(Level level);
    List<Level> showLevelbyCompetence();
    double showAverageSalary();
    double showHighestSalary();
    boolean isSexistOrNot();

}
