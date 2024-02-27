package com.interview.designguru.lld.loggingsystem;

public class DebugLoggingProcessor extends LoggingProcessor{
    public DebugLoggingProcessor(LoggingProcessor nextLoggingProcessor, Class clazz) {
        super(nextLoggingProcessor, clazz);
    }

    @Override
    public void log(int loggingLevel, String msg){
        if(loggingLevel == LoggingProcessor.DEBUG){
            System.out.println("DEBUG: "  + clazz.getName() + ":" + msg);
        }
        else{
            super.log(loggingLevel, msg);
        }
    }
}
