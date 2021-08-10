package com.alikmndlu.todo.service.impl;

import com.alikmndlu.todo.base.service.impl.BaseServiceImpl;
import com.alikmndlu.todo.model.Task;
import com.alikmndlu.todo.model.enumeration.TaskStatus;
import com.alikmndlu.todo.repository.TaskRepository;
import com.alikmndlu.todo.service.TaskService;
import com.alikmndlu.todo.util.ApplicationContext;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TaskServiceImpl extends BaseServiceImpl<Task, Long, TaskRepository>
        implements TaskService {

    public TaskServiceImpl(TaskRepository repository) {
        super(repository);
    }

    @Override
    public void addTask() {
        System.out.println("\nEnter title : ");
        String title = ApplicationContext.getScanner().nextLine();

        Task task = new Task();

        task.setUser(Authenticate.getUser());
        task.setTitle(title);
        task.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        task.setTaskStatus(TaskStatus.Open);

        save(task);

        System.out.println("\nTask Added Successfully.");

        ApplicationContext.getUserRepositoryImpl().refreshUserData();
    }

    @Override
    public void showTasks() {
        Set<Task> taskSet = Authenticate.getUser().getTasks();
        List<Task> taskList = new ArrayList<>(taskSet);

        if (taskList.isEmpty()) {
            System.out.println("\nThere is no task!");
            return;
        }

        boolean quit = false;
        while (!quit) {
            ApplicationContext.getMenu().printDashboardOrderingOption();
            int action = ApplicationContext.getHelper().readInteger("-> ");

            switch (action) {
                case 1 -> {
                    taskList.sort(Task.sortByCreateTimeDESC());
                    quit = true;
                }
                case 2 -> {
                    taskList.sort(Task.sortByCreateTimeASC());
                    quit = true;
                }
                case 3 -> {
                    taskList.sort(Task.sortByTitleDESC());
                    quit = true;
                }
                case 4 -> {
                    taskList.sort(Task.sortByTitleASC());
                    quit = true;
                }
                case 5 -> {
                    taskList.sort(Task.sortByStatusDESC());
                    quit = true;
                }
                case 6 -> {
                    taskList.sort(Task.sortByStatusASC());
                    quit = true;
                }
                case 7 -> quit = true;
                default -> System.out.println("unknown command!");
            }
        }

        System.out.println();
        int i = 1;
        for (Task task : taskList) {
            System.out.println(i + ".  " + task.getTitle());
            System.out.println("\tStatus : " + task.getTaskStatus().name());
            System.out.println("\tCreate Time : " + task.getCreateTime().toLocalDateTime().format(
                    DateTimeFormatter.ofLocalizedDateTime(
                            FormatStyle.MEDIUM
                    )
            ) + "\n\n");
            i++;
        }
    }

    @Override
    public void removeTask() {
        Set<Task> taskSet = Authenticate.getUser().getTasks();
        List<Task> taskList = new ArrayList<>(taskSet);
        taskList.sort(Task.sortByCreateTimeASC());

        if (taskList.size() == 0) {
            System.out.println("\nThere is no task!");
            return;
        }

        System.out.println();
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i).getTitle() + " ( " + taskList.get(i).getTaskStatus().name() + " ) ");
        }

        int taskIndex;
        System.out.println("\nenter -1 for quit.");
        while (true) {
            System.out.println("Enter index : ");
            taskIndex = ApplicationContext.getHelper().readInteger("-> ");

            if (taskIndex == -1) {
                System.out.println("\nredirect To Dashboard...");
                return;
            }

            if (taskIndex <= 0 || taskIndex > taskList.size()) {
                System.out.println("invalid index!");
                continue;
            }

            break;
        }

        deleteById(taskList.get(taskIndex - 1).getId());
        System.out.println("\nTask Deleted Successfully.");
    }

    @Override
    public void updateTask() {
        Set<Task> taskSet = Authenticate.getUser().getTasks();
        List<Task> taskList = new ArrayList<>(taskSet);
        taskList.sort(Task.sortByCreateTimeASC());

        if (taskList.size() == 0) {
            System.out.println("\nThere is no task!");
            return;
        }

        System.out.println();
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i).getTitle() + " ( " + taskList.get(i).getTaskStatus().name() + " ) ");
        }

        int taskIndex;
        System.out.println("\nenter -1 for quit.");
        while (true) {
            System.out.println("Enter index : ");
            taskIndex = ApplicationContext.getHelper().readInteger("-> ");

            if (taskIndex == -1) {
                System.out.println("\nredirect To Dashboard...");
                return;
            }

            if (taskIndex <= 0 || taskIndex > taskList.size()) {
                System.out.println("invalid index!");
                continue;
            }

            break;
        }

        Task task = taskList.get(taskIndex - 1);

        boolean quit = false;
        while (!quit) {
            ApplicationContext.getMenu().printUpdateTaskOption();
            int action = ApplicationContext.getHelper().readInteger("-> ");

            switch (action) {
                case 1 -> {
                    updateTaskTitle(task);
                    quit = true;
                }
                case 2 -> {
                    updateTaskStatus(task);
                    quit = true;
                }
                case 3 -> quit = true;
                default -> System.out.println("unknown command!");
            }

        }
        System.out.println("\nredirect To Dashboard...");
    }

    private void updateTaskTitle(Task task) {
        System.out.println("\nCurrent Title : " + task.getTitle());
        System.out.println("Enter New Title :");
        String newTitle = ApplicationContext.getScanner().nextLine();

        task.setTitle(newTitle);
        update(task);

        System.out.println("Task Title Update Successfully.");
    }

    private void updateTaskStatus(Task task) {
        System.out.println("\nCurrent Status : " + task.getTaskStatus().name());

        for (TaskStatus taskStatus : TaskStatus.values()) {
            System.out.println((taskStatus.ordinal() + 1) + ". " + taskStatus.name());
        }

        int taskStatusIndex;
        System.out.println();
        System.out.println("\nenter -1 for quit.");
        while (true) {
            System.out.println("Enter task status index : ");
            taskStatusIndex = ApplicationContext.getHelper().readInteger("-> ");

            if (taskStatusIndex == -1) {
                System.out.println("\nredirect To Dashboard...");
                return;
            }

            if (taskStatusIndex <= 0 || taskStatusIndex > TaskStatus.values().length) {
                System.out.println("invalid index!");
                continue;
            }

            break;
        }

        task.setTaskStatus(TaskStatus.values()[taskStatusIndex - 1]);
        update(task);

        System.out.println("Task Title Update Successfully.");
    }
}