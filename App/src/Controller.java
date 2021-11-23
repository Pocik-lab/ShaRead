package com.company;

import java.security.spec.ECField;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    public static Window window;
    public Menu menu;

    private boolean exit;

    public Controller(){
        exit = false;
        this.menu = new Menu("child");
        this.window = new BooksWindow("Books", "Книги", menu);
    }

    public void start(){
        window.display();
        while (!exit){
            try {
                if(menu.isActive){
                    menu.display();
                    menuInput();
                }
                else
                    window.input();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("До свидания!");
    }

    public void menuInput() {
        window.save();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        try{
            if(input.equals("m")){
                window.display();
            }
            else if(isInt(input) && Integer.parseInt(input) == 0)
                exit = true;
            else if(isInt(input) && Integer.parseInt(input)>0 && Integer.parseInt(input)<9 && BookWindow.curBook != null){
                window = menu.createWindow(window, Integer.parseInt(input));
                menu.isActive = false;
                window.display();

            }
            else if(isInt(input) && Integer.parseInt(input)>1 && Integer.parseInt(input)<9){
                window = menu.createWindow(window, Integer.parseInt(input));
                menu.isActive = false;
                window.display();
            }
            else {
                System.out.println("Введите заново!");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isInt(String string) {
        boolean CorrectValues;
        try {
            Integer.parseInt(string);
            CorrectValues = true;
        }
        catch (NumberFormatException e){
            CorrectValues = false;
            e.printStackTrace();
        }
        return CorrectValues;
    }

}
