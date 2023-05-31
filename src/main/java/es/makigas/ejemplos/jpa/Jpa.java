package es.makigas.ejemplos.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Jpa {

    private static EntityManagerFactory emf;
    
    private static EntityManager em;
    
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("aplicacion");
        em = emf.createEntityManager();
        
        em.createQuery("FROM Alumno", Alumno.class)
                .getResultStream()
                .forEach(System.out::println);
    }
    
}
