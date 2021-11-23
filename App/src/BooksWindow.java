package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class BooksWindow extends Window{
    public static ArrayList<Book> books = new ArrayList<>();

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
        System.out.println("Введите f чтобы выбрать книгу");
        System.out.println("m - меню");
    }

    @Override
    public void save(){}

    public void chooseBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название книги:");
        for (Book i:books){
            if(i.name.equals(sc.nextLine())){
                Controller.window = new BookWindow(title,name,menu,i);
                Controller.window.display();
            }
        }
    }

    @Override
    public void input(){
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        if(inp.equals("m")){
            this.save();
            menu.isActive = true;
        }
        else if(inp.equals("f")){
            chooseBook();
        }
    }
}
