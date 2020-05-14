package com.example.lesson_6.dagger.app;

import android.app.Application;

import com.example.lesson_6.dagger.Green;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Green provideGreen() {
        return new Green();
    }
}
