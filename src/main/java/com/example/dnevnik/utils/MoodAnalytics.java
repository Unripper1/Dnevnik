package com.example.dnevnik.utils;

public class MoodAnalytics {
    double very_sad;
    double sad;
    double fine;
    double good;
    double very_good;

    public MoodAnalytics(double very_sad, double sad, double fine, double good, double very_good) {
        this.very_sad = very_sad;
        this.sad = sad;
        this.fine = fine;
        this.good = good;
        this.very_good = very_good;
    }

    @Override
    public String toString() {
        return "MoodAnalytics{" +
                "very_sad=" + very_sad +
                ", sad=" + sad +
                ", fine=" + fine +
                ", good=" + good +
                ", very_good=" + very_good +
                '}';
    }
}
