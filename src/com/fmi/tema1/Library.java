package com.fmi.tema1;

import com.persons.tema1.Client;
import com.persons.tema1.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private String name;
    private String address;
    private Integer numberOfBooks;
    private ArrayList<Book> books;
    private ArrayList<Loan> loans;
    private ArrayList<Employee> employees;
    private ArrayList<Client> clients;

    public Library(){
        name = address = "";
        numberOfBooks = 0;
        books = new ArrayList<>();
        loans = new ArrayList<>();
        employees = new ArrayList<>();
        clients = new ArrayList<>();
    }

    public Library(String n, String ad){
        name = n;
        address = ad;
        numberOfBooks = 0;
        books = new ArrayList<>();
        loans = new ArrayList<>();
        employees = new ArrayList<>();
        clients = new ArrayList<>();
    }

    public Library(String name, String address, Integer numberOfBooks, ArrayList<Book> books, ArrayList<Loan> loans, ArrayList<Employee> employees, ArrayList<Client> clients) {
        this.name = name;
        this.address = address;
        this.numberOfBooks = numberOfBooks;
        this.books = books;
        this.loans = loans;
        this.employees = employees;
        this.clients = clients;
    }

    public void addBook(Book b) {
        books.add(b);
        numberOfBooks++;
    }

    public boolean findBook(Book b) {
        for ( int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle() == b.getTitle() && books.get(i).getAuthor() == b.getAuthor() )
                return true;
        }
        return false;
    }

    public boolean checkLoan(Loan l) {
        for ( int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle() == l.getBookTitle() && books.get(i).getAuthor() == l.getBookAuthor() )
                return true;
        }
        return false;
    }



    public void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Library name: ");
            name = reader.readLine();
            System.out.println("Library address : ");
            address = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Reading books");
        int read = 1;
        while (read == 1) {
            Book b = new Book();
            b.readData();
            addBook(b);
            System.out.println("Press 1 to add another book and 0 to exit");
            Scanner in = new Scanner(System.in);
            read = in.nextInt();
        }
        read = 1;
        System.out.println("Reading loans");
        while (read == 1) {
            Loan l = new Loan();
            l.readData();
            if(checkLoan(l)) {
                loans.add(l);
                if (!clients.contains(l.getClient())) clients.add(l.getClient());
            }
            else System.out.println("The book doesn't exist in our library");
            System.out.println("Press 1 to add another loan and 0 to exit");
            Scanner in = new Scanner(System.in);
            read = in.nextInt();

        }
        read = 1;
        System.out.println("Reading employees");
        while (read == 1) {
            Employee e = new Employee();
            e.readData();
            employees.add(e);
            System.out.println("Press 1 to add another employee and 0 to exit");
            Scanner in = new Scanner(System.in);
            read = in.nextInt();
        }
        read = 1;
        System.out.println("Reading clients");
        while (read == 1) {
            Client c = new Client();
            c.readData();
            clients.add(c);
            System.out.println("Press 1 to add another client and 0 to exit");
            Scanner in = new Scanner(System.in);
            read = in.nextInt();
        }
        System.out.println("Reading is over");
    }

    public void printBooks() {
        System.out.println("Our books are: ");
        for (int i = 0; i < books.size(); i++) {
            books.get(i).printData();
            System.out.println("");
        }
    }

    public void printLoans() {
        System.out.println("All of our loans are: ");
        for (int i = 0; i < loans.size(); i++){
            loans.get(i).printData();
            System.out.println("");
        }
    }

    public void printClients() {
        System.out.println("Our clients are: ");
        for (int i = 0; i < clients.size(); i++){
            clients.get(i).printData();
            System.out.println("");
        }
    }

    public void printEmployees() {
        System.out.println("Our employees are: ");
        for (int i = 0; i < employees.size(); i++){
            employees.get(i).printData();
            System.out.println("");
        }
    }

    public void printData() {
        System.out.println("Welcome to " + name + " Library");
        System.out.println("Address: " + address);
        printBooks();
        printLoans();
        printClients();
        printEmployees();
    }
}
