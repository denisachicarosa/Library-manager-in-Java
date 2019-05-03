package com.Persons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

public class Client extends Person {
    private static final AtomicInteger count = new AtomicInteger(0);
    private Integer ID;
    private String contact;


    public Client(String[] values) {
        super(values[0], values[1], values[2],values[3]);
        ID = count.incrementAndGet();
        contact = values[4];
    }
    @Override
    public void readData() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            super.readData();
            System.out.println("contact : ");
            contact = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void printData() {
        System.out.println("ID :" + ID);
        super.printData();
        System.out.println("contact : " + contact);
    }

    public Client() {
        super();
        ID = count.incrementAndGet();
        contact = "";
    }

    public Client(Integer ID, String contact) {
        this.ID = ID;
        this.contact = contact;
    }

    public Client(String firstName, String lastName, String birthday, String adress, String contact) {
        super(firstName, lastName, birthday, adress);
        ID = count.incrementAndGet();
        this.contact = contact;
    }

    public Client(Integer id, String firstName, String lastName, String birthday, String adress, String contact) {
        super(firstName, lastName, birthday, adress);
        ID = id;
        this.contact = contact;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
