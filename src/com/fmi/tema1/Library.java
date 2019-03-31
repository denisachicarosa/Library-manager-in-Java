package com.fmi.tema1;

import com.persons.tema1.Client;
import com.persons.tema1.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class Library {
    private String name;
    private String address;
    private ArrayList<Book> books;
    private ArrayList<Loan> loans;
    private ArrayList<Employee> employees;
    private ArrayList<Client> clients;
    static public Date today;

    public Library(){
        name = address = "";
        books = new ArrayList<>();
        loans = new ArrayList<>();
        employees = new ArrayList<>();
        clients = new ArrayList<>();
        today = new Date();
        today.day = 29;
        today.month = 3;
        today.year = 2019;
        addThings();
    }

    public void addThings() {
        name = "Carturesti";
        address = "Centrul Vechi, Bucuresti";
        books.add(new Book("Strainul de langa mine", "Irina Binder", 1, "Humanitas", "Bucuresti, Romania", true));
        books.add(new Book("Idiotul", "Dostoievski", 2, "Polirom", "Bucuresti, Romania", true));
        books.add(new Book("Mandrie si prejudecata", "Jane Austen", 3, "Unicart", "Bucuresti, Romania", true));

        clients.add(new Client("Denisa","Chicarosa","22.11.1998","Braila, Romania","0728542934"));
        clients.add(new Client("Raluca", "Meianu", "15.09.1998", "Fieni, Romania", "raluca.meianu@gmail.com"));
        clients.add(new Client("Miruna", "Cojocaru", "27.11.1998", "Roman, Romania", "Mirunacojocaru@gmail.com"));


        loans.add(new Loan("Raluca", "Meianu", "15.09.1998", "Fieni, Romania", "raluca.meianu@gmail.com", "Mandrie si prejudecata","Jane Austen", 1, 3, 2019));
        loans.add(new Loan("Denisa", "Chicarosa", "22.11.1998", "Braila, Romania", "0728542934", "Strainul de langa mine","Irina Binder", 20, 3, 2019));


        //loans.add(new Loan("Miruna", "Cojocaru", "27.11.1998", "Roman, Romania", "Mirunacojocaru@gmail.com", "Mandrie si prejudecata","Jane Austen", 1, 3, 2019));
        employees.add(new Employee("Andreea","Ene","28.12.1998","Ploiesti, Romania","CEO",200.0));
        employees.add(new Employee("Ovidiu","Grozea","1.7.1968","Sighisoara, Romania","secretar",1500.5));
        employees.add(new Employee("Radu","Mocanu","17.12.1978","Urziceni, Romania","Hr Director",3000.0));


    }

    public Library(String n, String ad){
        name = n;
        address = ad;
        books = new ArrayList<>();
        loans = new ArrayList<>();
        employees = new ArrayList<>();
        clients = new ArrayList<>();
    }

    public Library(String name, String address, ArrayList<Book> books, ArrayList<Loan> loans, ArrayList<Employee> employees, ArrayList<Client> clients) {
        this.name = name;
        this.address = address;
        this.books = books;
        this.loans = loans;
        this.employees = employees;
        this.clients = clients;
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public void addBook() {
        Book b = new Book();
        b.readData();
        books.add(b);
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
            if (books.get(i).getTitle().equals(l.getBookTitle()) && books.get(i).getAuthor().equals(l.getBookAuthor()) )
                return true;
        }
        return false;
    }



    public void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
//            System.out.println("Enter today's date: ");
//            today.readData();
            today.day = 29;
            today.month = 3;
            today.year = 2019;
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

    public void sortBooks() {
        Collections.sort(books, new Comparator() {
            public int compare(Object a, Object b) {
                //use instanceof to verify the references are indeed of the type in question
                return ((Book) a).getTitle()
                        .compareTo(((Book) b).getTitle());
            }
        });
    }

    public boolean checkAvailable(String title, String author) {
        int idx = getBookIndex(title, author);
        return books.get(idx).isAvailable();
    }

    public void addLoan() {
        Loan l = new Loan();
        l.readData();
        if(checkLoan(l)) {
            if (checkAvailable(l.getBookTitle(),l.getBookAuthor())) {
                loans.add(l);
                if (!clients.contains(l.getClient())) clients.add(l.getClient());
            }
            else System.out.println("The book is not available");
        }
        else System.out.println("The book doesn't exist in our library");
    }

    public void addClient(){
        Client c = new Client();
        c.readData();
        clients.add(c);
    }
    public void addEmployee() {
        Employee e = new Employee();
        e.readData();
        employees.add(e);
    }
    public boolean findBook(String title, String author) {
        for ( int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title) && books.get(i).getAuthor().equals(author) )
                return true;
        }
        return false;
    }

    public int getBookIndex(String title, String author) {
        for (int i = 0; i < books.size(); i++)
            if (books.get(i).getTitle().equals(title) && books.get(i).getAuthor().equals(author))
                return i;
        return -1;
    }

    public void updateBooks() {
        int idx;
//        for (int i = 0; i < loans.size(); i++) {
//            idx = getBookIndex(loans.get(i).getBookTitle(), loans.get(i).getBookAuthor());
//            if (idx == 0) loans.remove(i);
//            else books.get(i).setAvailable(false);
//        }
        for (int i = 0; i < loans.size(); i++) {
            if (!returnedBook(loans.get(i))) {
                idx = getBookIndex(loans.get(i).getBookTitle(),loans.get(i).getBookAuthor());
                books.get(idx).setAvailable(true);
                System.out.println("The "+idx+ " book is now available");
            }
            else {
                idx = getBookIndex(loans.get(i).getBookTitle(),loans.get(i).getBookAuthor());
                books.get(idx).setAvailable(false);
                //System.out.println("The "+idx+ " book is now available");
            }
        }
    }

    public boolean returnedBook (Loan l) {
        if (l.getReturnDate().compareDate(today)) return true;
        else return false;
    }

    public void printEndedLoans(){
        for (int i = 0; i < loans.size(); i++) {
            if (returnedBook(loans.get(i))) {
                loans.get(i).getClient().printData();
            }
        }
    }

    public int nrEmployees() {
        return employees.size();
    }

    public double getMaxSalary() {
        double max = employees.get(0).getSalary();
        for (int i = 1; i < employees.size(); i++)
            if (employees.get(i).getSalary() > max) max = employees.get(i).getSalary();
        return max;
    }
}
