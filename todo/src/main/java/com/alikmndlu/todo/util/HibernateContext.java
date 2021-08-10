package com.alikmndlu.todo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateContext {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JpaUnit");

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
