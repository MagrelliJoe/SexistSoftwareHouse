package sexistsoftwarehouse.model.data.implementation;

import sexistsoftwarehouse.model.Competence;
import sexistsoftwarehouse.model.Developer;
import sexistsoftwarehouse.model.Level;
import sexistsoftwarehouse.model.data.abstraction.DeveloperRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    public List<Developer> findByComepetence(String nameCompetence,Level level) {
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


}
