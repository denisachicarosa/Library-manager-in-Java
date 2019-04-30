package com.fmi.tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Movie extends ObjectLoaned{

    private String title;
    private Date release;
    private String genre;
    private Double rating;

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Movie(Integer shelf, boolean available, String title, Date release, String genre, Double rating) {
        super(shelf, available);
        this.title = title;
        this.release =new Date(release.getDay(), release.getMonth(), release.getYear());
        this.genre = genre;
        this.rating = rating;
    }

    public Movie(Integer shelf, boolean available, String title, Integer day, Integer month, Integer year, String genre, Double rating) {
        super(shelf, available);
        this.title = title;
        this.release = new Date(day, month, year);
        this.genre = genre;
        this.rating = rating;
    }

    public Movie() {
        super();
        release = new Date();
    }

    @Override
    public void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            super.readData();
            System.out.println("Title : ");
            title = reader.readLine();
            System.out.println("release date:");
            release.readData();
            System.out.println("Movie's genre:");
            genre = reader.readLine();
            System.out.println("Rating:");
            rating = Double.parseDouble(reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printData(){
        super.printData();
        System.out.println("Title : " + title );
        System.out.println("release date: ");
        release.printData();
        System.out.println("Genre: " + genre);
        System.out.println("Rating: "+ rating);
    }

    @Override
    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }
    @Override
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
