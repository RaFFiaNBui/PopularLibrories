package com.example.lesson_6.dagger.app;

import com.example.lesson_6.dagger.DaggerActivity;
import com.example.lesson_6.dagger.Red;
import com.example.lesson_6.dagger.White;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(DaggerActivity daggerActivity);
    void inject(Red red);
    void inject(White white);
}
