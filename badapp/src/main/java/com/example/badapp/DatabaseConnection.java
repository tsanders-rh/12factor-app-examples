package com.example.badapp;

import java.util.Random;

public class DatabaseConnection {
    private String host;
    private String user;
    private String password;

    // Single, stateful connection (Factor 4 violation)
    public DatabaseConnection(String host, String user, String password) {
        this.host = host;
        this.user = user;
        this.password = password;
    }

    public boolean isConnected() {
        // Simulate flaky connection (Factor 8 violation: single point of failure)
        return new Random().nextBoolean();
    }

    public void query(String sql) {
        if (!isConnected()) {
            throw new IllegalStateException("Database connection lost!");
        }
        System.out.println("Executing query: " + sql);
    }
}
