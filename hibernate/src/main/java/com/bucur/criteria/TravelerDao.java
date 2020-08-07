package com.bucur.criteria;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TravelerDao {

    private Session session;
    private Transaction tx;

    public List<Traveler> findAll() {
        List<Traveler> result = null;
        try {
            startOperation();

            CriteriaQuery<Traveler> query = session.getCriteriaBuilder()
                .createQuery(Traveler.class);
            result = session.createQuery(
                query.select(query.from(Traveler.class))).list();

            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public Traveler findByEmail(String email) {
        Traveler result = null;
        try {
            startOperation();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Traveler> query = cb.createQuery(Traveler.class);
            Root<Traveler> root = query.from(Traveler.class);

            result = session.createQuery(
                query.select(root)
                    .where(cb.equal(root.get("email"), email))
            ).uniqueResult();

            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public List<Traveler> findByCountryCode(String countryCode) {
        List<Traveler> result = null;
        try {
            startOperation();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Traveler> query = cb.createQuery(Traveler.class);
            Root<Traveler> root = query.from(Traveler.class);

            result = session.createQuery(
                query.select(root)
                    .where(cb.equal(root.join("country").get("code"), countryCode))
            ).list();

            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    public List<Traveler> findByGenderAndCountry(Gender gender, String countryCode) {
        List<Traveler> result = null;
        try {
            startOperation();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Traveler> query = cb.createQuery(Traveler.class);
            Root<Traveler> root = query.from(Traveler.class);

            result = session.createQuery(
                query.select(root)
                    .where(
                        cb.and(
                            cb.equal(root.join("country").get("code"), countryCode),
                            cb.equal(root.get("gender"), gender)
                        )
                    )
            ).list();

            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    private void startOperation() throws HibernateException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }
}
