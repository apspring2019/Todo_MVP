package views;

public class MainMenuPage extends ConsolePage
{
    @Override
    public void start()
    {
        System.out.println("-----Main Menu-----");
        System.out.println("1. New Task");
        System.out.println("2. Tasks List");
        System.out.println("3. Exit");
    }

    @Override
    public void handleCommand(String command)
    {
        if (!command.matches("\\d+"))
        {
            System.out.println("Invalid input");
            return;
        }

        switch (Integer.parseInt(command))
        {
            case 1:
                PageNavigator.openAddTaskPage();
                break;
            case 2:
                PageNavigator.openTasksListPage();
                break;
            case 3:
                PageNavigator.back();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }
}
