package com.interview.designguru.lld.loggingsystem;

public class LoggingFactory {

    public static LoggingProcessor getLogger(@SuppressWarnings("rawtypes") Class clazz){
        ErrorLoggingProcessor errorLoggingProcessor = new ErrorLoggingProcessor(null, clazz);
        DebugLoggingProcessor debugLoggingProcessor = new DebugLoggingProcessor(errorLoggingProcessor, clazz);
        return new InfoLoggingProcessor(debugLoggingProcessor, clazz);
    }
}
