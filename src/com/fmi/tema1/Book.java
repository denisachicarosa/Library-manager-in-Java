package com.fmi.tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

public class Book implements Comparable<Book> {
    private static final AtomicInteger count = new AtomicInteger(0);
    private Integer ID;
    private String Title;
    private String Author;
    private Integer shelf;
    private PublishingHouse publisher;
    private boolean available;

    public Book(){
        available = true;
        ID = count.incrementAndGet();
        shelf = 0;
        publisher = new PublishingHouse();
    }

    public Book(String title, String author, Integer shelf, String pname, String pAddress, boolean available) {
        ID = count.incrementAndGet();
        Title = title;
        Author = author;
        this.shelf = shelf;
        this.publisher = new PublishingHouse(pname, pAddress);
        this.available = available;
    }

    public void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Title : ");
            Title = reader.readLine();
            System.out.println("Author : ");
            Author = reader.readLine();
            publisher.readData();
            System.out.println("shelf : ");
            shelf = reader.read()-'0';
            available = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printData(){
        System.out.println("ID : " + ID);
        System.out.println("Title : " + Title );
        System.out.println("Author : " + Author);
        System.out.println("Publishing House");
        publisher.printData();
        System.out.println("shelf : " + shelf);
        System.out.println("available : " + available);
    }
    public Book( String title, String author, Integer shelf, PublishingHouse publisher, boolean available) {
        //this.ID = ID;
        ID = count.incrementAndGet();
        Title = title;
        Author = author;
        this.shelf = shelf;
        this.publisher = publisher;
        this.available = available;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Integer getShelf() {
        return shelf;
    }

    public void setShelf(Integer shelf) {
        this.shelf = shelf;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public PublishingHouse getPublisher() {
        return publisher;
    }

    public void setPublisher(PublishingHouse publisher) {
        this.publisher = publisher;
    }

    public int compareTo(Book a) {
        return this.getTitle().compareTo(a.getTitle());
    }
}
