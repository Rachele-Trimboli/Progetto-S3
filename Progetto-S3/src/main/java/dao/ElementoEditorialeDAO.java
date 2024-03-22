package dao;

import entities.ElementoEditoriale;
import entities.Libro;
import entities.Rivista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ElementoEditorialeDAO {

    private final EntityManager em;

    public ElementoEditorialeDAO(EntityManager em) {
        this.em = em;
    }

    public void save(ElementoEditoriale elemento) {
        try {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(elemento);
            et.commit();
            System.out.println("Elemento  " + elemento.getTitolo() + "  creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void findByIsbnAndDelete(long ISBN){
        try {
            EntityTransaction t = em.getTransaction();
            ElementoEditoriale found = em.find(ElementoEditoriale.class, ISBN);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Elemento eliminato");
            } else System.out.println("Elemento non trovato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ElementoEditoriale findByISBN(long ISBN){
        ElementoEditoriale elemento = em.find(ElementoEditoriale.class, ISBN);
        return elemento;
    }

    public List<ElementoEditoriale> findByYear(int year){
        TypedQuery<ElementoEditoriale> query = em.createQuery("SELECT e FROM ElementoEditoriale e WHERE e.annoPubblicazione = :year", ElementoEditoriale.class);
        query.setParameter("year",year);
        return query.getResultList();
    }

    public List<ElementoEditoriale> findByAutor(String autore){
        TypedQuery<ElementoEditoriale> query = em.createQuery("SELECT e FROM ElementoEditoriale e WHERE e.autore LIKE :autore",ElementoEditoriale.class);
        query.setParameter("autore",autore);
        return query.getResultList();
    }




}
