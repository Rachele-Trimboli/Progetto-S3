package org.example;

import dao.ElementoEditorialeDAO;
import entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        ElementoEditorialeDAO edao = new ElementoEditorialeDAO(em);

        Libro libro1 = new Libro(19,"Una notte d'estate", 2004,150,"Peppino","Commedia");
        edao.save(libro1);

        em.close();
        emf.close();


        System.out.println("Hello World!");
    }
}
