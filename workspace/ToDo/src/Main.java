
import org.h2.tools.Server;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /* Track To-Do items.
    write a program that contatntly loops
    and provides an option to add, toggle, and list to to-do items.
     */
    public static void insertToDo(Connection conn, String text) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO todos VALUES (NULL, ?, FALSE);");
        stmt.setString(1, text);
        stmt.execute();
    }

    public static ArrayList<ToDoItem> selectToDos(Connection conn) throws SQLException {
        ArrayList<ToDoItem> items = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM todos");
        ResultSet results = stmt.executeQuery();
        while (results.next()) {
            int id = results.getInt("id");
            String text = results.getString("text")
            boolean isDone = results.getBoolean("is_Done");
            items.add(new ToDoItem(id, text, isDone));
        }
        return items;

    }

    public static void toggleToDo(Connection conn, int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "UPDATE todos SET is_done = NOT is_done WHERE id = ?");
        stmt.setInt(1, id);
        stmt.execute();

    }

    public static void main(String[] args) throws SQLException {
        Server.createWebServer().start();
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
        Statement stmt = conn.createStatement();
        Scanner scanner;
        stmt.execute("CREATE TABLE IF NOT EXISTS todos (id IDENTITY, text VARCHAR, is_Done BOOLEAN");

                //ArrayList<ToDoItem> items = new ArrayList<>(); // now store in Database
                 scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Create to-do item");
            System.out.println("2. Toggle to-do item");
            System.out.println("3. List to-do items");
            System.out.println("Enter a number");

            String option = scanner.nextLine();

            if (option.equals("1")) {
                System.out.println("Enter your to-do item:");
                String text = scanner.nextLine();

                //              ToDoItem item = //new ToDoItem(text, false);
                //              items.add(item);
                insertToDo(conn, text);
            } else if (option.equals("2")) {
                System.out.println("Enter the number of the item you want to toggle:");
                int itemNum = Integer.parseInt(scanner.nextLine());
//                ToDoItem item = items.get(itemNum - 1);
//                item.isDone = ! item.isDone;
                toggleToDo(conn, itemNum);
            } else if (option.equals("3"))
//                int i = 1;
//                ArrayList<ToDoItem> items = selectToDos(conn);
                for (ToDoItem item : items) {
                String checkbox = "[ ]";
                if (item.isDone) {
                    checkbox = "[x] ";
                }
                System.out.printf("FORMATED: %s %d. %s\n", checkbox, item.id, item.text);
 //               i++;

            }

        }
            else {
            System.out.println("Invalid option");

        }
    }
}
