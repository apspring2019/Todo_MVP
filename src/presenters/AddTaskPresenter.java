package presenters;

import contracts.AddTaskContract;
import data.Database;
import data.TaskDatabase;
import models.Task;

public class AddTaskPresenter implements AddTaskContract.Presenter
{
    private AddTaskContract.View view;

    @Override
    public void setView(AddTaskContract.View view)
    {
        this.view = view;
    }

    @Override
    public void saveTask(String title, String description)
    {
        int result = Database.getTaskDb().saveTask(new Task(title, description));
        if (result == -1)
            view.showSavingError("Task title can't be empty.");
        else
            view.showTaskSavedSuccessfully();
    }
}
