package com.company;

public abstract class Window {

    protected String name;
    protected String title;
    protected Menu menu;

    public Window(String name, String title, Menu menu) {
        this.name = name;
        this.title = title;
        this.menu = menu;
    }

    public void display() {
        System.out.println("Меню - m\n");
    }

    ;

    public abstract void save();

    public void input() {
        if (Controller.sc.nextLine().equals("m")) {
            this.save();
            menu.isActive = true;
        }
    }
}
