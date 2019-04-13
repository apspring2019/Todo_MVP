package presenters;

import java.util.List;

import contracts.TasksListContract;
import data.Database;
import models.Task;

public class TasksListPresenter implements TasksListContract.Presenter
{
    private TasksListContract.View view;
    private List<Task> tasksCache;

    @Override
    public void setView(TasksListContract.View view)
    {
        this.view = view;
    }

    @Override
    public void loadTasks()
    {
        this.tasksCache = Database.getTaskDb().getTasks();
        view.showTasks(tasksCache);
    }

    @Override
    public void toggleTaskCheck(int index)
    {
        Task task = tasksCache.get(index);
        task.setChecked(!task.isChecked());
        Database.getTaskDb().saveTask(task);
        loadTasks();
    }

    @Override
    public void openTask(int index)
    {
        view.showTaskDetailPage(tasksCache.get(index).getId());
    }
}
