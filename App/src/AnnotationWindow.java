package com.company;

import java.util.Scanner;

public class AnnotationWindow extends Window{
    BookAnnotation curAnnotation;
    Boolean isWriting;

    AnnotationWindow(String name, String title, Menu menu, BookAnnotation curAnnotation, boolean isWriting){
        super(name, title, menu);
        this.curAnnotation = curAnnotation;
        this.isWriting = isWriting;
    }


    @Override
    public void display() {
        if(isWriting){
            if(curAnnotation.name.equals("")){
                System.out.println("Введите название аннотации: ");
            }
            else{
                System.out.println("Чтобы завершить ввод нажмите ENTER 2 раза.");
                System.out.println("Пишите аннотацию:");
            }
        }
        else {
            curAnnotation.display();
            System.out.println("===============\nменю - m");
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void input(){
        Scanner sc = new Scanner(System.in);
        if(!isWriting){
            String inp = sc.nextLine();
            if(inp.equals("m")){
                this.save();
                menu.isActive = true;
            }
        }
        else {
            if(curAnnotation.name.equals("")) curAnnotation.name = sc.nextLine();
            else if(curAnnotation.text.equals("")) {
                display();
                curAnnotation.text = "";
                while(true){
                    String current = sc.nextLine();
                    if(current.equals(""))break;
                    curAnnotation.text = String.join("\n",curAnnotation.text ,current);
                }
            }
            else {
                Controller.window = new AnnotationsWindow("Annotations", "Аннотации", menu);
                Controller.window.display();
            }
        }
    }
}
