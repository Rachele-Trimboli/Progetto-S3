package dao;

import entities.ElementoEditoriale;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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

    public void findByIsbn(long ISBN){
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

}
