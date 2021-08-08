package com.alikmndlu.todo.base.repository.impl;

import com.alikmndlu.todo.base.model.BaseModel;
import com.alikmndlu.todo.base.repository.BaseRepository;

import javax.persistence.EntityManager;

public abstract class BaseRepositoryImpl<E extends BaseModel<ID>, ID extends Number> implements BaseRepository<E, ID> {

    protected final EntityManager entityManager;

    protected BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}