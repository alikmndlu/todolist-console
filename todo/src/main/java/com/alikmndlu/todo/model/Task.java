package com.alikmndlu.todo.model;

import com.alikmndlu.todo.base.model.BaseModel;
import com.alikmndlu.todo.model.enumeration.TaskStatus;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Comparator;

@Entity
@Table(name = "tasks")
public class Task extends BaseModel<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(name = "status", nullable = false)
    private TaskStatus taskStatus;

    @Column(name = "created_at", nullable = false)
    private Timestamp createTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static Comparator<Task> sortByCreateTimeDESC() {
        return new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return -(t1.getCreateTime().compareTo(t2.getCreateTime()));
            }
        };
    }

    public static Comparator<Task> sortByCreateTimeASC() {
        return new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.getCreateTime().compareTo(t2.getCreateTime());
            }
        };
    }

    public static Comparator<Task> sortByTitleDESC() {
        return new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return -(t1.getTitle().compareTo(t2.getTitle()));
            }
        };
    }

    public static Comparator<Task> sortByTitleASC() {
        return new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.getTitle().compareTo(t2.getTitle());
            }
        };
    }

    public static Comparator<Task> sortByStatusDESC() {
        return new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return -(t1.getTaskStatus().compareTo(t2.getTaskStatus()));
            }
        };
    }

    public static Comparator<Task> sortByStatusASC() {
        return new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.getTaskStatus().compareTo(t2.getTaskStatus());
            }
        };
    }

    @Override
    public String toString() {
        return "Task{" +
                "user=" + user +
                ", title='" + title + '\'' +
                ", taskStatus=" + taskStatus +
                ", createTime=" + createTime +
                '}';
    }
}
