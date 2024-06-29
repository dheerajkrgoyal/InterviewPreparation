package com.interview.designguru.lld.loggingsystem;

public class InfoLoggingProcessor extends LoggingProcessor{
    public InfoLoggingProcessor(LoggingProcessor nextLoggingProcessor, @SuppressWarnings("rawtypes") Class clazz) {
        super(nextLoggingProcessor, clazz);
    }

    @Override
    public void log(int loggingLevel, String msg){
        if(loggingLevel == LoggingProcessor.INFO){
            System.out.println("INFO: " + clazz.getName() + ":" + msg);
        }
        else{
            super.log(loggingLevel, msg);
        }
    }
}
