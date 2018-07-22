package com.prac.analytics;

public class Player {

    private Integer id;
    private String name;
    private String date;
    private String batsmenType;
    private String bowlingType;
    private String countryName;


    public Player(
            Integer id, String name, String date, String batsmenType, String bowlingType, String countryName) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.batsmenType = batsmenType;
        this.bowlingType = bowlingType;
        this.countryName = countryName;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getBatsmenType() {
        return batsmenType;
    }

    public String getBowlingType() {
        return bowlingType;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", batsmenType='" + batsmenType + '\'' +
                ", bowlingType='" + bowlingType + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
