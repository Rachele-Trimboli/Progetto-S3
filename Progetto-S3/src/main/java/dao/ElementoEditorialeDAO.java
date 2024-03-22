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

}
