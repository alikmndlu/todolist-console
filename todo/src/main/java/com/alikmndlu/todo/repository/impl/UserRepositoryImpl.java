package com.alikmndlu.todo.repository.impl;

import com.alikmndlu.todo.base.repository.impl.BaseRepositoryImpl;
import com.alikmndlu.todo.model.User;
import com.alikmndlu.todo.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long>
        implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public Set<User> findAll() {
        entityManager.getTransaction().begin();
        Set<User> users = new HashSet<>(
                entityManager.createQuery("from User", User.class).getResultList()
        );
        entityManager.getTransaction().commit();
        return users;
    }

    @Override
    public User findById(Long userId) {
        Query query = entityManager.createQuery("from User u where u.id = :id", User.class);
        query.setParameter("id", userId);
        return (User) query.getSingleResult();
    }

    @Override
    public void deleteById(Long userId) {

    }

    @Override
    public User findByUsername(String username) {
        Query query = entityManager.createQuery("from User u where u.username = :username and is_delete = 0", User.class);
        query.setParameter("username", username);
        try {
            return (User) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}