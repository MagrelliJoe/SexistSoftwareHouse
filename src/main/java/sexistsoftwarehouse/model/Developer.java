package sexistsoftwarehouse.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// creare una classe developer, con un id, un nome, un cognome, un sesso, anno di assunzione, uno stipendio,
// un grado(titolo di lavoro), una lista di competenze(altra classe)
public class Developer {
    private long ID;
    private String name;
    private String lastname;
    private String sex;
    private LocalDate assumption;
    private double salary;
    private String grade;
    private List<Competence> competenceList;
    private int numOfCompetence=0;

    public Developer(String name,String lastname,String sex,LocalDate assumption,
                     double salary,String grade,Competence competence) {
        this.assumption=assumption;
        this.competenceList.add(competence);
        this.grade=grade;
        this.name=name;
        this.lastname=lastname;
        this.sex=sex;
        this.salary=salary;
        this.numOfCompetence++;

    }

    public int getNumOfCompetence() {
        return numOfCompetence;
    }

    public void setNumOfCompetence(int numOfCompetence) {
        this.numOfCompetence += numOfCompetence;
    }

    public List<Level> getCompetenceByLevel() {
        List<Level> levelList = new ArrayList<>();
        for (Competence c : competenceList) {
            levelList.add(c.getLevel());
        }
        if (levelList != null) {
            return levelList;
        }
        throw new IllegalArgumentException("Non ho trovato cometenze di questo livello");
    }


    public List<Competence> getCompetenceList() {
        return competenceList;
    }

    public void setCompetenceList(Competence competence) {
        this.competenceList.add(competence);
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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

    @Override
    public String toString() {
        return
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", sex=" + sex +
                ", assumption=" + assumption +
                ", salary=" + salary +
                ", grade='" + grade + '\'' +
                ", competenceList=" + competenceList;
    }
}
