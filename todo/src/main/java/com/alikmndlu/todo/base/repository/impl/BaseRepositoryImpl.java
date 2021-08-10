package com.alikmndlu.todo.base.repository.impl;

import com.alikmndlu.todo.base.model.BaseModel;
import com.alikmndlu.todo.base.repository.BaseRepository;

import javax.persistence.EntityManagerFactory;

public abstract class BaseRepositoryImpl<E extends BaseModel<ID>, ID extends Number> implements BaseRepository<E, ID> {

    protected final EntityManagerFactory entityManagerFactory;

    public BaseRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}