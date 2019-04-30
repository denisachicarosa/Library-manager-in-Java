package com.fmi.tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

public class Book  extends  ObjectLoaned implements Comparable<Book> {

    private String title;
    private String author;
    private PublishingHouse publisher;

    public Book(){
        super();
        publisher = new PublishingHouse();
    }

    public Book(String title, String author, Integer shelf, String pname, String pAddress, boolean available) {
        super(shelf, available);
        this.title = title;
        this.author = author;
        this.publisher = new PublishingHouse(pname, pAddress);

    }

    @Override
    public void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {

            super.readData();

            System.out.println("Title : ");
            title = reader.readLine();
            System.out.println("Author : ");
            author = reader.readLine();
            publisher.readData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printData(){
        super.printData();
        System.out.println("Title : " + title );
        System.out.println("Author : " + author);
        System.out.println("Publishing House");
        publisher.printData();
    }

    public Book( String title, String author, Integer shelf, PublishingHouse publisher, boolean available) {
        //this.ID = ID;

        super(shelf, available);
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
