package sexistsoftwarehouse.model.data.abstraction;
import sexistsoftwarehouse.model.Competence;
import sexistsoftwarehouse.model.Developer;
import sexistsoftwarehouse.model.Level;

import java.util.List;
import java.util.Optional;

public interface DeveloperRepository {
    Optional<Developer> findById(long id); //ok
    List<Developer> getDevelopersByCompetenceAndLevel(String nameCompetence,Level level); //ok
    List<Developer> getDevelopersByComepetence(String nameCompetence); //ok
    Developer create(Developer dev); //ok
    void deleteById(long id);//ok
    List<Developer> getAllDeveloper();//ok
    Competence createCompetence(Competence competence);//ok
    List<Developer> showDeveloperByNumberOfCompetence(int numberCompetence);//ok
    Developer addNewCompetence(Competence competence,Developer developer);//ok
    List<Developer> getDevelopersByNumOfCompetenceAndLevels(int numOfCompetence,Level level);//ok
    List<Competence> getCompetencebyLevel(Level level);//ok
    List<Level> getLevelbyCompetence(List<Competence> competenceList);
    double getAverageSalary();//ok
    double getHighestSalary();//ok
    boolean isSexistOrNot();//ok


}

