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
        if (menu.getUser().equals("child"))
            System.out.println("\nНаписать аннотацию - w");
        System.out.println("Выбрать аннотацию - f");
        super.display();
    }

    public void chooseAnnotation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nВведите название аннотации:");

        for (BookAnnotation i:annotations){
            if(i.name.equals(sc.nextLine())){
                Controller.window = new AnnotationWindow(title,name,menu,i,false);
                Controller.window.display();
                return;
            }
        }

        System.out.println("Аннотация не найдена!\n");
        display();
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
        else if( inp.equals("w") && (menu.getUser().equals("child")) ){
            BookAnnotation curAnnotation = new BookAnnotation("","");
            annotations.add(curAnnotation);
            Controller.window = new AnnotationWindow(title, name, menu, curAnnotation, true);
            Controller.window.display();
        }
        else {
            System.out.println("Такой команды нет\n");
            display();
        }
    }

    @Override
    public void save() {
    }
}
