package sexistsoftwarehouse.model.data.implementation;

import sexistsoftwarehouse.model.Developer;
import sexistsoftwarehouse.model.data.abstraction.DeveloperRepository;

import java.util.List;
import java.util.Optional;

public class DeveloperRepositoryInMemory implements DeveloperRepository {
    @Override
    public Optional<Developer> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Developer> findByComepetence(String nameCompetence) {
        return null;
    }

    @Override
    public Developer create(Developer dev) {
        return null;
    }

    @Override
    public void update(Developer dev) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<Developer> getActiveDeveloper() {
        return null;
    }
}
