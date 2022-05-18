package com.example.dnevnik.utils;

// вспомогателььный класс для аналитики по активностям
public class ActivityAnalytics {
    double hobby;
    double social;
    double sport;
    double study;
    double work;

    public ActivityAnalytics(double hobby, double social, double sport, double study, double work) {
        this.hobby = hobby;
        this.social = social;
        this.sport = sport;
        this.study = study;
        this.work = work;
    }

    @Override
    public String toString() {
        return "ActivityAnalytics{" +
                "hobby=" + hobby +
                ", social=" + social +
                ", sport=" + sport +
                ", study=" + study +
                ", work=" + work +
                '}';
    }
}
