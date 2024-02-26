package com.interview.designguru.lld.solid.observerpattern;

public class EmailNotificationObserver implements NotificationObserver{

    String emailId;
    StockObservable observable;
    public EmailNotificationObserver(StockObservable observable, String emailId){
        this.emailId = emailId;
        this.observable = observable;
    }
    @Override
    public void update() {
        sendMail(emailId, "product is in stock");
    }

    private void sendMail(String emailId, String msg){
        System.out.println("main sent to: " + emailId);
    }
}
