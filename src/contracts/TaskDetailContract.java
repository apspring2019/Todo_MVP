package contracts;

public interface TaskDetailContract
{
    interface View
    {
        void setPresenter(Presenter presenter);

        void showTask(String title, String description, boolean checked);

        void showError(String message);

        void showTaskNotFound();

        void showTaskDeletedSuccessfully();
    }

    interface Presenter
    {
        void setView(View view);

        void loadTask(int taskId);

        void deleteTask();
    }
}
