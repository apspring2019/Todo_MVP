package views;

import contracts.TaskDetailContract;

public class TaskDetailView extends ConsolePage implements TaskDetailContract.View
{
    private int taskId;
    private TaskDetailContract.Presenter presenter;

    public TaskDetailView(TaskDetailContract.Presenter presenter, int taskId)
    {
        this.taskId = taskId;
        this.presenter = presenter;
    }

    @Override
    public void setPresenter(TaskDetailContract.Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void start()
    {
        System.out.println("----------");
        presenter.loadTask(taskId);
    }

    @Override
    public void handleCommand(String command)
    {
        switch (command.toLowerCase())
        {
            case "delete":
                presenter.deleteTask();
                break;
        }
    }

    @Override
    public void showTask(String title, String description, boolean checked)
    {
        System.out.printf("Title: %s%n", title);
        System.out.printf("Description: %s %n", description);
        System.out.println(checked ? "Done" : "Undone");
    }

    //region Messages
    @Override
    public void showError(String message)
    {
        System.err.println(message);
    }

    @Override
    public void showTaskNotFound()
    {
        System.err.println("Task not found.");
        PageNavigator.back();
    }

    @Override
    public void showTaskDeletedSuccessfully()
    {
        System.out.println("Task deleted successfully.");
        PageNavigator.back();
    }
    //endregion

}
