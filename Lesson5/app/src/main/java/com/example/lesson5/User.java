package com.example.lesson5;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String surname;
    public int age;

    @NonNull
    @Override
    public String toString() {
        return "id: " + id +
                ", name: " + name +
                ", surname: " + surname +
                ", age: " + age + System.lineSeparator();
    }
}
