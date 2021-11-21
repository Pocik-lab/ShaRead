package com.company;

import java.util.ArrayList;

public class BooksWindow extends Window{
    public static ArrayList<Book> books;

    public BooksWindow(String name, String title, Menu menu){
        super(name,title,menu);
    }

    @Override
    public void display() {
        for (Book i:books) {
            System.out.println(i.name);
            System.out.println(i.author);
            System.out.println("_________________");
        }
    }

    @Override
    public void save() {

    }
}
