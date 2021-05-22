package util;

import org.apache.logging.log4j.LogManager;

/**
 * Interface for logging the application.
 *
 */
public interface Logger {
    org.apache.logging.log4j.Logger rootLogger = LogManager.getRootLogger();

    /**
     * Logs the data
     */
    void logData(String data);
}
