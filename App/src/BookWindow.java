package com.company;

import java.util.Scanner;

public class BookWindow extends Window{
    public static Book curBook;

    public BookWindow(String title, String name, Menu menu,Book curBook){
        super(name,title,menu);
        this.curBook = curBook;
    }

    @Override
    public void display(){
        curBook.displayCurPage();
        System.out.println("\nВернуться к списку книг - b");
        super.display();
    }

    @Override
    public void save(){
    }

    public void changePage(int offset){
        if(curBook.curPage + offset > -1 && curBook.curPage + offset < curBook.countPage() )
            curBook.curPage += offset;
    }

    @Override
    public void input(){
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        if(inp.equals("m")){
            this.save();
            menu.isActive = true;
        }
        else if(inp.equals("n") && curBook.curPage < curBook.countPage() - 1){
            changePage(1);
            display();
        } else if(inp.equals("p") && curBook.curPage > 0){
            changePage(-1);
            display();
        }
        else if(inp.equals("b")) {
            Controller.window = new BooksWindow("Books", "Книги", menu);
            Controller.window.display();
        } else {
            System.out.println("Такой команды нет!\n");
            Controller.window.display();
        }
    }
}
