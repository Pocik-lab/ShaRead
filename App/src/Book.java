package com.company;

import java.util.ArrayList;

public class Book {
    public String name;
    public String author;
    public int lastPage;

    public ArrayList<String> pages;

    public Book(String name, String author){
        this.name = name;
        this.author = author;
    }

    public int countPage(){
        return pages.size()+1;
    }
}
