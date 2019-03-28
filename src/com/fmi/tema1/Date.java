package com.fmi.tema1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Date {
    public Integer day;
    public Integer month;
    public Integer year;

    public Date addDays(int days) {
        Date returnDay = new Date();
        days += day;
        if(days < 30) {
            returnDay.day = days;
            returnDay.month = month;
            returnDay.year = year;
        }
        else
        {
            int returnMonths = days / 30;
            if (month + returnMonths <= 12) {
              returnDay.day = days % 30;
              returnDay.month = month + returnMonths;
              returnDay.year = year;
            }
            else {
                returnDay.day = days % 30;
                returnDay.year = year + (returnMonths + month) / 12;
                returnDay.month = (returnMonths + month) % 12;
            }
        }
        return returnDay;
    }

    public void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String bd = reader.readLine();
            strToDate(bd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void strToDate(String bd) {
        Integer x;
        x = bd.charAt(0) - '0';
        x = x*10;
        x = x + (bd.charAt(1) - '0');
        day = x;

        x = 0;
        x = bd.charAt(3) - '0';
        x = x*10;
        x = x + (bd.charAt(4) - '0');
        month = x;

        x = 0;
        x = bd.charAt(6) - '0';
        x = x*10;
        x = x + (bd.charAt(7) - '0');
        x = x*10;
        x = x + (bd.charAt(8) - '0');
        x = x*10;
        x = x + (bd.charAt(9) - '0');
        year = x;
    }

    public void printData() {
        System.out.println(day + "." + month + "." + year);
    }

    public Date(Integer day, Integer month, Integer year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public Date() {
        day = month = year = 0;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
