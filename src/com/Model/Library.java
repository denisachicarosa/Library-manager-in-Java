package com.Model;

import com.Persons.Client;
import com.Persons.Employee;
import com.Services.InputFiles;

import java.io.*;
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
    private InputFiles inputFiles;

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
        //addThings();
    }

    public void addThings() {
//        name = "Carturesti";
//        address = "Centrul Vechi, Bucuresti";
//        books.add(new Book("Strainul de langa mine", "Irina Binder", 1, "Humanitas", "Bucuresti, Romania", true));
//        books.add(new Book("Idiotul", "Dostoievski", 2, "Polirom", "Bucuresti, Romania", true));
//        books.add(new Book("Mandrie si prejudecata", "Jane Austen", 3, "Unicart", "Bucuresti, Romania", true));
//        books.add(new Book("1", "1", 1, "1", "1", true));
        readData();

//        movies.add(new Movie(6, true, "Orange is the new black", 1,1,2013, "crime", 8.1));
//        movies.add(new Movie(6, true, "Green Mile", 3,6,1997, "drama", 8.6));
//        movies.add(new Movie(2, true, "2", 2,2,2222, "2", 2.0));
//


//        clients.add(new Client("Denisa","Chicarosa","22.11.1998","Braila, Romania","0728542934"));
//        clients.add(new Client("Raluca", "Meianu", "15.09.1998", "Fieni, Romania", "raluca.meianu@gmail.com"));
//        clients.add(new Client("Miruna", "Cojocaru", "27.11.1998", "Roman, Romania", "Mirunacojocaru@gmail.com"));


//        loans.add(new Loan("Raluca", "Meianu", "15.09.1998", "Fieni, Romania", "raluca.meianu@gmail.com", 1, 3, 2019,"Mandrie si prejudecata","Jane Austen", 3, "Unicart", "Bucuresti, Romania", true ));
//        loans.add(new Loan("Denisa", "Chicarosa", "22.11.1998", "Braila, Romania", "0728542934", 20, 3, 2019, "Strainul de langa mine","Irina Binder", 1, "Humanitas","Bucuresti, Romania", true));
//        loans.add(new Loan("Miruna", "Cojocaru","27.11.1998", "Roman, Romania", "Mirunacojocaru@gmail.com", 30,5,2019, 6, true ,"Green Mile", 3, 6, 1997, "drama", 8.6));

        //loans.add(new Loan("Miruna", "Cojocaru", "27.11.1998", "Roman, Romania", "Mirunacojocaru@gmail.com", "Mandrie si prejudecata","Jane Austen", 1, 3, 2019));
//        employees.add(new Employee("Andreea","Ene","28.12.1998","Ploiesti, Romania","CEO",200.0));
//        employees.add(new Employee("Ovidiu","Grozea","1.7.1968","Sighisoara, Romania","secretar",1500.5));
//        employees.add(new Employee("Radu","Mocanu","17.12.1978","Urziceni, Romania","Hr Director",3000.0));
//

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
        b.addToFile(inputFiles.getBookFile());
        books.add(b);

    }

    public void addMovie(Movie m) { movies.add(m);}

    public void addMovie() {
        Movie m = new Movie();
        m.readData();
        m.addToFile(inputFiles.getMovieFile());
        movies.add(m);
    }

    public boolean findBook(Book b) {
        for ( int i = 0; i < books.size(); i++) {
            if (books.get(i).egal(b))
                return true;
        }
        return false;
    }




    public void readData() {
        String fileName = "library.csv";
        File log = new File(fileName);
        try {
            today.day = 3;
            today.month = 4;
            today.year = 2019;
            Scanner inputStream = new Scanner(log);
            inputStream.nextLine();
            while(inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] values = data.split(",");
                this.name = values[0];
                this.address = values[1];
                String booksFile = values[2];
                String moviesFile = values[3];
                String clientsFile = values[4];
                String loansBook = values[5];
                String loansMovie = values[6];
                String employeesFile = values[7];
                inputFiles = new InputFiles(booksFile,moviesFile,loansMovie,loansBook,clientsFile,employeesFile,fileName);
                System.out.println(booksFile);
                readBooksFromFile(booksFile);
                readMoviesFromFile(moviesFile);
                readClientsFromFile(clientsFile);
                readLoansFromFile(loansBook,loansMovie);
                readEmployeesFromFile(employeesFile);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
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
        if (object.getClass().getName() == "com.Model.Book") {
            int idx = getBookIndex(object.getID());
            return books.get(idx).isAvailable();
        }
        else if (object.getClass().getName() == "com.Model.Movie") {
            int idx = getMovieIndex(object.getID());
            return movies.get(idx).isAvailable();
        }
        return false;
    }



    public boolean checkLoan(Loan l) {
        System.out.println("check loan");
        if (l.getObject().getClass().getName() == "com.Model.Book") {
            System.out.println("You want to add a book");
            for ( int i = 0; i < books.size(); i++) {
                if(books.get(i).getAuthor().equals(l.getObject().getAuthor()) && books.get(i).getTitle().equals(l.getObject().getTitle()))
                    return true;
            }
            return false;
        }
        else
        if (l.getObject().getClass().getName() == "com.Model.Movie") {
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
        Client c = new Client();
        c.readData();
        int indexC = findCIndex(c);

        ObjectLoaned object;
        System.out.println("Do you want to loan a book or a movie? ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String obj = "";

        int indexO = 0;
        String type;

        try {
            obj = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (obj) {
            case "book": {
                object = new Book();
                object.readData();
                indexO = findIndexO(object);
                type = "book";
                break;
            }
            case "movie": {

                object = new Movie();
                object.readData();
                indexO = findIndexO(object);
                type = "movie";
                break;
            }
            default: {
                object = new ObjectLoaned();
                type = "no";
                break;
            }
        }

        Date loanDate = new Date();
        System.out.println("Loan date");
        loanDate.readData();

        Date returnDate = loanDate.addDays(14);
        System.out.println("Index obj = " + indexO);

        Loan l;
        if(indexC == -1) {
            if (indexO == -1)
                l = new Loan(c, object, loanDate, returnDate);
            else if ( type == "book")
                l = new Loan(c, books.get(indexO),loanDate,returnDate);
            else l = new Loan(c, movies.get(indexO),loanDate,returnDate);
        }
        else {
            if (indexO == -1)
                l = new Loan(clients.get(indexC), object, loanDate, returnDate);
            else if ( type == "book")
                l = new Loan(clients.get(indexC), books.get(indexO),loanDate,returnDate);
            else l = new Loan(clients.get(indexC), movies.get(indexO),loanDate,returnDate);
        }

        if(checkLoan(l)) {
            if (l.getObject().isAvailable()) {
                loans.add(l);

                if (l.getObject().getClass().getName() == "com.Model.Book")
                l.addToFile(inputFiles.getLoanBookFile());
                else if (l.getObject().getClass().getName() == "com.Model.Movie") {
                    l.addToFile(inputFiles.getLoanMovieFile());
                }
                System.out.println("Loan added");

                if (!clients.contains(l.getClient())) {
                    clients.add(l.getClient());
                    l.getClient().addToFile(inputFiles.getClientFile());
                }
            }
            else System.out.println("The object is not available");
        }
        else  {
            System.out.println("The object doesn't exist in our library");
        }
    }

    public int findIndexO(ObjectLoaned o) {
        if (o.getClass().getName() == "com.Model.Book") {
            for (int i = 0; i < books.size(); i++)
                if (books.get(i).getTitle().equals(o.getTitle()) && books.get(i).getAuthor().equals(o.getAuthor()) && books.get(i).getShelf().equals(o.getShelf()) && books.get(i).getPublisher().getName().equals(o.getPublisherName()) && books.get(i).getPublisherAddress().equals(o.getPublisherAddress()))
                    return i;
            return -1;
        }
        else if (o.getClass().getName() == "com.Model.Movie") {
            for (int i = 0; i < movies.size(); i++) {
                if (movies.get(i).getShelf().equals(o.getShelf())){
                    if (movies.get(i).getTitle().equals(o.getTitle())) {
                        if (movies.get(i).getGenre().equals(o.getGenre())) {
                            if (movies.get(i).getRating().equals(o.getRating())) {
                                return i;

                            } else System.out.println("rating");
                        } else System.out.println("genre");
                    } else System.out.println("title");
                } else System.out.println("shelf");
            }
            return -1;
    }
        return -1;
    }

    public void addClient(){
        Client c = new Client();
        c.readData();
        c.addToFile(inputFiles.getClientFile());
        clients.add(c);
    }
    public void addEmployee() {
        Employee e = new Employee();
        e.readData();
        e.addToFile(inputFiles.getEmployeeFile());
        employees.add(e);
    }
    public boolean findBook(String title, String author) {
        for ( int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title) && books.get(i).getAuthor().equals(author) )
                return true;
        }
        return false;
    }

    public int findBIndex(Book b) {
        for (int i = 0; i < books.size(); i++)
            if (books.get(i).egal(b))
                return i;
        return -1;
    }

    public int findMIndex(Movie m) {
        for (int i = 0; i < movies.size(); i++)
            if (movies.get(i).egal(m))
                return i;
        return -1;
    }

    public int findCIndex(Client c) {
        for (int i = 0; i < clients.size(); i++)
            if (clients.get(i).egal(c))
                return i;
        return -1;
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
            if (loans.get(i).getObject().getClass().getName() == "com.Model.Book") {
                if (!returnedObject(loans.get(i))) {
//                    System.out.println(books.size());
                    idx = getBookIndex(loans.get(i).getObject().getID());
//                    System.out.println(idx);
                    books.get(idx).setAvailable(true);
                } else {
                    idx = getBookIndex(loans.get(i).getObject().getID());
                    books.get(idx).setAvailable(false);

                }
            }
            else if (loans.get(i).getObject().getClass().getName() == "com.Model.Movie") {
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

    public void readBooksFromFile(String fileName) {
        File log = new File(fileName);
        try {
            Scanner inputStream = new Scanner(log);
            inputStream.nextLine();
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] values = data.split(",");
                Book book = new Book(values);
                books.add(book);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void readMoviesFromFile(String fileName) {
        File log = new File(fileName);
        try {
            Scanner inputStream = new Scanner(log);
            inputStream.nextLine();
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] values = data.split(",");
                Movie movie = new Movie(values);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void readClientsFromFile(String fileName) {
        File log = new File(fileName);
        try {
            Scanner inputStream = new Scanner(log);
            inputStream.nextLine();
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] values = data.split(",");
               Client client = new Client(values);
               clients.add(client);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void readLoansFromFile(String fileName1, String fileName2) {
        File log = new File(fileName1);
        try {
            Scanner inputStream = new Scanner(log);
            inputStream.nextLine();
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] values = data.split(",");
                Loan loan = new Loan (values);
                loans.add(loan);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        log = new File(fileName2);
        try {
            Scanner inputStream = new Scanner(log);
            inputStream.nextLine();
            while (inputStream.hasNext()) {


                String data = inputStream.nextLine();
                String[] values = data.split(",");
                Loan loan = new Loan (values);
                loans.add(loan);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readEmployeesFromFile(String fileName) {
        File log = new File(fileName);
        try {
            Scanner inputStream = new Scanner(log);
            inputStream.nextLine();
            while (inputStream.hasNext()) {
                String data = inputStream.nextLine();
                String[] values = data.split(",");
                Employee employee = new Employee(values);
                employees.add(employee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
