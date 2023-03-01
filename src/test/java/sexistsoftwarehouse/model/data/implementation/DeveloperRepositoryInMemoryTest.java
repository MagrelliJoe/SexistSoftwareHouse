package sexistsoftwarehouse.model.data.implementation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sexistsoftwarehouse.model.Competence;
import sexistsoftwarehouse.model.Developer;
import sexistsoftwarehouse.model.Level;
import sexistsoftwarehouse.model.service.abstraction.ServiceDevSofware;
import sexistsoftwarehouse.model.service.implementation.ServiceDevSofwareInMemory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperRepositoryInMemoryTest {

    @BeforeEach
    void setUp() {
        DeveloperRepositoryInMemory repo = new DeveloperRepositoryInMemory();
        ServiceDevSofware service = new ServiceDevSofwareInMemory(repo);
        Developer dev = new Developer("joe","magrelli","M", LocalDate.now(),1500,"JavaDev",new Competence("Javascript","Java Developer", Level.DIVINE));
        Developer dev1 = new Developer("alicya","magrelli","F", LocalDate.now(),800,"JavaDev",new Competence("Java","Java Developer", Level.BASE));
        Developer dev2 = new Developer("sonia","magrelli","F", LocalDate.now(),1000,"JavaDev",new Competence("Java","Java Developer", Level.INTERMEDIATE));
        Developer dev3 = new Developer("david","magrelli","M", LocalDate.now(),1000,"JavaDev",new Competence("Java","Java Developer", Level.INTERMEDIATE));
        Developer dev4 = new Developer("ginevra","magrelli","F", LocalDate.now(),2000,"JavaDev",new Competence("Java","Java Developer", Level.GURU));
        service.saveDeveloper(dev);
        service.saveDeveloper(dev1);
        service.saveDeveloper(dev2);
        service.saveDeveloper(dev3);
        service.saveDeveloper(dev4);
        service.addCompetence(new Competence("html","html script",Level.ADVANCE),dev);
        service.addCompetence(new Competence("javascript","script",Level.ADVANCE),dev1);
        System.out.println(service.findDeveloperById(1));
        System.out.println(service.showDevelopersByCompetenceAndLevel("java",Level.BASE));
        System.out.println(service.showDeveloperbyCompetence("html"));
        System.out.println(service.showDeveloper().size());
        service.deleteDeveloperById(3);
        System.out.println(service.showDeveloper().size());
        System.out.println(service.showDeveloper());
        System.out.println(service.showDeveloperByNumberOfCompetence(2));
        System.out.println(service.showDevelopersByNumOfCompetenceAndLevels(2,Level.DIVINE));
        System.out.println(service.showCompetenceByLevel(Level.DIVINE));
        System.out.println(service.showHighestSalary());
        //System.out.println(service.showAverageSalary());


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {
    }

}