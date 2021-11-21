package com.company;

public class Main {

    public static void main(String[] args) {
        Loader.startLoad();
        Loader.load("D:/University/ShaRead/books/","colobok.txt");
        Controller controller = new Controller();
        controller.start();
        Loader.saveBooks();
    }
}
