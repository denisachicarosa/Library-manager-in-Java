package com.fmi.tema1;

import com.persons.tema1.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loan {
    private Client client;
    private Book book;
    private Date loanDate;
    private Date returnDate;

    public Loan(Client client, Book book, Date loanDate, Date returnDate) {
        this.client = client;
        this.book = book;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Loan() {
        client = new Client();
        book = new Book();
        loanDate = new Date();
        returnDate = new Date();
    }

    public void readData() {
        System.out.println("Client : ");
        client.readData();
        System.out.println("Book : ");
        book.readData();
        System.out.println("loanDate : ");
        loanDate.readData();
        System.out.println("returnDate : ");
        returnDate.readData();
    }

    public void printData() {
        System.out.println("The person who loaned the book is:");
        client.printData();
        System.out.println("Book:");
        book.printData();
        System.out.println("Loan Date:");
        loanDate.printData();
        System.out.println("Return Date:");
        returnDate.printData();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
