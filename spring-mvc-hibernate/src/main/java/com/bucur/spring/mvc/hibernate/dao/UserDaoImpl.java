package com.bucur.spring.mvc.hibernate.dao;

import com.bucur.spring.mvc.hibernate.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public User findOne(final long id) {
        return entityManager.find(User.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return entityManager.createQuery("from " + User.class.getName()).getResultList();
    }

    public void create(final User entity) {
        entityManager.persist(entity);
    }

    public User update(final User entity) {
        return entityManager.merge(entity);
    }

    public void delete(final User entity) {
        entityManager.remove(entity);
    }

    public void deleteById(final long entityId) {
        final User entity = findOne(entityId);
        delete(entity);
    }
}
