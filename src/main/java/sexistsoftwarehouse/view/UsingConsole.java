package sexistsoftwarehouse.view;

import sexistsoftwarehouse.model.Competence;
import sexistsoftwarehouse.model.Developer;
import sexistsoftwarehouse.model.Level;
import sexistsoftwarehouse.model.service.abstraction.ServiceDevSofware;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class UsingConsole {
    private ServiceDevSofware service;
    Scanner scanner;

    public UsingConsole(ServiceDevSofware service){
        this.service=service;
        scanner = new Scanner(System.in);
    }
    public void showMainMenu(){
        pln("Premi s -> Visualizza tutti i developers");
        pln("Premi r -> Aggiungi un nuovo Developer");
        pln("Premi i -> Cerca un Developer per competenza e livello");
        pln("Premi c -> Cerca un Developer per numero di competenze");
        pln("Premi u -> Cerca una competenza per sapere se i tuoi Developer la conoscono");
        pln("Premi j -> Visualizza il costo medio dei salari dei tuoi Developers");
        pln("Premi k -> Visualizza valore massimo del salario dei tuoi Developers");
        pln("Premi q -> Esci");
    }
    public void showSecondMenu(){
        pln("Premi c->Aggiungi nuove competenze");
        pln("Premi c->Inserisci il numero di competenze");
    }
    private void pln(String s){
        System.out.println(s);
    }

    private void p(String s){
        System.out.print(s + ": ");
    }

    private String getLine(String s){
        pln(s + " ");
        String line = scanner.nextLine();
        return line;
    }

    private LocalDate getDate(String prompt){
        do{
            System.out.println(prompt + ": ");
            String answer = scanner.nextLine();
            try{
                return LocalDate.parse(answer);
            } catch (DateTimeParseException e){
                p("Formato inserito non valido");
            }
        }while(true);
    }

    private double getDouble(String s){
        pln(s+ " ");
        do{
            String answer = scanner.nextLine();
            try{
                return Double.parseDouble(answer);
            } catch (NumberFormatException e){
                p("Formato inserito non valido");
            }
        }while(true);
    }

    private int getInt(String s){
        pln(s+ " ");
        do{
            String answer = scanner.nextLine();
            try{
                return Integer.parseInt(answer);
            } catch (NumberFormatException e){
                p("Formato inserito non valido");
            }
        }while(true);

    }

    private Level setLevelCompetence(){
        do{
            System.out.println("Livelli di competenza disponibili:" + Level.BASE + "," + Level.ADVANCE + "," +
                    Level.DIVINE + "," + Level.GURU);
            String l = getLine("Inserisci il livello di competenza");
            switch(l){
                case "BASE" :
                    return Level.BASE;
                case "INTERMEDIATE":
                    return Level.INTERMEDIATE;
                case "GURU":
                    return Level.GURU;
                case "DIVINE" :
                    return  Level.DIVINE;
            }
        }while(true);
    }

    public List<Developer> showAllDevelopers() {
        List<Developer> devList = service.showDeveloper().stream().toList();
        return devList;
    }

    public Developer addNewDeveloper(){
       String name = getLine("Inserisci il nome");
       String lastname = getLine("Inserisci il cognome");
       String sex = getLine("Inserisci il sesso");
       LocalDate date = getDate("Inserisci la data di assunzione");
       double salary = getDouble("Inserisci il salario mensile");
       String grade = getLine("Inserisci il grado");
       Competence competence= setCompetence("Inserisci una competenza");
       Developer dev= service.saveDeveloper(new Developer(name,lastname,sex,date,salary,grade,competence));
       do {
           String question = getLine("Vuoi inserire altre competenze? S/N");
           if (question.equalsIgnoreCase("s")) {
               Competence competenceOther = setCompetence("Inserisci una competenza");
               service.addCompetence(competenceOther,dev);
               return dev;
           }
       }while(true);

    }

    private Competence setCompetence(String s) {
        try {
            pln(s + " ");
            do {
                String n = getLine("Inserisci il nome della competenza");
                String d = getLine("Inserisci una descrizione della competenza");
                Level level = setLevelCompetence();
                return service.Savecompetences(new Competence(n,d,level));
            }while (true);
        }catch (NumberFormatException e) {
            p("Formato inserito non valido");
            return null;
        }

    }
    public List<Developer> showDeveloperbyCompetenceandLevels(String s){
        String nameCompetence = getLine(s);
        Level level = setLevelCompetence();
        List<Developer> developers = service.findByComepetenceLevel(nameCompetence,level);
        if(developers != null) {
            return developers;
        }
        throw new IllegalArgumentException("Non ho trovato developers con queste competenze e livello");
    }

    public List<Developer> showDeveloperbyCompetence(String s){
        String nameCompetence = getLine(s);
        List<Developer> developers = service.findDeveloperbyCompetence(nameCompetence);
        if(developers != null) {
            return developers;
        }
        throw new IllegalArgumentException("Non ho trovato developers con questa competenza");
    }
     public List<Developer> showDeveloperByNumOfCompetence(String s){
        int numberRequisite = getInt(s);
        List<Developer> developers = service.showDeveloperByNumberOfCompetence(numberRequisite);
         if(developers != null) {
             return developers;
         }
         throw new IllegalArgumentException("Non ho trovato developers con questo numero di competenze");
     }

     public List<Developer> showDevelopersByNumOfCompetenceAndLevels(String s){
        int numberRequisite = getInt(s);
        Level levelRequisite = setLevelCompetence();
        return  service.showDevelopersByNumOfCompetenceAndLevels(numberRequisite,levelRequisite);
     }

     public List<String> showNameCompetencebyLevelDistincs(){
        Level levelRequiest = setLevelCompetence();
        return  service.showNameCompetencebyDevelopersDistinct(levelRequiest);
     }

     public List<Level> levelOfCompetenceRequiest(String s){
        String string = getLine(s);
        List<Developer> developerList = service.findDeveloperbyCompetence(string);
        if(developerList != null){
            pln("Tra i tuoi develpers ci sono conoscenze per la competenza richiesta");

           for(Developer d : developerList){
              return service.getLevelbyCompetence(d.getCompetenceList());
           }
        }else{
            pln("Competenza sconosciuta tra i tuoi Developers");
        }
        throw new IllegalArgumentException("Errore nel trovare i livelli di competenze");
     }
}
