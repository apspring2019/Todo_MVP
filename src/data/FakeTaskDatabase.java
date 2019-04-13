package data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import models.Task;

/**
 * A fake runtime database which uses hashmap to store data
 */
public class FakeTaskDatabase implements TaskDatabase
{
    private LinkedHashMap<Integer, Task> tasks = new LinkedHashMap<>();

    @Override
    public int saveTask(Task task)
    {
        if (task.getTitle().isEmpty())
            return -1;
        if (task.getId() == 0)
        {
            int id = tasks.size() + 1;
            while (tasks.containsKey(id))
                id++;
            task.setId(id);
        }

        tasks.put(task.getId(), task);
        return 1;
    }

    @Override
    public List<Task> getTasks()
    {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public Task getTaskById(int id)
    {
        return tasks.get(id);
    }

    @Override
    public boolean deleteTask(int taskId)
    {
        return tasks.remove(taskId) != null;
    }
}
