package com.interview.designguru.lld.loggingsystem;

public abstract class LoggingProcessor {
    Class clazz;
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    private LoggingProcessor nextLoggingProcessor;

    public LoggingProcessor(LoggingProcessor nextLoggingProcessor, Class clazz){
        this.nextLoggingProcessor = nextLoggingProcessor;
        this.clazz = clazz;
    }

    public void log(int loggingLevel, String msg){
        if(nextLoggingProcessor != null){
            nextLoggingProcessor.log(loggingLevel, msg);
        }
    }

}
