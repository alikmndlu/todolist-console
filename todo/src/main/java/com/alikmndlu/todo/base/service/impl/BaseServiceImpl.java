package com.alikmndlu.todo.base.service.impl;

import com.alikmndlu.todo.base.model.BaseModel;
import com.alikmndlu.todo.base.repository.BaseRepository;
import com.alikmndlu.todo.base.service.BaseService;

import java.sql.SQLException;
import java.util.Set;

public abstract class BaseServiceImpl<E extends BaseModel<ID>, ID extends Number, R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public void save(E e) {
        repository.save(e);
    }

    @Override
    public void update(E e) {
        repository.update(e);
    }

    @Override
    public Set<E> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }
}