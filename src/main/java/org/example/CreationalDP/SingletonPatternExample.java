package org.example.CreationalDP;

class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // Private constructor to prevent instantiation
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }
}

// Main class to test the pattern
public class SingletonPatternExample {
    public static void main(String[] args) {
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        connection1.connect();

        DatabaseConnection connection2 = DatabaseConnection.getInstance();
        connection2.connect();

        System.out.println(connection1 == connection2);  // Should print true
    }
}
