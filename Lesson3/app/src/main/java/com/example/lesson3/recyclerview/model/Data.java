package com.example.lesson3.recyclerview.model;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<String> list;

    public Data() {
        list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
    }

    public List<String> getList() {
        return list;
    }
}
