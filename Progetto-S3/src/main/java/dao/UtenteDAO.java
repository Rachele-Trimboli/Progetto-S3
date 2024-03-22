package dao;

import entities.Prestito;
import entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(utente);
            et.commit();
            System.out.println("E' stato effettuato un nuovo prestito da " + utente.getNome() + utente.getCognome());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
