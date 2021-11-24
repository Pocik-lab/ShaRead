package com.company;

public class Main {

    public static void main(String[] args) {
        Loader.loadListBook();
        Loader.loadListAnnotation();
        Loader.loadBook("/Users/aleksandrtegin/Desktop/JavaLabs/KPO/books/colobok.txt");
        Controller controller = new Controller();
        controller.start();
        Loader.saveBooks();
        Loader.saveAnnotation();
    }
}
