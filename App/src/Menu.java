package com.company;

import java.util.Properties;

public class Menu {
    public Properties props;
    private String user;
    public boolean isActive;


    public String getUser() {
        return user;
    }

    public Menu(String user){
        this.isActive = false;
        this.user = user;
    }

    public Window createWindow(Window tempWindow, int number) throws Exception {
        String name;
        String title;
        Window resultWindow = null;

        switch (number){
            case 1:
                name = "LastPageWindow";
                title = "Последняя страница";
                resultWindow = new BookWindow(name, title, this, BookWindow.curBook);
                break;
            case 2:
                name = "Books";
                title = "Книги";
                resultWindow = new BooksWindow(name, title, this);
                break;
            case 3:
                name = "Annotations";
                title = "Аннотации";
                resultWindow = new AnnotationsWindow(name, title, this);
                break;
            case 4:
                name = "Tasks";
                title = "Задания";
           //     resultWindow = new TasksWindow(name, title, this);
                break;
            case 5:
                name = "Progress";
                title = "Прогресс";
              //  resultWindow = new ProgressWindow(name, title, this);
                break;
            case 6:
                name = "Achievement";
                title = "Достижения";
           //     resultWindow = new AchievementWindow(name, title, this);
                break;
            case 7:
                    if (user.equals("parent")){
                        user = "child";
                        resultWindow = tempWindow;
                    }
                    else if(user.equals("child")) {
                        for (int i = 0; i < 3; i++) {
                            boolean success = Authentication.enter();
                            if (success) {
                                user = "parent";
                                break;
                            } else
                                System.out.println("Количество попыток - " + Integer.toString(2 - i));
                            resultWindow = tempWindow;
                            if (i == 2) {
                                System.out.println("Количество попыток закончилось");
                            }
                        }
                    }
                    else throw new Exception("Alien!");
                    break;
            case 8:
                name = "About";
                title = "О приложении";
                resultWindow = new AboutWindow(name, title, this);
                break;
            default:
                throw new Exception("Блять, нет такого окна!");
        }
        return resultWindow;
    }

    public void display(){
        System.out.println("ShaRead");
        if(BookWindow.curBook != null)  System.out.println("Последняя страница ---> 1");
        System.out.println("Книги ---> 2");
        System.out.println("Аннотации ---> 3");
        System.out.println("Задания ---> 4");
        System.out.println("Прогесс ---> 5");
        System.out.println("Достижения ---> 6");
        System.out.println((user.equals("parent")? "Родитель" : "Ребенок") + " ---> 7");
        System.out.println("О приложении ---> 8");
        System.out.println("Свернуть меню ---> m");
        System.out.println("Выйти из приложения ---> 0");
    }
}
