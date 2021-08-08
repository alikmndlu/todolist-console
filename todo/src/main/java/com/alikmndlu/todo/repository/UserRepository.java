package com.alikmndlu.todo.repository;

import com.alikmndlu.todo.base.repository.BaseRepository;
import com.alikmndlu.todo.model.User;

public interface UserRepository extends BaseRepository<User, Long>{
    User findByUsername(String username);
}