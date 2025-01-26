package com.example.badapp;

public class Service {
    private DatabaseConnection dbConnection;

    public Service(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void run() {
        Logger logger = Logger.getInstance();
        logger.log("Service started on port " + Config.SERVICE_PORT);

        // Directly tied to specific logic (Factor 7: no abstraction for scaling)
        for (int i = 0; i < 5; i++) {
            try {
                dbConnection.query("SELECT * FROM users WHERE id = " + i);
                logger.log("Processed request for user " + i);
            } catch (IllegalStateException e) {
                logger.log("Error: " + e.getMessage());
            }
        }

        logger.log("Service shutting down...");
    }
}
