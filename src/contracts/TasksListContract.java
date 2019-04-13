package contracts;

import java.util.List;

import models.Task;

public interface TasksListContract
{
    interface View
    {
        void setPresenter(Presenter presenter);

        void showTasks(List<Task> tasks);
        void showTaskDetailPage(int taskId);
    }

    interface Presenter
    {
        void setView(View view);

        void loadTasks();
        void toggleTaskCheck(int index);
        void openTask(int index);
    }
}
