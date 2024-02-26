package com.interview.designguru.lld.solid.observerpattern;

public interface StockObservable {
    void add(NotificationObserver observer);
    void remove(NotificationObserver observer);

    void notifyObserver();

    public void setStock(int stock);

    public int getStock();
}
