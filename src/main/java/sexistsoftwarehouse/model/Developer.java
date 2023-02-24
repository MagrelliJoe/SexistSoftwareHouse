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


}
