package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class AnnotationsWindow extends Window {
    public static ArrayList<BookAnnotation> annotations = new ArrayList<>();

    public AnnotationsWindow(String name, String title, Menu menu){
        super(name,title,menu);
    }

    @Override
    public void display() {
        for (BookAnnotation i:annotations) {
            System.out.println(i.name);
            System.out.println("_________________");
        }
        System.out.println("написать аннотацию - w");
        System.out.println("выбрать аннотацию - f");
        System.out.println("меню - m");
    }

    public void chooseAnnotation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название аннотации:");
        for (BookAnnotation i:annotations){
            if(i.name.equals(sc.nextLine())){
                Controller.window = new AnnotationWindow(title,name,menu,i,false);
                Controller.window.display();
            }
        }
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        if(inp.equals("m")){
            this.save();
            menu.isActive = true;
        }
        else if(inp.equals("f") ){
            chooseAnnotation();
        }
        else if(inp.equals("w")){
            BookAnnotation curAnnotation = new BookAnnotation("","");
            annotations.add(curAnnotation);
            Controller.window = new AnnotationWindow(title, name, menu, curAnnotation, true);
            Controller.window.display();
        }
        else {
            System.out.println("Такой аннотации нет.");
            display();
        }
    }

    @Override
    public void save() {

    }
}
