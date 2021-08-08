package com.alikmndlu.todo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateContext {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaUnit");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static final EntityTransaction entityTransaction = entityManager.getTransaction();

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static EntityTransaction getEntityTransaction() {
        return entityTransaction;
    }
}