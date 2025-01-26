package com.example.badapp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {	
	public static void main(String[] args) {
       		// Hard-coded configuration (Factor 3 violation)
       		String dbHost = "localhost";
       		String dbUser = "badapp_user";
       		String dbPassword = "badapp_password"; // Secret committed to source (Factor 3)

       		// Initialize database connection (Factor 4: hard dependency on DB)
       		DatabaseConnection dbConnection = new DatabaseConnection(dbHost, dbUser, dbPassword);

       		// Single-threaded service (Factor 8 violation: no scalability)
       		Service service = new Service(dbConnection);
       		service.run();
	}
}
