import org.h2.tools.Server;

import java.sql.*;

/*
DROP TABLE players;
CREATE TABLE IF NOT EXISTS players (name VARCHAR, is_alive BOOLEAN, score INT, health DOUBLE);
INSERT INTO players VALUES ('Bob', true, 0, 100.0);
SELECT * FROM players WHERE name = 'Bob';
UPDATE players SET is_alive = FALSE WHERE name = 'Bob';
DELETE FROM players WHERE name = 'Bob';
 */


public class Main {
    public static void main(String[] args) throws SQLException{
        Server.createWebServer().start(); //THIS STARTS THE DATABASE

        Connection conn = DriverManager.getConnection("jdbc:h2:./main"); //THIS IS HOW TO CONNECT WITH DATABASE

        Statement stmt = conn.createStatement(); //THIS IS HOW TO CREATE A STATEMENT
        stmt.execute("CREATE TABLE IF NOT EXISTS players (id IDENTITY, name VARCHAR, is_alive BOOLEAN, score INT, health DOUBLE);");

        PreparedStatement stmt2 =  conn.prepareStatement(
                "INSERT INTO players VALUES (NULL, ?, ?, ?, ?, ?)");
        stmt2.setString(1, "David");
        stmt2.setBoolean(2, true);
        stmt2.setInt(3, 0);
        stmt2.setDouble(4, 100.0);
        stmt2.execute();

        PreparedStatement stmt3 = conn.prepareStatement(
                "SELECT * FROM players;");
                ResultSet results = stmt3.executeQuery();
                while ((results.next())) {
                    String playerName = results.getString("name");
                    double health = results.getDouble("health");
                    int score = results.getInt("score");
                    System.out.printf("%s, %s, %s\n", playerName, health, score);
                }

    }
}
