package data;

import java.util.List;

import models.Task;

public interface TaskDatabase
{
    int saveTask(Task task);

    List<Task> getTasks();
    Task getTaskById(int id);

    boolean deleteTask(int taskId);
}
