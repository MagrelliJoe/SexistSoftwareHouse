package sexistsoftwarehouse.model.data.implementation;

import sexistsoftwarehouse.model.Competence;
import sexistsoftwarehouse.model.Developer;
import sexistsoftwarehouse.model.Level;
import sexistsoftwarehouse.model.data.abstraction.DeveloperRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeveloperRepositoryInMemory implements DeveloperRepository {
    private  List<Developer> developers = new ArrayList<>();
    private List<Competence> competences = new ArrayList<>();
    private long Id;
    private long IdCompetence;

    @Override
    public Optional<Developer> findById(long id) {
        Developer dev = developers.get((int) id);
        if(dev == null){
            return Optional.empty();
        }
        return Optional.of(dev);
    }

    @Override
    public List<Developer> getDevelopersByCompetenceAndLevel(String nameCompetence,Level level) {
        Stream<Developer> stream = developers.stream();
        var findDevelopers = stream.filter(d-> d.getCompetenceList().listIterator().next().getName().equalsIgnoreCase(nameCompetence) && d.getCompetenceList().listIterator().next().getLevel().toString().equalsIgnoreCase(level.toString())) .toList();
            return findDevelopers;
         }

    @Override // DA SISTEMARE
    public List<Developer> getDevelopersByComepetence(String nameCompetence) {
       return developers.stream().filter(dev -> dev.getCompetenceList().stream()
                .anyMatch(c -> c.getName().contains(nameCompetence))).toList();
    }

    @Override
    public Developer create(Developer dev) {
        developers.add(dev);
        dev.setID(Id);
        Id++;
        return dev;
    }

    @Override
    public void deleteById(long id) {
        Stream<Developer> stream= developers.stream();
        Developer dev_remove = stream.filter(e -> e.getID() == id).findAny().get();
        developers.remove(dev_remove);
    }

    @Override
    public List<Developer> showDeveloper() {
        Stream<Developer> stream = developers.stream();
        List<Developer> list = stream.toList();
        return list;
    }

    @Override
    public Competence createCompetence(Competence competence) {
        competences.add(competence);
        competence.setID(Id);
        IdCompetence++;
        return competence;
    }

    @Override
    public List<Developer> showDeveloperByNumberOfCompetence(int numberCompetence) {
        Stream <Developer> stream = developers.stream();
        List<Developer> developerList = stream.filter(dev -> dev.getNumOfCompetence() == numberCompetence).toList();
        return  developerList;
    }
    @Override
    public Developer addNewCompetence(Competence competence,Developer developer) {
        developer.setNumOfCompetence(1);
        developer.setCompetenceList(competence);
        return developer;
    }

    @Override
    public List<Developer> getDevelopersByNumOfCompetenceAndLevels(int numOfCompetence,Level level) {
        Stream <Developer> stream = developers.stream();
        List<Developer> developerList = stream.filter(d-> d.getNumOfCompetence() == numOfCompetence &&
                d.getCompetenceList().stream().anyMatch(c-> c.getLevel().equals(level))).toList();
        return developerList;
    }

    public List<Competence> getCompetencebyLevel(Level level){
        Stream <Developer> stream = developers.stream();
        List<Competence> list = stream.flatMap(d->d.getCompetenceList().stream().filter(c-> c.getLevel().toString().equalsIgnoreCase(level.toString()))).toList();
        return list;
    }

    @Override
    public List<Level> getLevelbyCompetence(List<Competence> competenceList) {
        Stream <Competence> competenceStream = competenceList.stream();
        List<Level> levelList = competenceStream.map(d-> d.getLevel()).toList();
        return  levelList;
    }

    @Override
    public double getAverageSalary() {
        Stream <Developer> developerStream = developers.stream();
        var sum = developerStream.mapToDouble(d-> d.getSalary()).sum();
        return sum /= developers.size();
    }

    @Override
    public double getHighestSalary() {
        Stream <Developer> developerStream = developers.stream();
        double hight = developerStream.mapToDouble(d-> d.getSalary()).max().getAsDouble();
        return hight;
    }

    @Override
    public boolean isSexistOrNot() {
        Stream <Developer> developerStream = developers.stream();
        List<Developer> manDeveloper = developerStream.filter(d-> d.getSex().equalsIgnoreCase("M")).toList();
        if(manDeveloper.size() > (developers.size()-manDeveloper.size())){
            System.out.println("La tua azienda è assolutamente sessista!");
            return true;
        }else {
            return false;
        }
    }

}
