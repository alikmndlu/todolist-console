package com.alikmndlu.todo.repository.impl;

import com.alikmndlu.todo.base.repository.impl.BaseRepositoryImpl;
import com.alikmndlu.todo.model.User;
import com.alikmndlu.todo.repository.UserRepository;
import com.alikmndlu.todo.service.impl.Authenticate;
import com.alikmndlu.todo.util.ApplicationContext;
import com.alikmndlu.todo.util.HibernateContext;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long>
        implements UserRepository {

    public UserRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    public void save(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Set<User> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Set<User> users = new HashSet<>(
                entityManager.createQuery("from User", User.class).getResultList()
        );
        entityManager.getTransaction().commit();
        entityManager.close();
        return users;
    }

    @Override
    public User findById(Long userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("from User u where u.id = :id", User.class);
        query.setParameter("id", userId);

        User user = null;

        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException ignored) {}

        entityManager.close();
        return user;
    }

    @Override
    public void deleteById(Long userId) {

    }

    @Override
    public User findByUsername(String username) {
        EntityManager entityManager = HibernateContext.getEntityManagerFactory().createEntityManager();
        Query query = entityManager.createQuery(
                "from User u where u.username = :username",
                User.class
        );
        query.setParameter("username", username);

        User user;

        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException ignored) {
            user = null;
        } finally {
            entityManager.close();
        }

        return user;
    }

    @Override
    public void refreshUserData() {
        if (Authenticate.getUser() != null){
            Authenticate.setUser(
                    ApplicationContext.getUserServiceImpl().findById(
                            Authenticate.getUser().getId()
                    )
            );
        }
    }
}