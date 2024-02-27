package com.interview.designguru.lld.loggingsystem;

public class MainLoggerApp {
    private static LoggingProcessor LOG = LoggingFactory.getLogger(MainLoggerApp.class);

    public static void main(String[] args) {

        LOG.log(LoggingProcessor.ERROR, "This is error message");
        LOG.log(LoggingProcessor.DEBUG, "This is debug message");
        LOG.log(LoggingProcessor.INFO, "This is info message");
    }
}
