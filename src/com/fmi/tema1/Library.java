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
    private ArrayList<Movie> movies;
    private ArrayList<Loan> loans;
    private ArrayList<Employee> employees;
    private ArrayList<Client> clients;
    static private Date today;

    public Library(){
        name = address = "";
        books = new ArrayList<>();
        loans = new ArrayList<>();
        employees = new ArrayList<>();
        clients = new ArrayList<>();
        movies = new ArrayList<>();
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
        books.add(new Book("1", "1", 1, "1", "1", true));


        movies.add(new Movie(6, true, "Orange is the new black", 1,1,2013, "crime", 8.1));
        movies.add(new Movie(6, true, "Green Mile", 3,6,1997, "drama", 8.6));
        movies.add(new Movie(2, true, "2", 2,2,2222, "2", 2.0));



        clients.add(new Client("Denisa","Chicarosa","22.11.1998","Braila, Romania","0728542934"));
        clients.add(new Client("Raluca", "Meianu", "15.09.1998", "Fieni, Romania", "raluca.meianu@gmail.com"));
        clients.add(new Client("Miruna", "Cojocaru", "27.11.1998", "Roman, Romania", "Mirunacojocaru@gmail.com"));


        loans.add(new Loan("Raluca", "Meianu", "15.09.1998", "Fieni, Romania", "raluca.meianu@gmail.com", 1, 3, 2019,"Mandrie si prejudecata","Jane Austen", 3, "Unicart", "Bucuresti, Romania", true ));
        loans.add(new Loan("Denisa", "Chicarosa", "22.11.1998", "Braila, Romania", "0728542934", 20, 3, 2019, "Strainul de langa mine","Irina Binder", 1, "Humanitas","Bucuresti, Romania", true));
        loans.add(new Loan("Miruna", "Cojocaru","27.11.1998", "Roman, Romania", "Mirunacojocaru@gmail.com", 30,5,2019, 6, true ,"Green Mile", 3, 6, 1997, "drama", 8.6));

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

    public void addMovie(Movie m) { movies.add(m);}

    public void addMovie() {
        Movie m = new Movie();
        m.readData();
        addMovie(m);
    }

    public boolean findBook(Book b) {
        for ( int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle() == b.getTitle() && books.get(i).getAuthor() == b.getAuthor() )
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

        System.out.println("Reading movies");
        read = 1;
        while (read == 1) {
            Movie b = new Movie();
            b.readData();
            addMovie(b);
            System.out.println("Press 1 to add another movie and 0 to exit");
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
            else System.out.println("The object doesn't exist in our library");
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

    public void printMovies() {
        System.out.println("Our movies are: ");
        for (int i = 0; i < movies.size(); i++) {
            movies.get(i).printData();
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
        printMovies();
        printLoans();
        printClients();
        printEmployees();
    }

    public void sortBooks() {
        Collections.sort(books, new Comparator() {
            public int compare(Object a, Object b) {
                //use instanceof to verify the references are indeed of the type in question
                return ((Book) a).getTitle().compareTo(((Book) b).getTitle());
            }
        });
    }



    public boolean check(String titlu, String autor) {
        for (int ind = 0; ind < books.size(); ind++)
            if (books.get(ind).getTitle().equals(titlu) && books.get(ind).getAuthor().equals(autor))
                return books.get(ind).isAvailable();
        return false;
    }

    public boolean checkAvailable(ObjectLoaned object) {
        if (object.getClass().getName() == "Book") {
            int idx = getBookIndex(object.getID());
            return books.get(idx).isAvailable();
        }
        else if (object.getClass().getName() == "Movie") {
            int idx = getMovieIndex(object.getID());
            return movies.get(idx).isAvailable();
        }
        return false;
    }



    public boolean checkLoan(Loan l) {
        System.out.println("check loan");
        if (l.getObject().getClass().getName() == "com.fmi.tema1.Book") {
            System.out.println("You want to add a book");
            for ( int i = 0; i < books.size(); i++) {
                if(books.get(i).getAuthor().equals(l.getObject().getAuthor()) && books.get(i).getTitle().equals(l.getObject().getTitle()))
                    return true;
            }
            return false;
        }
        else
        if (l.getObject().getClass().getName() == "com.fmi.tema1.Movie") {
            System.out.println("Testez filmele");
            for (int i = 0; i < movies.size(); i++) {
                if (movies.get(i).getTitle().equals(l.getObject().getTitle()) && movies.get(i).getGenre().equals(l.getObject().getGenre()))
                    return true;
            }

            return false;
        }
        System.out.println(l.getObject().getClass().getName());

        return false;
    }

    public void addLoan() {
        Loan l = new Loan();
        l.readData();
        if(checkLoan(l)) {
            System.out.println("passed");
            if (l.getObject().isAvailable()) {
                loans.add(l);
                System.out.println("Loan added");
                if (!clients.contains(l.getClient())) clients.add(l.getClient());
            }
            else System.out.println("The object is not available");
        }
        else  {
            System.out.println("The object doesn't exist in our library");
        }
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

    public int getBookIndex(int index) {
        for (int i = 0; i < books.size(); i++)
            if (books.get(i).getID() == index)
                return i;
        return -1;
    }

    public int getMovieIndex(int index) {
        for (int i = 0; i < movies.size(); i++)
            if (movies.get(i).getID() == index)
                return i;
        return -1;
    }

    public void updateObjects() {
        int idx;
//        for (int i = 0; i < loans.size(); i++) {
//            idx = getBookIndex(loans.get(i).getBookTitle(), loans.get(i).getBookAuthor());
//            if (idx == 0) loans.remove(i);
//            else books.get(i).setAvailable(false);
//        }

        for (int i = 0; i < loans.size(); i++) {
            if (loans.get(i).getObject().getClass().getName() == "Book") {

                if (!returnedObject(loans.get(i))) {
                    idx = getBookIndex(loans.get(i).getObject().getID());
                    books.get(idx).setAvailable(true);
                } else {
                    idx = getBookIndex(loans.get(i).getObject().getID());
                    books.get(idx).setAvailable(false);

                }
            }
            else if (loans.get(i).getObject().getClass().getName() == "Movie") {
                if (!returnedObject(loans.get(i))) {
                    idx = getMovieIndex(loans.get(i).getObject().getID());
                    movies.get(idx).setAvailable(true);

                } else {
                    idx = getMovieIndex(loans.get(i).getObject().getID());
                    movies.get(idx).setAvailable(false);
                }
            }
        }
    }

    public boolean returnedObject (Loan l) {
        if (l.getReturnDate().compareDate(today)) return true;
        else return false;
    }

    public void printEndedLoans(){
        for (int i = 0; i < loans.size(); i++) {
            if (returnedObject(loans.get(i))) {
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
