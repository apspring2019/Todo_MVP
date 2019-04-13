package data;

public class Database
{
    private static TaskDatabase taskDb;

    public static TaskDatabase getTaskDb()
    {
        if (taskDb == null)
            taskDb = new FakeTaskDatabase();
        return taskDb;
    }
}
