package edu.matc.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*import edu.matc.entity.Order;*/
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

/**
 * A generic DAO somewhat inspired by http://rodrigouchoa.wordpress.com
 *
 */
public class GenericDao<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Instantiates a new Generic dao.
     *
     * @param type the entity type, for example, User.
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets all entities
     *
     * @return the all entities
     */
    public List<T> getAll() {
        Session session = getSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createSelectionQuery(query).getResultList();
        session.close();
        return list;

    }

    /**
     * Gets an entity by id
     * @param id entity id to search by
     * @return entity
     */
    public <T> T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity entity to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.remove(entity);
        transaction.commit();
        session.close();
    }


    /**
     * Inserts the entity.
     *
     * @param entity entity to be inserted
     */
    public int insert(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        // TODO we are using a deprecated method here, is there a better way?
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Inserts or updates the entity.
     *
     * @param entity entity to be inserted/saved
     */
    public void update(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(entity);
        transaction.commit();
        session.close();
    }


    /**
     * Finds entities by one of its properties.
     * sample usage: findByPropertyEqual("lastname", "Curry")
     * @param propertyName the property name.
     * @param value the value by which to find.
     * @return the list of all entities found matching the criteria
     */
    public List<T> getByPropertyEqual(String propertyName, Object value) {
        Session session = getSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName),value));
        List<T> items = session.createSelectionQuery( query ).getResultList();
        session.close();
        return items;
    }

    public List<T> getByPropertiesEqual(Map<String, Object> criteria) {
        Session session = getSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);

        // Create a list to store predicates
        List<Predicate> predicates = new ArrayList<>();

        // Iterate through the criteria map and build predicates for each property-value pair
        for (Map.Entry<String, Object> entry : criteria.entrySet()) {
            String propertyName = entry.getKey();
            Object value = entry.getValue();

            // Add a predicate for each property equal to its value
            predicates.add(builder.equal(root.get(propertyName), value));
        }

        // Combine all the predicates using an AND clause
        query.select(root).where(builder.and(predicates.toArray(new Predicate[0])));

        List<T> items = session.createQuery(query).getResultList();
        session.close();
        return items;
    }

    /**
     * Gets by property like (%)
     * @param propertyName the property name
     * @param value the value being searched for
     * @return
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

//        logger.debug("Searching for user with {} = {}",  propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> items = session.createQuery( query ).getResultList();
        session.close();
        return items;
    }


    /**
     * Returns an open session from the SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }

}