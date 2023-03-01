package sexistsoftwarehouse.model.service.implementation;
import sexistsoftwarehouse.model.Competence;
import sexistsoftwarehouse.model.Developer;
import sexistsoftwarehouse.model.Level;
import sexistsoftwarehouse.model.data.abstraction.DeveloperRepository;
import sexistsoftwarehouse.model.service.abstraction.ServiceDevSofware;
import java.util.List;
import java.util.Optional;

public class ServiceDevSofwareInMemory implements ServiceDevSofware {

    private DeveloperRepository repo;
    public ServiceDevSofwareInMemory(DeveloperRepository repo){
        this.repo=repo;
    }
    @Override
    public Optional<Developer> findDeveloperById(long id) {
      return repo.findById(id);
    }

    @Override
    public List<Developer> showDeveloperbyCompetence(String nameCompetence) {
        return repo.getDevelopersByComepetence(nameCompetence);
    }

    @Override
    public List<Developer> showDevelopersByCompetenceAndLevel(String nameCompetence, Level level) {
        return repo.getDevelopersByCompetenceAndLevel(nameCompetence,level);
    }

    @Override
    public Developer saveDeveloper(Developer developer) {
        return repo.create(developer);
    }


    @Override
    public void deleteDeveloperById(long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Developer> showAllDevelopers() {
        return repo.getAllDeveloper();
    }

    @Override
    public Competence Savecompetences(Competence competence) {
        return repo.createCompetence(competence);
    }

    @Override
    public List<Developer> showDeveloperByNumberOfCompetence(int numberCompetence) {
        return repo.showDeveloperByNumberOfCompetence(numberCompetence);
    }

    @Override
    public void addCompetenceToDeveloper(Competence competence,Developer developer) {
        repo.addNewCompetence(competence,developer);
    }

    @Override
    public List<Developer> showDevelopersByNumOfCompetenceAndLevels(int numOfCompetence, Level level) {
        return  repo.getDevelopersByNumOfCompetenceAndLevels(numOfCompetence,level);
    }

    @Override
    public List<Competence> showCompetenceByLevel(Level level) {
       return  repo.getCompetencebyLevel(level);
    }

    @Override
    public List<Level> showLevelbyCompetence(List<Competence> competenceList) {
        return repo.getLevelbyCompetence(competenceList);
    }

    @Override
    public double showAverageSalary() {
        return repo.getAverageSalary();
    }

    @Override
    public double showHighestSalary() {
        return repo.getHighestSalary();
    }

    @Override
    public boolean isSexistOrNot() {
        return repo.isSexistOrNot();
    }

}