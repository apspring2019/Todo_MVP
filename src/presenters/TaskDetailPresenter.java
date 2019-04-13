package presenters;

import contracts.TaskDetailContract;
import data.Database;
import models.Task;

public class TaskDetailPresenter implements TaskDetailContract.Presenter
{
    private TaskDetailContract.View view;
    private Task task;

    @Override
    public void setView(TaskDetailContract.View view)
    {
        this.view = view;
    }

    @Override
    public void loadTask(int taskId)
    {
        this.task = Database.getTaskDb().getTaskById(taskId);
        if (task == null)
            view.showTaskNotFound();
        else
            view.showTask(task.getTitle(), task.getDescription(), task.isChecked());
    }

    @Override
    public void deleteTask()
    {
        if (Database.getTaskDb().deleteTask(task.getId()))
            view.showTaskDeletedSuccessfully();
        else
            view.showError("Task could not be deleted.");
    }
}
