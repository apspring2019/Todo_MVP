package views;

import java.util.List;

import contracts.TasksListContract;
import models.Task;

public class TasksListView extends ConsolePage implements TasksListContract.View
{
    private TasksListContract.Presenter presenter;

    public TasksListView(TasksListContract.Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void setPresenter(TasksListContract.Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void start()
    {
        System.out.println("-----Tasks-----");
        presenter.loadTasks();
    }

    @Override
    public void handleCommand(String command)
    {
        if (command.matches("c\\d+"))
            presenter.toggleTaskCheck(Integer.parseInt(command.substring(1)) - 1);
        else if (command.matches("\\d+"))
            presenter.openTask(Integer.parseInt(command) - 1);
        else
            System.out.println("Invalid input!");
    }

    @Override
    public void showTasks(List<Task> tasks)
    {
        for (int i = 0; i < tasks.size(); i++)
            System.out.printf("%d-\t[%s]%s%n", i + 1,
                    tasks.get(i).isChecked() ? "x" : " ",
                    tasks.get(i).getTitle());
    }

    @Override
    public void showTaskDetailPage(int taskId)
    {
        PageNavigator.openTaskDetailsPage(taskId);
    }
}
