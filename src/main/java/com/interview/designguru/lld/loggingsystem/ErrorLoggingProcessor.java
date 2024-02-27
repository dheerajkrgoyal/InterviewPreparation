package com.interview.designguru.lld.loggingsystem;

public class ErrorLoggingProcessor extends LoggingProcessor{
    public ErrorLoggingProcessor(LoggingProcessor nextLoggingProcessor, Class clazz) {
        super(nextLoggingProcessor, clazz);
    }

    @Override
    public void log(int loggingLevel, String msg){
        if(loggingLevel == LoggingProcessor.ERROR){
            System.out.println("ERROR: " + clazz.getName() + ":" + msg);
        }
        else{
            super.log(loggingLevel, msg);
        }
    }
}
