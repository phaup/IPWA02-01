package de.iubh.likeherotozero.dao;

import de.iubh.likeherotozero.model.Scientist;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@ApplicationScoped
public class ScientistDAO {

    @PersistenceContext(unitName = "likeHeroToZeroPU")
    private EntityManager em;

    public Scientist findByUsername(String username) {
        TypedQuery<Scientist> query = em.createQuery(
            "SELECT s FROM Scientist s WHERE s.username = :username", Scientist.class);
        query.setParameter("username", username);
        
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Kein Benutzer gefunden
        }
    }
}