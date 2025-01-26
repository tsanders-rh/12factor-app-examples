package com.example.badapp;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private FileWriter writer;

    // Singleton logger (Factor 5 violation: log to files, not stdout)
    private Logger() {
        try {
            writer = new FileWriter(Config.LOG_FILE_PATH, true);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize logger", e);
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        try {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Could not write log", e);
        }
    }
}
