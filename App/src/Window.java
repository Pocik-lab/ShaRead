package com.company;

/**
 * @author kondima
 * @version 1.0.0
 */

import java.util.Scanner;

/** Common class for windows*/
public abstract class Window {

    protected String name;
    protected String title;
    protected Menu menu;

    public Window(String name, String title, Menu menu){
        this.name = name;
        this.title = title;
        this.menu = menu;
    }

    public void display(){
        System.out.println("Меню - m\n");
    };
    public abstract void save();

    public void input(){
        Scanner sc = new Scanner(System.in);
        if(sc.nextLine().equals("m")){
            this.save();
            menu.isActive = true;
        }
    }
}
