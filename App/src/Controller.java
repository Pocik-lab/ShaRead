package com.company;

import java.util.Scanner;

public class Controller {
    public static Scanner sc;
    public static Window window;
    public Menu menu;

    private boolean exit;

    public boolean getExit(){
        return this.exit;
    }

    public Controller(){
        sc = new Scanner(System.in);
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
        String input = sc.nextLine();
        try{
            if(input.equals("m")){
                window.display();
                menu.isActive = false;
            }
            else if(isInt(input) && Integer.parseInt(input) == 0)
                exit = true;
            else if(isInt(input) && Integer.parseInt(input)>0 && Integer.parseInt(input)<9 && BookWindow.curBook != null){
                menu.isActive = false;
                window = menu.createWindow(window, Integer.parseInt(input));
                if(!menu.isActive)
                    window.display();
            }
            else if(isInt(input) && Integer.parseInt(input)>1 && Integer.parseInt(input)<9){
                menu.isActive = false;
                window = menu.createWindow(window, Integer.parseInt(input));
                if(!menu.isActive)
                    window.display();
            }
            else {
                System.out.println("Введите заново!\n");
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
