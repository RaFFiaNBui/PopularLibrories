package com.example.lesson4.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Season {

    @Expose
    @SerializedName("time_of_year")
    public String time_of_year;

    @Expose
    @SerializedName("year")
    public String year;
}
