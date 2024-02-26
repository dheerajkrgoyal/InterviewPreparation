package com.interview.designguru.lld.solid.observerpattern;

public class Store {

    public static void main(String[] args) {
        StockObservable stockObservable = new IphoneStockObservable();

        NotificationObserver emailObserver = new EmailNotificationObserver(stockObservable, "sffasf@fdsf.com");
        NotificationObserver mobileObserver = new MobileNotificationServer(stockObservable, "1323432");

        stockObservable.add(emailObserver);
        stockObservable.add(mobileObserver);

        stockObservable.setStock(5);

    }
}
