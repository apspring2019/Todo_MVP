package views;

import contracts.AddTaskContract;

public class AddTaskView extends ConsolePage implements AddTaskContract.View
{
    private AddTaskContract.Presenter presenter;

    public AddTaskView(AddTaskContract.Presenter presenter)
    {
        this.presenter = presenter;
    }

    @Override
    public void setPresenter(AddTaskContract.Presenter presenter)
    {
        this.presenter = presenter;
    }

    public void start()
    {
        System.out.println("------New Task------");
        System.out.print("Title: ");
    }

    //Some fields used by handleCommand
    private String title;
    private String description;
    private int inputState = 0;

    @Override
    public void handleCommand(String command)
    {
        switch (inputState)
        {
            case 0:
                title = command;
                System.out.print("\nDescription: ");
                inputState = 1;
                break;
            case 1:
                description = command;
                presenter.saveTask(title, description);
                inputState = 0;
                break;
        }
    }

    //region Messages

    @Override
    public void showSavingError(String message)
    {
        System.err.println("There was a problem with saving:\n" + message);
        System.out.print("\nTitle: ");
    }

    @Override
    public void showTaskSavedSuccessfully()
    {
        System.out.println("Task saved successfully!");
        PageNavigator.back();
    }

    //endregion

}
