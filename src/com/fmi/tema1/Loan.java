package com.fmi.tema1;

import com.persons.tema1.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loan {
    private Client client;
    private String bookTitle;
    private String bookAuthor;
    //private Book book;
    private Date loanDate;
    private Date returnDate;

    public Loan(Client client, Book book, String bookTitle, String bookAuthor, Date loanDate, Date returnDate) {
        this.client = client;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        //this.book = book;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    private void setReturnDate() {
        returnDate = (Date) loanDate.addDays(14);
    }

    public Loan() {
        client = new Client();
        //book = new Book();
        loanDate = new Date();
        returnDate = new Date();
    }

    public void readData() {
        System.out.println("Client : ");
        client.readData();
        System.out.println("Book title: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            bookTitle = reader.readLine();
            System.out.println("Author : ");
            bookAuthor = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //book.readData();
        System.out.println("loanDate : ");
        loanDate.readData();
        setReturnDate();
    }

    public void printData() {
        System.out.println("The person who loaned the book is:");
        client.printData();
        System.out.println("Book title: ");
        System.out.println(bookTitle);
        System.out.println("Author:");
        System.out.println(bookAuthor);
        //System.out.println("Book:");
        //book.printData();
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

//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }

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

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
