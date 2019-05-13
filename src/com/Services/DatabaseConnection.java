package com.Services;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {
    static Connection connection = null;
    static String databaseName = "librarymanager";
    static String url = "jdbc:mysql://localhost:3306/" + databaseName;

    static String userName = "root";
    static String password = "denisa2211";
}


