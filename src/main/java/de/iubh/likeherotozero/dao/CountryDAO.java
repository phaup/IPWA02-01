package de.iubh.likeherotozero.dao;

import de.iubh.likeherotozero.model.Country;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class CountryDAO {

    @PersistenceContext(unitName = "likeHeroToZeroPU")
    private EntityManager em;

    public List<Country> findAll() {
        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c ORDER BY c.name", Country.class);
        return query.getResultList();
    }
    
    public Country find(Long id) {
        return em.find(Country.class, id);
    }
}