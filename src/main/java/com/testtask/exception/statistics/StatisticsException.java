package com.testtask.exception.statistics;

public class StatisticsException extends RuntimeException {
    public StatisticsException(String message) {
        super(message);
    }

    public StatisticsException(String message, Throwable cause) {
        super(message, cause);
    }
}
