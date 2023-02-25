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
    public List<Developer> findDeveloperbyCompetence(String nameCompetence,Level level) {
        return repo.findByComepetence(nameCompetence,level);
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


}