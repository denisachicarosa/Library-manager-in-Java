package com.persons.tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

public class Client extends Person {
    private static final AtomicInteger count = new AtomicInteger(0);
    private Integer ID;
    private String contact;

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
        ID = count.incrementAndGet();
        contact = "";
    }
    public Client(Integer ID, String contact) {
        this.ID = ID;
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
