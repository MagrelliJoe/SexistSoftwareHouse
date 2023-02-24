package sexistsoftwarehouse.model;

import java.time.LocalDate;
import java.util.List;

// creare una classe developer, con un id, un nome, un cognome, un sesso, anno di assunzione, uno stipendio,
// un grado(titolo di lavoro), una lista di competenze(altra classe)
public class Developer {
    private long ID;
    private String name;
    private String lastname;
    private char sex;
    private LocalDate assumption;
    private double salary;
    private String grade;
    private List<Competence> competenceList;

    public Developer(long ID,String name,String lastname,char sex,LocalDate assumption,
                     double salary,String grade,List<Competence> competences) {
        this.ID = ID;
        this.assumption=assumption;
        this.competenceList=competences;
        this.grade=grade;
        this.name=name;
        this.lastname=lastname;
        this.sex=sex;
        this.salary=salary;
    }

    public List<Competence> getCompetenceList() {
        return competenceList;
    }

    public void setCompetenceList(List<Competence> competenceList) {
        this.competenceList = competenceList;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getAssumption() {
        return assumption;
    }

    public void setAssumption(LocalDate assumption) {
        this.assumption = assumption;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
}
