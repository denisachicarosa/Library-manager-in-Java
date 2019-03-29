package com.Services;

import com.fmi.tema1.Book;
import com.fmi.tema1.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Command {
    private Library library;
    public Command(){
        library = new Library();
        library.updateBooks();
        //library.readData();
        printMenu();
        int command;
        Scanner in = new Scanner(System.in);
        command = in.nextInt();
        while (command != 0) {
            switch (command) {
                case 1: {
                    library.printData();
                    break;
                }
                case 2: {
                    library.sortBooks();
                    library.printBooks();
                    break;
                }
                case 3: {
                    library.printClients();
                    break;
                }
                case 4: {
                    library.printLoans();
                    break;
                }
                case 5: {
                    library.addLoan();
                    break;
                }
                case 6: {
                    library.addBook();
                    break;
                }
                case 7: {
                    library.addClient();
                    break;
                }
                case 8: {
                    library.addEmployee();
                    break;
                }
                case 9: {
                    String name = "", author = "";
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        System.out.println("Title : ");
                        name = reader.readLine();
                        System.out.println("Author : ");
                        author = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (library.findBook(name, author) == true) System.out.println("The book exists in our library");
                    else
                        System.out.println("The book doesn't exist in our library");
                    break;
                }
                case 10: {
                    String name = "", author = "";
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        System.out.println("Title : ");
                        name = reader.readLine();
                        System.out.println("Author : ");
                        author = reader.readLine();
                        boolean available;
                        available = library.checkAvailable(name,author);
                        if (available)
                            System.out.println("The book is available");
                        else System.out.println("The book is not available");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 11: {
                    library.printEndedLoans();
                    break;
                }
                case 12: {
                    System.out.println(library.nrEmployees());
                    break;
                }
                case 13: {
                    System.out.println(library.getMaxSalary());
                    break;
                }
                default: {
                    System.out.println("The command doesn't exist");
                }
            }

            printMenu();
            System.out.println();
            System.out.println("The next command is: ");
            command = in.nextInt();
        }
    }

    public void printMenu(){
        System.out.println("------>  Menu  <------");
        System.out.println();
        System.out.println("1. Get all the information about the library");
        System.out.println("2. Get the books in alphabetically order");
        System.out.println("3. Get all the clients");
        System.out.println("4. Get all the loans");
        System.out.println("5. Create a new loan paper");
        System.out.println("6. Add a new book");
        System.out.println("7. Add a new client");
        System.out.println("8. Add a new employee");
        System.out.println("9. Check if a book exists in the library");
        System.out.println("10. Check if a book is available");
        System.out.println("11. Get the clients that have not returned the books yet");
        System.out.println("12. Get the number of employees");
        System.out.println("13. Get the max salary");
        System.out.println("0. Exit menu ");
    }

}
