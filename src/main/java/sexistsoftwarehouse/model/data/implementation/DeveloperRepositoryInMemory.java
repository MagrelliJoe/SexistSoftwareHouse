package sexistsoftwarehouse.model.data.implementation;

import sexistsoftwarehouse.model.Competence;
import sexistsoftwarehouse.model.Developer;
import sexistsoftwarehouse.model.Level;
import sexistsoftwarehouse.model.data.abstraction.DeveloperRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
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
    public List<Developer> findByComepetenceLevel(String nameCompetence,Level level) {
       /* List<Developer> findDevelopers= new ArrayList<>();

         for(Developer dev : developers){
             if(dev.getCompetenceList().contains(nameCompetence)){
                 findDevelopers.add(dev);
             }else{
                 throw new IllegalArgumentException("Nessun dipendente ha queste competenze");
             }
        */
        Stream<Developer> stream = developers.stream();
        List<Developer> findDevelopers =stream.filter(dev-> dev.getCompetenceList().contains(nameCompetence)
                && dev.getCompetenceByLevel().contains(level)).toList();
        if(findDevelopers!=null){
            return findDevelopers;
        }else{
            throw  new IllegalArgumentException("Non ho trovato nessun dipendente con queste competenze");
        }
         }

    @Override
    public List<Developer> findByComepetence(String nameCompetence) {
        Stream<Developer> stream = developers.stream();
        List<Developer> findDevelopers =stream.filter(dev-> dev.getCompetenceList().contains(nameCompetence)).toList();
        if(findDevelopers!=null){
            return findDevelopers;
        }else{
            throw  new IllegalArgumentException("Non ho trovato nessun dipendente con queste competenze");
        }
    }

    @Override
    public Developer create(Developer dev) {
        ++Id;
        developers.add(dev);
        dev.setID(Id);
        Id++;
        return dev;
    }

    @Override
    public void update(Developer d) {
       /* for (Developer dev: developers) {
            if (d.getID()== dev.getID()) {
                developers.remove(d);
                developers.add(dev);
            }else{
                throw new IllegalArgumentException("Non è presente un dipendente con questo ID");
            }
        }
        */
        Stream<Developer> stream = developers.stream();
        Developer dev = (Developer)stream.filter(dev1 -> dev1.getID()==d.getID());
        if(dev != null) {
            developers.remove(d);
            developers.add(dev);
        }else{
            throw new IllegalArgumentException("Non è presente un dipendente con questo ID");
        }
    }

    @Override
    public void deleteById(long id) {
        Stream<Developer> stream= developers.stream();
        Developer d_remove = (Developer)stream.filter(d -> d.getID()==id);
        if(d_remove != null) {
            developers.remove(d_remove);
        }else{
            throw new IllegalArgumentException("Non è presente un dipendente con questo ID");
        }
    }

    @Override
    public List<Developer> showDeveloper() {
        Stream<Developer> stream = developers.stream();
        List<Developer> list = stream.toList();
        return list;
    }

    @Override
    public Competence createCompetence(Competence competence) {
        ++IdCompetence;
        competences.add(competence);
        competence.setID(Id);
        IdCompetence++;
        return competence;
    }

    @Override
    public List<Developer> showDeveloperByNumberOfCompetence(int numberCompetence) {
        Stream <Developer> stream = developers.stream();
        try {
            List<Developer> developerList = stream.filter(dev -> dev.getNumOfCompetence() == numberCompetence).toList();
            return developerList;
        }catch(Exception e){
            throw new IllegalArgumentException("Nessun developer ha questo numero di competenze");
        }
    }

    @Override
    public Developer addNewCompetence(Competence competence,Developer developer) {
        developer.setNumOfCompetence(1);
        developer.setCompetenceList(competence);
        return developer;
    }

    @Override
    public List<Developer> showDevelopersByNumOfCompetenceAndLevels(int numOfCompetence,Level level) {
        Stream <Developer> stream = developers.stream();
        List<Developer> developerList = stream.filter(d-> d.getNumOfCompetence()== numOfCompetence && d.getCompetenceList().contains(level)).toList();
        if(developerList != null){
            return  developerList;
        }else{
            throw new IllegalArgumentException("Nessun dipendente ha questo numero di competenze e/o questo livello");
        }
    }

    public List<String> showNameCompetencebyDevelopersDistinct(Level level){
        Stream <Developer> stream = developers.stream();
        var developerList = stream.filter(d-> d.getCompetenceList().contains(level)).toList();
        Stream<Developer> developerStream = developerList.stream();
        var stringList = developerStream.map(d-> d.getCompetenceList().get(0).getName()).toList();
        if(stringList != null){
            return stringList;
        }else{
            throw new IllegalArgumentException("Non ho trovato nulla");
        }
    }

    @Override
    public List<Level> getLevelbyCompetence(List<Competence> competenceList) {
        Stream <Competence> competenceStream = competenceList.stream();
        List<Level> levelList = competenceStream.map(d-> d.getLevel()).toList();
        return  levelList;
    }

    @Override
    public double showAverageSalary() {
        Stream <Developer> developerStream = developers.stream();
        var sum = developerStream.mapToDouble(d-> d.getSalary()).sum();
        return sum /= developers.size();
    }

    @Override
    public Optional<Developer> showHighestSalary() {
        Stream <Developer> developerStream = developers.stream();
        Optional highestSalary = developerStream.max((d1,d2)-> (int)(d1.getSalary() - d2.getSalary()));
        return highestSalary;
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
