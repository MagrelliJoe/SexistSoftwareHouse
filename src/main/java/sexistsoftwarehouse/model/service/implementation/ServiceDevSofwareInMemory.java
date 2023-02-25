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
    public List<Developer> findDeveloperbyCompetence(String nameCompetence) {
        return repo.findByComepetence(nameCompetence);
    }

    @Override
    public List<Developer> findByComepetenceLevel(String nameCompetence, Level level) {
        return repo.findByComepetenceLevel(nameCompetence,level);
    }


    @Override
    public Developer saveDeveloper(Developer developer) {
        return repo.create(developer);
    }

    @Override
    public void updateDeveloper(Developer developer) {
        repo.update(developer);
    }

    @Override
    public void deleteDeveloperById(long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Developer> showDeveloper() {
        return repo.showDeveloper();
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
    public void addCompetence(Competence competence,Developer developer) {
        repo.addNewCompetence(competence,developer);
    }

    @Override
    public List<Developer> showDevelopersByNumOfCompetenceAndLevels(int numOfCompetence, Level level) {
        return  repo.showDevelopersByNumOfCompetenceAndLevels(numOfCompetence,level);
    }

    @Override
    public List<String> showNameCompetencebyDevelopersDistinct(Level level) {
       return  repo.showNameCompetencebyDevelopersDistinct(level);
    }

    @Override
    public List<Level> getLevelbyCompetence(List<Competence> competenceList) {
        return repo.getLevelbyCompetence(competenceList);
    }

}