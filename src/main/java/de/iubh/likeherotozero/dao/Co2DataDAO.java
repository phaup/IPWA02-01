package de.iubh.likeherotozero.dao;

import de.iubh.likeherotozero.model.Co2Data;
import de.iubh.likeherotozero.model.Country;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class Co2DataDAO {

    @PersistenceContext(unitName = "likeHeroToZeroPU")
    private EntityManager em;

    public Co2Data findLatestByCountry(Country country) {
        TypedQuery<Co2Data> query = em.createQuery(
            "SELECT d FROM Co2Data d WHERE d.country = :country ORDER BY d.dataYear DESC", Co2Data.class);
        query.setParameter("country", country);
        query.setMaxResults(1); 
        
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; 
        }
    }

    @Transactional
    public void save(Co2Data data) {
        em.persist(data);
    }
}