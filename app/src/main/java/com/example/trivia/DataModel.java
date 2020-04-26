package com.example.trivia;

public class DataModel {
    private String name;
    private String date;
    private String cricketer;
    private String flagColor;

    public DataModel(String name, String date, String cricketer, String flagColor) {
        this.name = name;
        this.date = date;
        this.cricketer = cricketer;
        this.flagColor = flagColor;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String  getCricketer() {
        return cricketer;
    }

    public String getFlagColor() {
        return flagColor;
    }
}
