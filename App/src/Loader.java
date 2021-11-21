package com.company;


public class Loader {

    //Загружает добавленные книги при старте программы
    public static boolean startLoad(){
        BooksWindow.books = null;
        return true;
    }

    //Загружает новую книгу в коллекцию книг
    public static boolean load(String path){
        BooksWindow.books.add(new Book("Добро", "Зло"));
        return true;
    }
}
