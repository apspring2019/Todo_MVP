package views;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import presenters.AddTaskPresenter;
import presenters.TaskDetailPresenter;
import presenters.TasksListPresenter;

/***
 * The main class which handles navigation between pages
 */
public class PageNavigator
{
    private static Deque<ConsolePage> pages = new LinkedList<>();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        pages.push(new MainMenuPage());
        ConsolePage currentPage = null;
        while (true)
        {
            if (currentPage != pages.peek())
            {
                currentPage = pages.peek();
                if (currentPage == null)
                    break;
                currentPage.start();
            }

            if (!scanner.hasNextLine())
                break;
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("back"))
                back();
            else
                currentPage.handleCommand(command);
        }
    }

    public static void back()
    {
        pages.pop();
    }

    public static void openAddTaskPage()
    {
        AddTaskPresenter presenter = new AddTaskPresenter();
        AddTaskView view = new AddTaskView(presenter);
        presenter.setView(view);
        pages.push(view);
    }

    public static void openTasksListPage()
    {
        TasksListPresenter presenter = new TasksListPresenter();
        TasksListView view = new TasksListView(presenter);
        presenter.setView(view);
        pages.push(view);
    }

    public static void openTaskDetailsPage(int taskId)
    {
        TaskDetailPresenter presenter = new TaskDetailPresenter();
        TaskDetailView view = new TaskDetailView(presenter, taskId);
        presenter.setView(view);
        pages.push(view);
    }
}
