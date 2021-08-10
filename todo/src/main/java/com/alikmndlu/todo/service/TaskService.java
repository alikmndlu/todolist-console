package com.alikmndlu.todo.service;

import com.alikmndlu.todo.base.service.BaseService;
import com.alikmndlu.todo.model.Task;

public interface TaskService extends BaseService<Task, Long> {
    void addTask();
    void showTasks();
    void removeTask();
    void updateTask();
}