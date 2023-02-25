package sexistsoftwarehouse.model;
//creare competenza, con un id, un nome, una descrizione,
// un livello(con 5 gradi: base, intermedio, avanzato, guru, divino)
public class Competence {
    private static long ID=0;
    private String name;
    private String description;
    private Level level;


    public Competence(String name,String description,Level level) {
        this.ID+=1;
        this.name=name;
        this.description=description;
        this.level=level;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
