package com.company;

public class Main {

    public static void main(String[] args) {
        Loader.startLoad();
        Controller controller = new Controller();
        controller.start();
    }
}
