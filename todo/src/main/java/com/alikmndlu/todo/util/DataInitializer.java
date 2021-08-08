package com.alikmndlu.todo.util;

import com.alikmndlu.todo.model.User;

import javax.persistence.EntityManager;

public class DataInitializer {
    private final EntityManager entityManager;

    public DataInitializer(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void init(){
        entityManager.getTransaction().begin();
        initializeUser();
        entityManager.getTransaction().commit();
    }

    private void initializeUser(){
        entityManager.persist(new User("ali", "kmndlu", "a", "a"));
        entityManager.persist(new User("morteza", "ahangari", "mortezaahangari", "Morteza@123"));
    }
}
