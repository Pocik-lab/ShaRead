package com.company;

public class TasksWindow extends Window {
    public TasksWindow(String name, String title, Menu menu) {
        super(name, title, menu);
    }

    @Override
    public void display() {
        System.out.println("Прочитать 20 страниц");
        super.display();
    }

    @Override
    public void save() {

    }
}
