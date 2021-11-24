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
        System.out.println("\nОткрыть книгу - f");
        if (menu.getUser().equals("parent"))
            System.out.println("Удалить книгу - d");
        System.out.println("Добавить книгу - e");
        super.display();
    }

    @Override
    public void save(){}

    public void deleteBook(){
        Scanner sc = new Scanner(System.in);
        if (books.isEmpty())
        {
            System.out.println("Книг нет!\n");
            return;
        }
        System.out.println("\nВведите название книги:");
        for (Book i:books){
            if(i.name.equals(sc.nextLine())){
                books.remove(i);
                System.out.println("Книга удалена!\n");
                Controller.window.display();
                return;
            }
        }
        System.out.println("Книга не найдена!\n");
        display();
    }

    public void chooseBook(){
        Scanner sc = new Scanner(System.in);
        if (books.isEmpty())
        {
            System.out.println("Книг нет!\n");
            return;
        }
        System.out.println("\nВведите название книги:");
        for (Book i:books){
            if(i.name.equals(sc.nextLine())){
                Controller.window = new BookWindow(title,name,menu,i);
                Controller.window.display();
                return;
            }
        }
        System.out.println("Книга не найдена!\n");
        display();
    }


    public void addBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nВведите полный путь к файлу:");
        String path = sc.nextLine();
        Loader.loadBook(path);
        display();
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
        else if(inp.equals("d") && menu.getUser().equals("parent")){
            deleteBook();
        }
        else if(inp.equals("e")){
            addBook();
        }
        else {
            System.out.println("Такой команды нет!\n");
            display();
        }
    }
}
