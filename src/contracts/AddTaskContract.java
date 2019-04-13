package contracts;

public interface AddTaskContract
{
    interface View
    {
        void setPresenter(Presenter presenter);

        void showSavingError(String message);
        void showTaskSavedSuccessfully();
    }

    interface Presenter
    {
        void setView(View view);
        void saveTask(String title, String description);
    }
}
