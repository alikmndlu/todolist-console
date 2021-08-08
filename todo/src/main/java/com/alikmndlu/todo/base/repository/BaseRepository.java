package com.alikmndlu.todo.base.repository;

import com.alikmndlu.todo.base.model.BaseModel;

import java.sql.SQLException;
import java.util.Set;

public interface BaseRepository<E extends BaseModel<ID>, ID extends Number> {

    void save(E e);

    void update(E e);

    Set<E> findAll();

    E findById(ID id);

    void deleteById(ID id);
}