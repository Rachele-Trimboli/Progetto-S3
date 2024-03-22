package org.example;

import dao.ElementoEditorialeDAO;
import dao.PrestitoDAO;
import dao.UtenteDAO;
import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;


public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogobibliografico");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        ElementoEditorialeDAO edao = new ElementoEditorialeDAO(em);
        UtenteDAO udao = new UtenteDAO(em);
        PrestitoDAO pdao = new PrestitoDAO(em);


        //CREAZIONE LIBRI E RIVISTE

        Libro libro1 = new Libro("Una notte d'estate", 2004,150,"Peppino","Commedia");
        Libro libro2 = new Libro("Harry Potter", 2004,150,"JKR","Fantasy");
        Libro libro3 = new Libro("I doni della morte", 2000,350,"JKR", "Fantasy");

        Rivista r1=new Rivista("Cosmopolita",2012,10, Periodicità.SETTIMANALE);
        Rivista r2=new Rivista("Today",2000,15, Periodicità.MENSILE);
        Rivista r3=new Rivista("Moda",2020,13, Periodicità.SEMESTRALE);

        //AGGIUNGI ELEMENTI AL CATALOGO

//        edao.save(libro1);
//        edao.save(libro2);
//        edao.save(libro3);
//        edao.save(r1);
//        edao.save(r2);
//        edao.save(r3);

        //REGISTRA UN NUOVO PRESTITO
        Utente utente1 = new Utente("Mario", "Bros",1980,123456);
        udao.save(utente1);

        Prestito prestito1 = new Prestito(utente1,libro1, LocalDate.of(2024,3,10),LocalDate.of(2024,3,22));
        pdao.save(prestito1);


        //TROVA ELEMENTI NEL CATALOGO ED ELIMINALI PER ISBN

        edao.findByIsbnAndDelete(1);

        //RICERCA PER ISBN

        System.out.println(edao.findByISBN(154));

        //RICERCA PER ANNO

        System.out.println(edao.findByYear(2000));

        //RICERCA PER AUTORE

        System.out.println(edao.findByAutor("JKR"));

        //RICERCA PER TITOLO O PARTE DI ESSO
        System.out.println(edao.findByTitle("doni"));

        //RICERCA ELEMENTI ATTUALMENTE IN PRESTITO DATO UN NUMERO DI TESSERA UTENTI
        System.out.println(pdao.inPrestitoDataLaTessera(123456));

        //RICERCA DI TUTTI I PRESTITI SCADUTI E NON ANCORA RESTITUITI
        System.out.println(pdao.prestitiScaduti(LocalDate.now()));



        em.close();
        emf.close();


        System.out.println("Hello World!");
    }
}
