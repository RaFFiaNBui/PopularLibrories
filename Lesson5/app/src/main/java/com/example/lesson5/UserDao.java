package com.example.lesson5;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single<Long> addOneUser (User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single<List<Long>> addUsersList (List<User> users);

    @Delete
    Single<Integer> deleteUser (User user);

    @Update
    Single<Integer> updateUser (User user);

    @Query("SELECT * FROM users")
    Single<List<User>> getAll();
}
