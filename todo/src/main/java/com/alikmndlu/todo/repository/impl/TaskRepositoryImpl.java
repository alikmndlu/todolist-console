package com.alikmndlu.todo.repository.impl;

import com.alikmndlu.todo.base.repository.impl.BaseRepositoryImpl;
import com.alikmndlu.todo.model.Task;
import com.alikmndlu.todo.repository.TaskRepository;
import com.alikmndlu.todo.util.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Set;

public class TaskRepositoryImpl extends BaseRepositoryImpl<Task, Long>
        implements TaskRepository {

    public TaskRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    @Override
    public void save(Task task) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(Task task) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        ApplicationContext.getUserRepositoryImpl().refreshUserData();
    }

    @Override
    public Set<Task> findAll() {
        return null;
    }

    @Override
    public Task findById(Long taskId) {
        return null;
    }

    @Override
    public void deleteById(Long taskId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery("delete from Task where id = :id")
                .setParameter("id", taskId)
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
        ApplicationContext.getUserRepositoryImpl().refreshUserData();
    }
}