package com.fmi.tema1;

import com.Model.Book;
import com.Model.Library;
import com.Model.ObjectLoaned;
import com.Services.Command;
import com.Services.ReadLibraryFromDatabase;


public class MainClass {

    public static void main(String[] args) {
//        Command c = new Command();
//        c.start();
//        Date d = new Date();
//        d.readData();
//        d.printData();

        Library l = new Library();
        ReadLibraryFromDatabase.readAll(l);
//        l.printBooks();
//        l.printMovies();
        l.printClients();
    }
}
