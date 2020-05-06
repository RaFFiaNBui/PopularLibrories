package com.example.lesson5;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

//package-private
class UserPresenter {

    private static final String TAG = "tag";

    private UserDao userDao;

    //package-private
    UserPresenter() {
        userDao = App.getAppDatabase().userDao();
    }

    //package-private
    void addOneUser() {
        User user = new User();
        user.name = "Anton";
        user.surname = "Smirnov";
        user.age = 88;
        Disposable disposable = userDao.addOneUser(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "addOneUser: " + id + ". " + Thread.currentThread().getName());
                }, throwable -> {
                    Log.e(TAG, "addOneUser: ", throwable);
                });
    }

    //package-private
    void addSomeUser() {
        User user1 = new User();
        user1.name = "Ivan";
        user1.surname = "Ivanov";
        user1.age = 18;
        User user2 = new User();
        user2.name = "Petr";
        user2.surname = "Petrov";
        user2.age = 25;
        List<User> usersList = new ArrayList<>();
        usersList.add(user1);
        usersList.add(user2);
        Disposable disposable = userDao.addUsersList(usersList).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> Log.d(TAG, "addSomeUser: " + id + ". " + Thread.currentThread().getName()),
                        throwable -> Log.e(TAG, "addSomeUser: ", throwable));
    }

    //package-private
    void deleteUser() {
        User user = new User();
        user.id = 2;
        Disposable disposable = userDao.deleteUser(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> Log.d(TAG, "deleteUser: " + id + ". " + Thread.currentThread().getName()),
                        throwable -> Log.e(TAG, "deleteUser: ", throwable));
    }

    //package-private
    void updateUser() {
        User user = new User();
        user.id = 1;
        user.name = "Alexandr";
        user.surname = "Larin";
        user.age = 58;
        Disposable disposable = userDao.updateUser(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> Log.d(TAG, "updateUser: " + id + ". " + Thread.currentThread().getName()),
                        throwable -> Log.e(TAG, "updateUser: ", throwable));
    }

    //package-private
    void getAllData() {
        Disposable disposable = userDao.getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> Log.d(TAG, "getAllData: " + users + " " + Thread.currentThread().getName()),
                        throwable -> Log.d(TAG, "getAllData: " + throwable));
    }
}
