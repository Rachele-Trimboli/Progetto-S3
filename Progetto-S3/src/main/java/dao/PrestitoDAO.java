package dao;

import entities.ElementoEditoriale;
import entities.Prestito;
import entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PrestitoDAO {

    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(prestito);
            et.commit();
            System.out.println("E' stato effettuato un nuovo prestito da " + prestito.getUtente() + "  del " + prestito.getElementoprestato());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<ElementoEditoriale> inPrestitoDataLaTessera(int numeroTessera){
        TypedQuery<ElementoEditoriale> query = em.createQuery(
                "SELECT p.elementoprestato FROM Prestito p WHERE p.utente.numeroditessera = :numeroTessera",
                ElementoEditoriale.class);
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }
}
