package com.alikmndlu.todo.base.service;

import com.alikmndlu.todo.base.model.BaseModel;

import java.sql.SQLException;
import java.util.Set;

public interface BaseService<E extends BaseModel<ID>, ID extends Number> {

    void save(E e);

    void update(E e);

    Set<E> findAll();

    E findById(ID id);

    void deleteById(ID id);
}