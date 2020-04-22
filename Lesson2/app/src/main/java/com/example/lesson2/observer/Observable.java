package com.example.lesson2.observer;

public interface Observable {
    void subscribeObserver(Observer observer);
    void unsubscribeObserver(Observer observer);
    void notifyAllObservers();
}
