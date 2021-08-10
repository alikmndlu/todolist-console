package com.alikmndlu.todo.util;

import com.alikmndlu.todo.model.Task;
import com.alikmndlu.todo.model.User;
import com.alikmndlu.todo.model.enumeration.TaskStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DataInitializer {
    private final EntityManagerFactory entityManagerFactory;

    public DataInitializer(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void init(){
        initializeUser();
//        initializeTask();
    }

    private void initializeUser(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new User("ali", "kmndlu", "a", "a"));
        entityManager.persist(new User("morteza", "ahangari", "mortezaahangari", "Morteza@123"));
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    private void initializeTask() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Task task = new Task();

        task.setUser(ApplicationContext.getUserRepositoryImpl().findByUsername("a"));
        task.setTitle("my first title");
        task.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        task.setTaskStatus(TaskStatus.Open);

        entityManager.persist(task);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
