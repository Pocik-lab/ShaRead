package com.company;

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
                if(menu.isActive)
                    menuInput();
                else
                    window.input();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("До свидания!");
    }

    public void menuInput() throws Exception {
        window.save();
        menu.display();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.equals("m")){
             window.display();
            }
        else if(isInt(input) && Integer.parseInt(input) == 0)
                exit = true;
        else if(isInt(input) && Integer.parseInt(input)>0 && Integer.parseInt(input)<8){
                window = menu.createWindow(window, Integer.parseInt(input));
                window.display();
        }
        menu.isActive = false;
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
