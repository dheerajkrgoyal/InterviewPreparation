package com.interview.designguru.lld.solid.observerpattern;

public class MobileNotificationServer implements NotificationObserver{

    String mobile;
    StockObservable observable;

    public MobileNotificationServer(StockObservable observable, String mobile){
        this.mobile = mobile;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendSMS(this.mobile, "stock is back");
    }

    private void sendSMS(String mobile, String msg){
        System.out.println("sms sent to: " + mobile);
    }
}
