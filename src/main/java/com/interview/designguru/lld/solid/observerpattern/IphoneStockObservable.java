package com.interview.designguru.lld.solid.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservable implements StockObservable{
    List<NotificationObserver> observers = new ArrayList<>();
    int stock;
    @Override
    public void add(NotificationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(NotificationObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(NotificationObserver observer: observers){
            observer.update();
        }
    }

    @Override
    public void setStock(int stock) {
        if(this.stock == 0){
            notifyObserver();
        }
        this.stock = stock;
    }

    @Override
    public int getStock() {
        return this.stock;
    }
}
