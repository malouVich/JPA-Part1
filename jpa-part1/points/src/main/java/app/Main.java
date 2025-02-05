package app;

import app.config.HibernateConfig;
import app.entities.Course;
import app.entities.Person;
import app.entities.Point;

import app.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

//        // Store 1000 Point objects in the database:
//        em.getTransaction().begin();
//        for (int i = 0; i < 1000; i++) {
//            Point p = new Point(i, i);
//            em.persist(p);
//        }
//        em.getTransaction().commit();

        em.getTransaction().begin();
        Person person = new Person("Kim",65);
        Student student = new Student("Peter", 24,45185819, "peter@peterpan.dk", "Fenmarksgade 38", true, "15.11.2000", "28.08.2019");
        Student student1 = new Student("Emma", 22, 42789654, "emma@mail.com", "Nørrebrogade 12", false, "03.05.2002", "15.08.2021");
        Student student2 = new Student("Lucas", 25, 51237890, "lucas@email.dk", "Århusvej 45", true, "12.07.1999", "01.09.2018");
        Student student3 = new Student("Freja", 23, 60984521, "freja@gmail.com", "Vesterbrogade 98", false, "25.09.2001", "10.08.2020");
        Student student4 = new Student("Mikkel", 26, 71829384, "mikkel@stud.dk", "Østerbrogade 5", true, "30.11.1998", "20.08.2017");
        Student student5 = new Student("Sofie", 21, 50398475, "sofie@hotmail.com", "Amagerbrogade 88", false, "14.02.2003", "12.08.2022");
        Student student6 = new Student("Andreas", 24, 62387412, "andreas@mail.com", "Jægersborggade 34", true, "17.06.2000", "05.09.2019");
        Student student7 = new Student("Ida", 22, 49876123, "ida@live.dk", "Frederiksberg Allé 76", false, "08.04.2002", "27.08.2021");
        Student student8 = new Student("Jonas", 27, 56378945, "jonas@outlook.com", "Roskildevej 55", true, "21.10.1997", "30.08.2016");
        Student student9 = new Student("Laura", 23, 63427891, "laura@stud.mail", "Hovedgaden 23", false, "06.12.2001", "22.08.2020");
        Course course = new Course("Diskret matematik", "4. semester", 3.4, 120);
        em.persist(person);
        em.persist(student);
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(student4);
        em.persist(student5);
        em.persist(student6);
        em.persist(student7);
        em.persist(student8);
        em.persist(student9);
        em.persist(course);
        em.getTransaction().commit();

        // Find the number of Point objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        System.out.println("Total Points: " + q1.getSingleResult());

        // Find the average X value:
        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        System.out.println("Average X: " + q2.getSingleResult());

        // Retrieve all the Point objects from the database:
        TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = query.getResultList();
        for (Point p : results) {
            System.out.println(p);
        }
        //I stedet for at bruge for loopet, kunne man skrive =
        //result.steams().forEach(System.out::println);

        // Close the database connection:
        em.close();
        emf.close();
    }
}
