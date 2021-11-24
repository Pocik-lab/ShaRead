package com.company;

import java.util.ArrayList;

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
        if (books.isEmpty())
        {
            System.out.println("Книг нет!\n");
            Controller.window.display();
            return;
        }
        System.out.println("\nВведите название книги:");
        for (Book i:books){
            if(i.name.equals(Controller.sc.nextLine())){
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
        if (books.isEmpty())
        {
            System.out.println("Книг нет!\n");
            Controller.window.display();
            return;
        }
        System.out.println("\nВведите название книги:");
        for (Book i:books){
            if(i.name.equals(Controller.sc.nextLine())){
                Controller.window = new BookWindow(title,name,menu,i);
                Controller.window.display();
                return;
            }
        }
        System.out.println("Книга не найдена!\n");
        display();
    }

    public void addBook(){
        System.out.println("\nВведите полный путь к файлу:");
        String path = Controller.sc.nextLine();
        Loader.loadBook(path);
        display();
    }

    @Override
    public void input(){
        String inp = Controller.sc.nextLine();
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
